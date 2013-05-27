package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

public interface OFKView extends Component{
	
	

	
    public void addListener(OFKViewListener listener);
}
