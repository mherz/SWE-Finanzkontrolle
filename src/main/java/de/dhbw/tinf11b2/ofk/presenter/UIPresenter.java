package de.dhbw.tinf11b2.ofk.presenter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.dhbw.tinf11b2.ofk.model.OFKModel;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.model.pojo.User;
import de.dhbw.tinf11b2.ofk.view.Ausgabenseite;
import de.dhbw.tinf11b2.ofk.view.Einnahmenseite;
import de.dhbw.tinf11b2.ofk.view.LoginSeite;
import de.dhbw.tinf11b2.ofk.view.OFKView;
import de.dhbw.tinf11b2.ofk.view.Startseite;
import de.dhbw.tinf11b2.ofk.view.UeberblickSeite;

/**
 * Main UI class
 */
@Scope("request")
@SuppressWarnings("serial")
public class UIPresenter extends UI implements OFKViewListener  {
	
	User currentUser;
	@Autowired
	private OFKView view;
	@Autowired
	private OFKModel model;
	
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		view.addListener(this);
		setContent(view);
		System.out.println(this);
		System.out.println(view);

	}
	
	public void pageChangeback (){
		view = new Startseite();
		view.addListener(this);
		setContent(view);
	}

	@Override
	public void buttonClick(String operation) {
		if(operation.contentEquals("Übersicht")){
			view = new UeberblickSeite();
			view.addListener(this);
			setContent(view);
		}
		if(operation.contentEquals("Einnahmen")){
			view = new Einnahmenseite();
			view.addListener(this);
			List<Account> accList = model.getAccounts();
//			List<Category> catList = model.getCategories();
			for(Account acc : accList){
				((Einnahmenseite)view).addToKontoBox(acc.getName());
			}
//			for(Category cat : catList){
//				((Einnahmenseite)view).addToKategorieBox(cat.getName());
//			}
			((Einnahmenseite)view).addToKategorieBox("default");
			setContent(view);
		}
		if(operation.contentEquals("Ausgabe")){
			view = new Ausgabenseite();
			view.addListener(this);
			setContent(view);
		}
		if(operation.contentEquals("Zurück")){
			this.pageChangeback();
		}
		
		if(operation.contentEquals("Werte Speichern")){
			model.addIncome(Double.parseDouble(((Einnahmenseite)view).getGeldFieldValue()), "default");
			view = new Einnahmenseite();
			view.addListener(this);
			setContent(view);
		}
		if(operation.contentEquals("Login")){
			System.out.println(view);
			int returnValue;
			returnValue = model.authenticate(((LoginSeite) view).getUsername(),((LoginSeite) view).getPassword());
			if(returnValue==1){
				view = new Startseite();
				setContent(view);
			} else {
				if(returnValue==0){
					((LoginSeite) view).setLabelText("Bitte geben Sie ihr Passwort erneut ein");
				} else{
					((LoginSeite) view).setLabelText("Der Benutzer "+((LoginSeite)view).getUsername()+" existiert leider nicht");
				}
			}

			}
	}

	public OFKView getView() {
		return view;
	}

	public void setView(OFKView view) {
		this.view = view;
	}

	public OFKModel getModel() {
		return model;
	}
	
	public void setModel(OFKModel model) {
		this.model = model;
	}
	
	

}