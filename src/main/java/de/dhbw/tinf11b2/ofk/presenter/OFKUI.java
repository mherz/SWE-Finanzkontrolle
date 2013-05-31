package de.dhbw.tinf11b2.ofk.presenter;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;



/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class OFKUI extends UI   {
	
	private OFKPresenter presenter;
	
	
	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		presenter.init(this);

	}
	public OFKPresenter getPresenter() {
		return presenter;
	}


	public void setPresenter(OFKPresenter presenter) {
		this.presenter = presenter;
	}
}