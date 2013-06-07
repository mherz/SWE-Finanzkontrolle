package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.Theme;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;
import com.vaadin.annotations.Theme;


@Theme("ofk")
public class Startseite extends CustomComponent implements OFKView, ClickListener{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label titelLabel;
	@AutoGenerated
	private Button logout;
	@AutoGenerated
	private GridLayout startLayout;
	@AutoGenerated
	private Button accountSeite;
	@AutoGenerated
	private Button transaktionsSeite;
	@AutoGenerated
	private Button kontenSeite;
	@AutoGenerated
	private Button ausgabenSeite;
	@AutoGenerated
	private Button spezialMaskenSeite;
	@AutoGenerated
	private Button einnahmenSeite;
	@AutoGenerated
	private Button uebersichtSeite;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 * 
	 * @param finanzkontrolleUI
	 */
	public Startseite() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// gridLayout_1
		startLayout = buildGridLayout_1();
		mainLayout.addComponent(startLayout, "top:5.0%;left:0.0px;");

		// logout
		logout = new Button("Ausloggen",this);
		logout.setImmediate(false);
		logout.setWidth("-1px");
		logout.setHeight("-1px");
		mainLayout.addComponent(logout, "top:92.0%;left:85.0%;");

		// titelLabel
		titelLabel = new Label();
		titelLabel.setImmediate(false);
		titelLabel.setWidth("-1px");
		titelLabel.setHeight("-1px");
		titelLabel.setValue("Startseite");
		mainLayout.addComponent(titelLabel, "top:2%;left:45%;");

		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_1() {
		// common part: create layout
		String buttonHeight = "20%";
		String buttonWidth= "100%";
		
		startLayout = new GridLayout();
		startLayout.setImmediate(false);
		startLayout.setWidth("100.0%");
		startLayout.setHeight("90.0%");
		startLayout.setMargin(true);
		startLayout.setSpacing(true);
		startLayout.setColumns(3);
		startLayout.setRows(3);

		// uebersichtSeite
		uebersichtSeite = new Button("Übersicht",this);
		uebersichtSeite.setImmediate(true);
		uebersichtSeite.setWidth(buttonWidth);
		uebersichtSeite.setHeight(buttonHeight);
		startLayout.addComponent(uebersichtSeite, 1, 0);
		startLayout.setComponentAlignment(uebersichtSeite, new Alignment(48));

		// einnahmenSeite
		Image einnahmenBild = new Image();
		ClassResource einnahmenRessource = new ClassResource("Einnahmen.png");
		einnahmenBild.setSource(einnahmenRessource);
		einnahmenSeite = new Button("Einnahmen",this);
		einnahmenSeite.setImmediate(true);
		einnahmenSeite.setWidth(buttonWidth);
		einnahmenSeite.setHeight(buttonHeight);
		einnahmenBild.setVisible(true);
		startLayout.addComponent(einnahmenBild,0,0);
		startLayout.addComponent(einnahmenSeite, 0, 1);
		startLayout.setComponentAlignment(einnahmenSeite, new Alignment(48));

		// spezialMaskenSeite
		spezialMaskenSeite = new Button("Spezial Kategorien",this);
		spezialMaskenSeite.setImmediate(true);
		spezialMaskenSeite.setWidth(buttonWidth);
		spezialMaskenSeite.setHeight(buttonHeight);
		spezialMaskenSeite.setEnabled(false);
		startLayout.addComponent(spezialMaskenSeite, 1, 1);
		startLayout.setComponentAlignment(spezialMaskenSeite,
				new Alignment(48));

		// ausgabenSeite
		ausgabenSeite = new Button("Ausgabe",this);
		ausgabenSeite.setImmediate(true);
		ausgabenSeite.setWidth(buttonWidth);
		ausgabenSeite.setHeight(buttonHeight);
		startLayout.addComponent(ausgabenSeite, 2, 1);
		startLayout.setComponentAlignment(ausgabenSeite, new Alignment(48));

		// kontenSeite
		kontenSeite = new Button("Kotenverwaltung",this);
		kontenSeite.setImmediate(true);
		kontenSeite.setWidth(buttonWidth);
		kontenSeite.setHeight(buttonHeight);
		kontenSeite.setEnabled(false);
		startLayout.addComponent(kontenSeite, 0, 2);
		startLayout.setComponentAlignment(kontenSeite, new Alignment(48));

		// transaktionsSeite
		transaktionsSeite = new Button("Interne Transaktionen", this);
		transaktionsSeite.setImmediate(true);
		transaktionsSeite.setWidth(buttonWidth);
		transaktionsSeite.setHeight(buttonHeight);
		transaktionsSeite.setEnabled(false);
		startLayout.addComponent(transaktionsSeite, 1, 2);
		startLayout
				.setComponentAlignment(transaktionsSeite, new Alignment(48));

		// accoutnSeite
		accountSeite = new Button("Accountverwaltung",this);
		accountSeite.setImmediate(true);
		accountSeite.setWidth(buttonWidth);
		accountSeite.setHeight(buttonHeight);
		accountSeite.setEnabled(false);
		startLayout.addComponent(accountSeite, 2, 2);
		startLayout.setComponentAlignment(accountSeite, new Alignment(48));

		return startLayout;
	}

    public void addListener(OFKViewListener listener){
    	listeners.add(listener);
    }

	@Override
	public void buttonClick(ClickEvent event) {
        for (OFKViewListener listener: listeners)
            listener.buttonClick(event.getButton()
                                 .getCaption());
		
	}



	
}