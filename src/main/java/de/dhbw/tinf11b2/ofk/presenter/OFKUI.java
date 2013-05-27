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

/**
 * Main UI class
 */
@SuppressWarnings("serial")
public class OFKUI extends UI   {
	
	User currentUser;
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