package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;


import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

/**
 * @author felix
 *
 */
/**
 * @author felix
 *
 */
/**
 * @author felix
 *
 */
/**
 * @author felix
 *
 */
public class StandardElement extends CustomComponent implements OFKView,
		ClickListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();

	/**
	 * 
	 */
	public StandardElement() {

	}
	/**
	 * @return
	 */
	public AbsoluteLayout absoluteGen(){
		AbsoluteLayout mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		return mainLayout;
	}
	/**
	 * @return
	 */
	public ComboBox comboGen(){
		ComboBox erstellung = new ComboBox();
		erstellung.setImmediate(false);
		erstellung.setWidth("-1px");
		erstellung.setHeight("-1px");
		return erstellung;
	}

	/**
	 * @return
	 */
	public Button zurueckGen() {
		Button zurueck = new Button("Zurück");
		zurueck.setImmediate(true);
		zurueck.setWidth("-1px");
		zurueck.setHeight("-1px");
		return zurueck;
	}
	

	/**
	 * @return
	 */
	public Label beschrGen() {
		Label beschreibungslabel = new Label();
		beschreibungslabel.setImmediate(false);
		beschreibungslabel.setWidth("-1px");
		beschreibungslabel.setHeight("-1px");
		beschreibungslabel.setStyleName("ueberschrift");
		return beschreibungslabel;
	}
	
	/**
	 * @return
	 */
	public Label labelGen(){
		Label normaleslabel = new Label();
		normaleslabel.setImmediate(false);
		normaleslabel.setWidth("-1px");
		normaleslabel.setHeight("-1px");
		return normaleslabel;
	}
	/**
	 * @return
	 */
	public Button buttonGen() {
		Button leer = new Button();
		leer.setImmediate(true);
		leer.setWidth("-1px");
		leer.setHeight("-1px");
		return leer;
	}
	
	/**
	 * @return
	 */
	public TextField textGen(){
		TextField textFeld= new TextField();
		textFeld.setImmediate(false);
		textFeld.setWidth("-1px");
		textFeld.setHeight("-1px");
		return textFeld;
		
	}

	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.view.OFKView#addListener(de.dhbw.tinf11b2.ofk.presenter.OFKViewListener)
	 */
	@Override
	public void addListener(OFKViewListener listener) {
		listeners.add(listener);
		System.out.println("Bin geklickt2");

	}
	/* (non-Javadoc)
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {
		System.out.println("Bin geklickt3");
		for (OFKViewListener listener : listeners){
			listener.buttonClick(event.getButton().getCaption());
			System.out.println("Bin geklickt");
		}

	}
}
