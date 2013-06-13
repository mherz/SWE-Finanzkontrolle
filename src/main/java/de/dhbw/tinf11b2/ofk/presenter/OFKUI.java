package de.dhbw.tinf11b2.ofk.presenter;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.dhbw.tinf11b2.ofk.view.OFKView;



/**
 * Main UI class
 */
@SuppressWarnings("serial")
// Einbinden der SCSS als CSS
@Theme("ofk")
public class OFKUI extends UI   {
	
	private OFKPresenter presenter;
	private OFKView startView;
	
	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		presenter.init(this,startView);

	}
	public OFKPresenter getPresenter() {
		return presenter;
	}

	public void setPresenter(OFKPresenter presenter) {
		this.presenter = presenter;
	}
	public OFKView getStartView() {
		return startView;
	}
	public void setStartView(OFKView startView) {
		this.startView = startView;
	}
}