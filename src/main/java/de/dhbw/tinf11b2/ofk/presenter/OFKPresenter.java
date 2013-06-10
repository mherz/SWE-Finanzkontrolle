package de.dhbw.tinf11b2.ofk.presenter;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.OFKModel;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
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
		view = new EingabeSeite("Einnahmen", false);
		view.addListener(this);
		List<Account> accList = model.getAccounts();
		List<Category> categoryList = model.getCategories();
		String[] kategorien = new String [categoryList.size()];
		String[] konten = new String[accList.size()];
		int i = 0;
		for (Account acc : accList) {
			konten[i] = acc.getName();
			i++;
		}
		i= 0;
		for (Category cat: categoryList){
			kategorien[i]= cat.getName();
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
		List<Category> categoryList = model.getCategories();
		String[] kategorien = new String [categoryList.size()];
		String[] konten = new String[accList.size()];
		int i = 0;
		for (Account acc : accList) {
			konten[i] = acc.getName();
			i++;
		}
		i= 0;
		for (Category cat: categoryList){
			kategorien[i]= cat.getName();
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
		if (operation.contentEquals("Registrieren")
				|| operation.contentEquals("Zurück zum Login")) {
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

			this.pageChangeback();
		}

		if (operation.contentEquals("Werte Speichern")) {

			if (!((EingabeSeite) view).isEinnahme()) {
				String[] geldWerte = ((EingabeSeite) view).getGeldFieldValue();
				String[] kategorieWerte = ((EingabeSeite) view)
						.getKategorieFieldValue();
				String[] kontenWerte = ((EingabeSeite) view)
						.getKontoFieldValue();

				for (int i = 0; i < 4; i++) {
					if (geldWerte[i].equals("blanck")
							| kategorieWerte[i].equals("blanck")
							| kontenWerte[i].equals("blanck")) {
					} else {
						model.addCosts(
								model.getCategoryByName(kategorieWerte[i]),
								Double.parseDouble(geldWerte[i]),
								kontenWerte[i]);
						System.out.println(kategorieWerte[i]+ "  "+ geldWerte[i]+ "  "+ kontenWerte[i]);
					}

				}

				generateAusgaben();
				((EingabeSeite) view).bestaetige();
			}
			if (((EingabeSeite) view).isEinnahme()) {
				String[] geldWerte = ((EingabeSeite) view).getGeldFieldValue();
				String[] kategorieWerte = ((EingabeSeite) view)
						.getKategorieFieldValue();
				String[] kontenWerte = ((EingabeSeite) view)
						.getKontoFieldValue();
				for (int i = 0; i < 4; i++) {
					if (geldWerte[i].equals("blanck")
							| kategorieWerte[i].equals("blanck")
							| kontenWerte[i].equals("blanck")) {
					} else {
						model.addIncome(
								model.getCategoryByName(kategorieWerte[i]),
								Double.parseDouble(geldWerte[i]),
								kontenWerte[i]);
					}

				}
				generateEinnahmen();

				((EingabeSeite) view).bestaetige();
			}

		}
		if (operation.contentEquals("WechselA")) {
			System.out.println("Ich bin in dem wechsel");

			((UeberblickSeite) view).wechselDichA(model.getCategoryNames(),
					model.getIncomeValues());
		}

		if (operation.contentEquals("WechselG")) {
			System.out.println("Ich bin in dem wechsel");

			((UeberblickSeite) view).wechselDichG(model.getCategoryNames(),
					model.getIncomeValues());
		}

		if (operation.contentEquals("WechselE")) {
			System.out.println("Ich bin in dem wechsel");

			((UeberblickSeite) view).wechselDichE(model.getCategoryNames(),
					model.getIncomeValues());
		}

	}

	public OFKModel getModel() {
		return model;
	}

	public void setModel(OFKModel model) {
		this.model = model;
	}

}
