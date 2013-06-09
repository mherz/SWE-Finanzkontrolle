package de.dhbw.tinf11b2.ofk.presenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbw.tinf11b2.ofk.model.OFKModel;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.view.Einnahmenseite;
import de.dhbw.tinf11b2.ofk.view.LoginSeite;
import de.dhbw.tinf11b2.ofk.view.OFKView;
import de.dhbw.tinf11b2.ofk.view.Startseite;
import de.dhbw.tinf11b2.ofk.view.UeberblickSeite;

public class OFKPresenter implements OFKViewListener {

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
		if (operation.contentEquals("Einnahmen")) {
			view = new Einnahmenseite("Einnahmen",true);
			view.addListener(this);
			List<Account> accList = model.getAccounts();
			for (Account acc : accList) {
				((Einnahmenseite) view).addToKontoBox(acc.getName());
			}
			((Einnahmenseite) view).addToKategorieBox("default");
			ui.setContent(view);
		}
		if (operation.contentEquals("Ausgabe")) {
			view = new Einnahmenseite("Ausgaben",false);
			view.addListener(this);
			List<Account> accList = model.getAccounts();
			for (Account acc : accList) {
				((Einnahmenseite) view).addToKontoBox(acc.getName());
			}
			((Einnahmenseite) view).addToKategorieBox("default");
			ui.setContent(view);
			ui.setContent(view);
		}
		if (operation.contentEquals("Zurück")) {

			this.pageChangeback();
		}

		if (operation.contentEquals("Werte Speichern")) {

			if (!((Einnahmenseite)view).isEinnahme()) {
				model.addCosts(model.getCategoryByName(((Einnahmenseite) view)
						.getCategoryFieldValue()),
						Double.parseDouble(((Einnahmenseite) view)
								.getGeldFieldValue()), "default");
				view = new Einnahmenseite("Ausgaben",false);
				view.addListener(this);
				ui.setContent(view);
			}
			if (((Einnahmenseite)view).isEinnahme()) {
				model.addIncome(model.getCategoryByName(((Einnahmenseite) view)
						.getCategoryFieldValue()), Double
						.parseDouble(((Einnahmenseite) view)
								.getGeldFieldValue()), "default");
				view = new Einnahmenseite("Einnahmen",true);
				view.addListener(this);
				ui.setContent(view);
			}
		}
		if (operation.contentEquals("Wechsel")) {
			if (((UeberblickSeite) view).getCurrentTab() == 1)
				((UeberblickSeite) view).wechselDich(new String[]{"default","hallo"},new Double[]{500D,300D});
				
			
		}

	}

	public OFKModel getModel() {
		return model;
	}

	public void setModel(OFKModel model) {
		this.model = model;
	}

}
