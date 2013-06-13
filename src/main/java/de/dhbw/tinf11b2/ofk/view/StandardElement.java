package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

public class StandardElement extends CustomComponent implements OFKView,
		ClickListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();

	public StandardElement() {

	}

	public Button zurueckGen() {
		Button zurueck = new Button("Zurück");
		zurueck.setImmediate(true);
		zurueck.setWidth("-1px");
		zurueck.setHeight("-1px");
		return zurueck;
	}
	

	public Label beschrGen() {
		Label beschreibungslabel = new Label();
		beschreibungslabel.setImmediate(false);
		beschreibungslabel.setWidth("-1px");
		beschreibungslabel.setHeight("-1px");
		return beschreibungslabel;
	}
	
	public Label labelGen(){
		Label normaleslabel = new Label();
		normaleslabel.setImmediate(false);
		normaleslabel.setWidth("-1px");
		normaleslabel.setHeight("-1px");
		return normaleslabel;
	}
	
	public TextField textGen(){
		TextField textFeld= new TextField();
		textFeld.setImmediate(false);
		textFeld.setWidth("-1px");
		textFeld.setHeight("-1px");
		return textFeld;
		
	}

	@Override
	public void addListener(OFKViewListener listener) {
		listeners.add(listener);
		System.out.println("Bin geklickt2");

	}
	@Override
	public void buttonClick(ClickEvent event) {
		System.out.println("Bin geklickt3");
		for (OFKViewListener listener : listeners){
			listener.buttonClick(event.getButton().getCaption());
			System.out.println("Bin geklickt");
		}

	}
}
