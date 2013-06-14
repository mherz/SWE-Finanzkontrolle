package de.dhbw.tinf11b2.ofk.presenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.OFKModel;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;

import de.dhbw.tinf11b2.ofk.view.EingabeSeite;
import de.dhbw.tinf11b2.ofk.view.LoginSeite;
import de.dhbw.tinf11b2.ofk.view.OFKView;
import de.dhbw.tinf11b2.ofk.view.RegisterSeite;
import de.dhbw.tinf11b2.ofk.view.Startseite;
import de.dhbw.tinf11b2.ofk.view.UeberblickSeite;

public class OFKPresenter implements OFKViewListener, Serializable {
	private static final long serialVersionUID = 1L;

	private OFKView view = new LoginSeite();
	private OFKModel model;
	private OFKUI ui;

	public void init(OFKUI ui) {
		this.ui = ui;
		view.addListener(this);
		ui.setContent(view);
	}

	public void pageChangeback() {
		view = new Startseite();
		view.addListener(this);
		ui.setContent(view);
	}

	private void generateEinnahmen() {
		view = new EingabeSeite("Einnahmen", true);
		view.addListener(this);
		List<Account> accList = model.getAccounts();

		String[] kategorien = model.getCategoryNames();
		String[] konten = new String[accList.size()];
		int i = 0;
		for (Account acc : accList) {
			konten[i] = acc.getName();
			i++;
		}
		((EingabeSeite) view).feldErstellung(konten, kategorien);
		ui.setContent(view);
		ui.setContent(view);
	}

	private void generateAusgaben() {

		view = new EingabeSeite("Ausgaben", false);
		view.addListener(this);
		List<Account> accList = model.getAccounts();

		String[] kategorien = model.getCategoryNames();
		String[] konten = new String[accList.size()];
		int i = 0;
		for (Account acc : accList) {
			konten[i] = acc.getName();
			i++;
		}

		((EingabeSeite) view).feldErstellung(konten, kategorien);
		ui.setContent(view);
	}

	@Override
	public void buttonClick(String operation) {
		if (operation.contentEquals("Login")) {
			int returnValue;
			returnValue = model.authenticate(((LoginSeite) view).getUsername(),
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
			model.logout();
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

						model.addCosts(model
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
						model.addIncome(
								model.getCategoryByName(kategorieWerte[wert]),
								Double.parseDouble(geldWerte[wert]),
								kontenWerte[wert]);
					}

					generateEinnahmen();
					((EingabeSeite) view).bestaetige();
				}

			}

		}
		if (operation.contentEquals("WechselA")) {
			System.out.println("Ich bin in dem wechsel");

			((UeberblickSeite) view).wechselDichA(model.getCategoryNames(),
					model.getCostValues());
		}

		if (operation.contentEquals("WechselG")) {
			System.out.println("Ich bin in dem wechsel");

			((UeberblickSeite) view).wechselDichG(model.getCategoryNames(),
					model.getIncomeValues(),model.getCostValues());
		}

		if (operation.contentEquals("WechselE")) {
			System.out.println("Ich bin in dem wechsel E");
			System.out.println(model.getCategories()+" "+ model.getIncomeValues().length);
			((UeberblickSeite) view).wechselDichE(model.getCategoryNames(),
					model.getIncomeValues());
		}
		if (operation.contentEquals("Zurück zum Login")) {
			view = new LoginSeite();
			view.addListener(this);
			ui.setContent(view);
		}

	}

	public OFKModel getModel() {
		return model;
	}

	public void setModel(OFKModel model) {
		this.model = model;
	}

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
			if (geldWerte[i].equals("blanck")
					|| kategorieWerte[i].equals("blanck")
					|| kontenWerte[i].equals("blanck")) {

				if (!geldWerte[i].equals("blanck")
						|| !kategorieWerte[i].equals("blanck")
						|| !kontenWerte[i].equals("blanck")) {
					fehlerzeile = i + 1;
					datenListe.add(6);
					i = 7;
				}

			}

			else {
				try {
					Double doubleTest = Double.parseDouble(geldWerte[i]);
					if (doubleTest > 0){
						
					}
					else {
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
		// setzen der fehler notification oder übergabewerte
		if (datenListe.contains(5) | datenListe.contains(6)|datenListe.contains(7)) {
			codes = new int[1];
			codes[0] = 6;
			if (datenListe.contains(5)) {
				((EingabeSeite) view).warne(fehlerzeile," ");
			} else if (datenListe.contains(7)) {
				((EingabeSeite) view).warne(fehlerzeile," positive ");
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

	public void setView(OFKView view) {
		ui.setContent(view);
		
	}

	public OFKUI getUi() {
		return ui;
	}

	public void setUi(OFKUI ui) {
		this.ui = ui;
	}

}
