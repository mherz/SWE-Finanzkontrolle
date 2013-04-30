package de.dhbw.tinf11b2.ofk.view;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;

public class Startseite extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label titelLabel;
	@AutoGenerated
	private Button logout;
	@AutoGenerated
	private GridLayout gridLayout_1;
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

	FinanzkontrolleUI instanz;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 * 
	 * @param finanzkontrolleUI
	 */
	public Startseite(FinanzkontrolleUI finanzkontrolleUI) {
		instanz = finanzkontrolleUI;
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
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
		gridLayout_1 = buildGridLayout_1();
		mainLayout.addComponent(gridLayout_1, "top:10.0%;left:0.0px;");

		// logout
		logout = new Button();
		logout.setCaption("Ausloggen");
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
		mainLayout.addComponent(titelLabel, "top:20.0px;left:320.0px;");

		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_1() {
		// common part: create layout
		gridLayout_1 = new GridLayout();
		gridLayout_1.setImmediate(false);
		gridLayout_1.setWidth("100.0%");
		gridLayout_1.setHeight("90.0%");
		gridLayout_1.setMargin(true);
		gridLayout_1.setSpacing(true);
		gridLayout_1.setColumns(3);
		gridLayout_1.setRows(3);

		// uebersichtSeite
		uebersichtSeite = new Button();
		uebersichtSeite.setCaption("�bersicht");
		uebersichtSeite.setImmediate(true);
		uebersichtSeite.setWidth("-1px");
		uebersichtSeite.setHeight("-1px");
		uebersichtSeite.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				UeberblickSeite ueberblick = new UeberblickSeite(instanz);
				instanz.setContent(ueberblick);
				// zurueckButton.setCaption("Clicked");

			}
		});
		gridLayout_1.addComponent(uebersichtSeite, 1, 0);
		gridLayout_1.setComponentAlignment(uebersichtSeite, new Alignment(48));

		// einnahmenSeite
		einnahmenSeite = new Button();
		einnahmenSeite.setCaption("Einnahmen");
		einnahmenSeite.setImmediate(true);
		einnahmenSeite.setWidth("-1px");
		einnahmenSeite.setHeight("-1px");
		einnahmenSeite.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Einnahmenseite einnahmen = new Einnahmenseite(instanz);
				instanz.setContent(einnahmen);
				// zurueckButton.setCaption("Clicked");

			}
		});
		gridLayout_1.addComponent(einnahmenSeite, 0, 1);
		gridLayout_1.setComponentAlignment(einnahmenSeite, new Alignment(48));

		// spezialMaskenSeite
		spezialMaskenSeite = new Button();
		spezialMaskenSeite.setCaption("Spezial Kategorien");
		spezialMaskenSeite.setImmediate(true);
		spezialMaskenSeite.setWidth("-1px");
		spezialMaskenSeite.setHeight("-1px");
		gridLayout_1.addComponent(spezialMaskenSeite, 1, 1);
		gridLayout_1.setComponentAlignment(spezialMaskenSeite,
				new Alignment(48));

		// ausgabenSeite
		ausgabenSeite = new Button();
		ausgabenSeite.setCaption("Ausgaben");
		ausgabenSeite.setImmediate(true);
		ausgabenSeite.setWidth("-1px");
		ausgabenSeite.setHeight("-1px");
		ausgabenSeite.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Ausgabenseite ausgaben = new Ausgabenseite(instanz);
				instanz.setContent(ausgaben);
				// zurueckButton.setCaption("Clicked");

			}
		});
		gridLayout_1.addComponent(ausgabenSeite, 2, 1);
		gridLayout_1.setComponentAlignment(ausgabenSeite, new Alignment(48));

		// kontenSeite
		kontenSeite = new Button();
		kontenSeite.setCaption("Kontenverwaltung");
		kontenSeite.setImmediate(true);
		kontenSeite.setWidth("-1px");
		kontenSeite.setHeight("-1px");
		gridLayout_1.addComponent(kontenSeite, 0, 2);
		gridLayout_1.setComponentAlignment(kontenSeite, new Alignment(48));

		// transaktionsSeite
		transaktionsSeite = new Button();
		transaktionsSeite.setCaption("Interne Transaktionen");
		transaktionsSeite.setImmediate(true);
		transaktionsSeite.setWidth("-1px");
		transaktionsSeite.setHeight("-1px");
		gridLayout_1.addComponent(transaktionsSeite, 1, 2);
		gridLayout_1
				.setComponentAlignment(transaktionsSeite, new Alignment(48));

		// accoutnSeite
		accountSeite = new Button();
		accountSeite.setCaption("Accountverwaltung");
		accountSeite.setImmediate(true);
		accountSeite.setWidth("-1px");
		accountSeite.setHeight("-1px");
		gridLayout_1.addComponent(accountSeite, 2, 2);
		gridLayout_1.setComponentAlignment(accountSeite, new Alignment(48));

		return gridLayout_1;
	}

}