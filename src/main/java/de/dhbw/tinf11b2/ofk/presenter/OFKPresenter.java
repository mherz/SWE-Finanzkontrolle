package de.dhbw.tinf11b2.ofk.presenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import de.dhbw.tinf11b2.ofk.model.ActiveUserModel;
import de.dhbw.tinf11b2.ofk.model.CreateModel;
import de.dhbw.tinf11b2.ofk.model.OFKModel;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;

import de.dhbw.tinf11b2.ofk.view.EingabeSeite;
import de.dhbw.tinf11b2.ofk.view.LoginSeite;
import de.dhbw.tinf11b2.ofk.view.OFKView;
import de.dhbw.tinf11b2.ofk.view.RegisterSeite;
import de.dhbw.tinf11b2.ofk.view.Startseite;
import de.dhbw.tinf11b2.ofk.view.UeberblickSeite;

/**
 * Klasse für das Handeln von Ereignissen und die Übergabe von Daten des Models an die View
 * @author felix
 */
public class OFKPresenter implements OFKViewListener, Serializable {
	private static final long serialVersionUID = 1L;
	private de.dhbw.tinf11b2.ofk.view.Koordinaten element = new de.dhbw.tinf11b2.ofk.view.Koordinaten();
	private String blank = element.empty();
	private OFKView view = new LoginSeite();
	private ActiveUserModel activeUser;
	private OFKModel model;
	private OFKUI ui;

	/**
	 * @param ui
	 */
	public void init(OFKUI ui) {
		this.ui = ui;
		view.addListener(this);
		ui.setContent(view);
	}

	/**
	 * Funktion zum Seitenwechsel zur Startseite
	 */
	public void pageChangeback() {
		view = new Startseite();
		view.addListener(this);
		ui.setContent(view);
	}

	/**
	 * Funktion zum Auslesen der Einnahmen
	 */
	private void generateEinnahmen() {
		view = new EingabeSeite("Einnahmen", true);
		view.addListener(this);
		List<Account> accList = activeUser.getAccounts();

		String[] kategorien = activeUser.getCategoryNames();
		String[] konten = new String[accList.size()];
		int i = 0;
		for (Account acc : accList) {
			konten[i] = acc.getName();
			i++;
		}
		((EingabeSeite) view).feldErstellung(konten, kategorien);
		ui.setContent(view);
	}

	/**
	 * Funktion zum Einlesen der Ausgaben
	 */
	private void generateAusgaben() {

		view = new EingabeSeite("Ausgaben", false);
		view.addListener(this);
		List<Account> accList = activeUser.getAccounts();

		String[] kategorien = activeUser.getCategoryNames();
		String[] konten = new String[accList.size()];
		int i = 0;
		for (Account acc : accList) {
			konten[i] = acc.getName();
			i++;
		}

		((EingabeSeite) view).feldErstellung(konten, kategorien);
		ui.setContent(view);
	}

	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.presenter.OFKViewListener#buttonClick(java.lang.String)
	 * Funktion zum Belegen der Buttons mit Aktionen
	 */
	@Override
	public void buttonClick(String operation) {
		if (operation.contentEquals("Login")) {
			int returnValue;
			returnValue = activeUser.authenticate(((LoginSeite) view).getUsername(),
					((LoginSeite) view).getPassword());
			if (returnValue == 1) {
				view = new Startseite();
				view.addListener(this);
				ui.setContent(view);
			} else {
				if (returnValue == 0) {
					((LoginSeite) view)
							.setLabelText("Bitte geben Sie ihr Passwort erneut ein");
				} else {
					((LoginSeite) view).setLabelText("Der Benutzer "
							+ ((LoginSeite) view).getUsername()
							+ " existiert leider nicht");
				}
			}
		}
		if (operation.contentEquals("Ausloggen")) {
			activeUser.logout();
			view = new LoginSeite();
			view.addListener(this);
			ui.setContent(view);
		}

		if (operation.contentEquals("Übersicht")) {
			view = new UeberblickSeite();
			view.addListener(this);
			ui.setContent(view);
		}

		if (operation.contentEquals("Registrieren")) {
			view = new RegisterSeite();
			view.addListener(this);
			ui.setContent(view);
		}
		if (operation.contentEquals("Einnahmen")) {
			generateEinnahmen();
		}
		if (operation.contentEquals("Ausgabe")) {

			generateAusgaben();
		}
		if (operation.contentEquals("Zurück")) {
			System.out.println("Ich bin da");
			this.pageChangeback();
		}

		if (operation.contentEquals("Werte Speichern")) {

			if (!((EingabeSeite) view).isEinnahme()) {
				String[] geldWerte = ((EingabeSeite) view).getGeldFieldValue();
				String[] kategorieWerte = ((EingabeSeite) view)
						.getKategorieFieldValue();
				String[] kontenWerte = ((EingabeSeite) view)
						.getKontoFieldValue();
				int[] daten = datenCodes();
				if (daten[0] <= 4) {
					for (int i = 0; i < daten.length; i++) {

						((CreateModel)model).addCosts(activeUser
								.getCategoryByName(kategorieWerte[daten[i]]),
								Double.parseDouble(geldWerte[daten[i]]),
								kontenWerte[daten[i]]);

					}

					generateAusgaben();
					((EingabeSeite) view).bestaetige();
				}
			}
			if (((EingabeSeite) view).isEinnahme()) {
				String[] geldWerte = ((EingabeSeite) view).getGeldFieldValue();
				String[] kategorieWerte = ((EingabeSeite) view)
						.getKategorieFieldValue();
				String[] kontenWerte = ((EingabeSeite) view)
						.getKontoFieldValue();
				int[] daten = datenCodes();
				if (daten[0] <= 4) {
					for (int i = 0; i < daten.length; i++) {
						int wert = daten[i];
						((CreateModel)model).addIncome(
								activeUser.getCategoryByName(kategorieWerte[wert]),
								Double.parseDouble(geldWerte[wert]),
								kontenWerte[wert]);
					}

					generateEinnahmen();
					((EingabeSeite) view).bestaetige();
				}

			}

		}

		if (operation.contentEquals("WechselA")) {

			((UeberblickSeite) view).wechselDichA(activeUser.getCategoryNames(),
					activeUser.getCostValues(),
					monatsNamen(activeUser.getCostValuesDate()),
					monatsWerte(activeUser.getCostValuesDate()));
		}

		if (operation.contentEquals("WechselG")) {
			System.out.println("Ich bin in dem wechsel");

			((UeberblickSeite) view).wechselDichG(activeUser.getCategoryNames(),
					activeUser.getIncomeValues(), activeUser.getCostValues());
		}

		if (operation.contentEquals("WechselE")) {
			((UeberblickSeite) view).wechselDichE(activeUser.getCategoryNames(),
					activeUser.getIncomeValues(),
					monatsNamen(activeUser.getIncomeValuesDate()),
					monatsWerte(activeUser.getIncomeValuesDate()));
		}
		if (operation.contentEquals("Zurück zum Login")) {
			view = new LoginSeite();
			view.addListener(this);
			ui.setContent(view);
		}

	}

	/**
	 * Funktion zum aufrufen des zu verwendenden Models
	 * @return
	 */
	public OFKModel getModel() {
		return model;
	}

	/**
	 * Funktion zum festlegen des zu verwendenden Models
	 * @param model
	 */
	public void setModel(OFKModel model) {
		this.model = model;
	}

	/**
	 * Funktion zum Überprüfen der Eingaben in die Eingabenseite unabhängig von 
	 * Art
	 * @return
	 * Int Array zum festlegen der darzustellenden Meldung
	 */
	private int[] datenCodes() {

		String[] geldWerte = ((EingabeSeite) view).getGeldFieldValue();
		String[] kategorieWerte = ((EingabeSeite) view)
				.getKategorieFieldValue();
		String[] kontenWerte = ((EingabeSeite) view).getKontoFieldValue();
		List<Integer> datenListe = new ArrayList<Integer>();
		List<Integer> fehler = new ArrayList<Integer>();
		int[] codes;
		int fehlerzeile = 0;

		// überprüfung auf leereingaben
		for (int i = 0; i < 4; i++) {
			if (geldWerte[i].equals(blank)
					|| kategorieWerte[i].equals(blank)
					|| kontenWerte[i].equals(blank)) {

				if (!geldWerte[i].equals(blank)
						|| !kategorieWerte[i].equals(blank)
						|| !kontenWerte[i].equals(blank)) {
					fehlerzeile = i + 1;
					datenListe.add(6);
					i = 7;
				}

			} else {
				try {
					Double doubleTest = Double.parseDouble(geldWerte[i]);
					if (doubleTest < 0) {
						fehlerzeile = i + 1;
						datenListe.add(7);
					}

					datenListe.add(i);
					// überprüfung auf falscheingaben
				} catch (NumberFormatException e) {
					fehler.add(i + 1);
					fehlerzeile = i + 1;
					datenListe.add(5);
				}
			}
		}
		if (datenListe.size() == 0) {
			datenListe.add(10);
		}
		// setzen der fehler notification oder übergabewerte
		if (datenListe.contains(5) | datenListe.contains(6)
				| datenListe.contains(7)|datenListe.contains(10)) {
			codes = new int[1];
			codes[0] = 6;
			if (datenListe.contains(5)) {
				((EingabeSeite) view).warne(fehlerzeile, " ");
			} else if (datenListe.contains(7)) {
				((EingabeSeite) view).warne(fehlerzeile, " positive ");
			} else if (datenListe.contains(10)) {
				((EingabeSeite) view).eingabeLeer();
			} else {
				((EingabeSeite) view).eingabeFehler(fehlerzeile);
			}
		} else {
			codes = new int[datenListe.size()];
			int i = 0;
			for (Integer daten : datenListe) {
				codes[i] = daten;
				i++;
			}
		}
		
		return codes;
	}

	/**
	 *  Funktion zum errechnen der Ausgaben pro Monat über mehrere Jahre Hinweg
	 * @param valuesDate Die Hashmap mit dein eingetragenen Werten
	 * @return Ein Array mit den Einträgen verteilt auf 12 Monate
	 * 
	 */
	private Double[] monatsWerte(HashMap<Integer, Double> valuesDate) {

		HashMap<Integer, Double> costValuesDate = valuesDate;
		Double[] monatsWerte = new Double[costValuesDate.size()];
		int i = 0;

		for (Entry<Integer, Double> e : costValuesDate.entrySet()) {
			monatsWerte[i] = e.getValue();
			i++;
		}

		return monatsWerte;
	}

	/**
	 * Funktion zum Auslesen der zu verwendenden Monatsnamen
	 * @param namesDate Die Hashmap mit den eingetragenen Werten
	 * @return Die Namen der verwendeten Monate
	 * 
	 */
	private String[] monatsNamen(HashMap<Integer, Double> namesDate) {

		HashMap<Integer, Double> costValuesDate = namesDate;
		String[] monatsNamen = new String[costValuesDate.size()];
		int i = 0;
		String[] monate = { "Januar", "Februar", "März", "April", "Mai",
				"Juni", "Juli", "August", "September", "Oktober", "November",
				"Dezember" };
		for (Entry<Integer, Double> e : costValuesDate.entrySet()) {
			monatsNamen[i] = monate[e.getKey()];
			i++;
		}

		return monatsNamen;
	}

	/**
	 *  Funktion zum Festlegen der View
	 * @param view
	 */
	public void setView(OFKView view) {
		ui.setContent(view);
	}

	/**
	 * Funktion zum erhalten des UI Elementes
	 * @return
	 */
	public OFKUI getUi() {
		return ui;
	}

	/**
	 * Funktion zum setzen des UI Elementes
	 * @param ui
	 */
	public void setUi(OFKUI ui) {
		this.ui = ui;
	}

	public ActiveUserModel getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(ActiveUserModel activeUser) {
		this.activeUser = activeUser;
	}

}
