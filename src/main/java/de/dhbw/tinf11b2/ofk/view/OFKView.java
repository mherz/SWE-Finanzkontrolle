package de.dhbw.tinf11b2.ofk.view;

import com.vaadin.ui.Component;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

/**
 * Funktion für die Verteilung der UI Listener 
 * @author felix
 */
public interface OFKView extends Component{
	
	

	
    public void addListener(OFKViewListener listener);
}
