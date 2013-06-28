package de.dhbw.tinf11b2.ofk.presenter;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;



/**
 * Main UI class
 */
@SuppressWarnings("serial")
// Einbinden der SCSS als CSS
@Theme("ofk")
public class OFKUI extends UI   {
	
	private OFKPresenter presenter;
	
	/* (non-Javadoc)
	 * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	 */
	@Override
	protected void init(VaadinRequest request) {
		
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		presenter.init(this);

	}
	/**
	 * @return
	 */
	public OFKPresenter getPresenter() {
		return presenter;
	}

	/**
	 * @param presenter
	 */
	public void setPresenter(OFKPresenter presenter) {
		this.presenter = presenter;
	}
}