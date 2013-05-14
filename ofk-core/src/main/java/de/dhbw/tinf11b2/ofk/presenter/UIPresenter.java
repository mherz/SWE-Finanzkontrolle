package de.dhbw.tinf11b2.ofk.presenter;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.dhbw.tinf11b2.ofk.model.OFKModel;
import de.dhbw.tinf11b2.ofk.view.Ausgabenseite;
import de.dhbw.tinf11b2.ofk.view.Einnahmenseite;
import de.dhbw.tinf11b2.ofk.view.LoginSeite;
import de.dhbw.tinf11b2.ofk.view.OFKView;
import de.dhbw.tinf11b2.ofk.view.Startseite;
import de.dhbw.tinf11b2.ofk.view.UeberblickSeite;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class UIPresenter extends UI implements OFKViewListener  {

	private OFKView view = new LoginSeite();
	private OFKModel model = new OFKModel();
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		view.addListener(this);
		setContent(view);

	}
	
	public void pageChangeback (){
		view = new Startseite();
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
			setContent(view);
		}
		if(operation.contentEquals("Ausgabe")){
			view = new Ausgabenseite();
			view.addListener(this);
			setContent(view);
		}
		if(operation.contentEquals("Zurück")){
			this.pageChangeback();
			view.addListener(this);
			setContent(view);
		}
		if(operation.contentEquals("Login")){
			model.authenticate(((LoginSeite) view).getUsername(),((LoginSeite) view).getPassword());
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