package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

public interface OFKView extends Component{
	
	
	List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();
	
    public void addListener(OFKViewListener listener);
}
