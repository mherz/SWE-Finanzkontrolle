package de.dhbw.tinf11b2.ofk.view;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class Einnahmenseite extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button zurueckButton;
	@AutoGenerated
	private GridLayout eingabeLayout;
	@AutoGenerated
	private Button speicherButton;
	@AutoGenerated
	private Button neuButton;
	@AutoGenerated
	private TextField geldFeld_4;
	@AutoGenerated
	private ComboBox kategorieBox_4;
	@AutoGenerated
	private ComboBox kontoBox_4;
	@AutoGenerated
	private TextField geldFeld_3;
	@AutoGenerated
	private ComboBox kategorieBox_3;
	@AutoGenerated
	private ComboBox kontoBox_3;
	@AutoGenerated
	private TextField geldFeld_2;
	@AutoGenerated
	private ComboBox kategorieBox_2;
	@AutoGenerated
	private ComboBox kontoBox_2;
	@AutoGenerated
	private TextField geldFeld_1;
	@AutoGenerated
	private ComboBox kategorieBox_1;
	@AutoGenerated
	private ComboBox kontoBox_1;
	@AutoGenerated
	private Label werteLabel;
	@AutoGenerated
	private Label kategorieLabel;
	@AutoGenerated
	private Label kontoLable;
	@AutoGenerated
	private Label beschreibungslabel;
	private FinanzkontrolleUI instanz;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public Einnahmenseite(FinanzkontrolleUI finanzkontrolleUI) {
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
		
		// beschreibungslabel
		beschreibungslabel = new Label();
		beschreibungslabel.setImmediate(false);
		beschreibungslabel.setWidth("-1px");
		beschreibungslabel.setHeight("-1px");
		beschreibungslabel.setValue("Einnahme");
		mainLayout.addComponent(beschreibungslabel, "top:5.0%;left:45.0%;");
		
		// eingabeLayout
		eingabeLayout = buildEingabeLayout();
		mainLayout.addComponent(eingabeLayout, "top:10.0%;left:0.0px;");
		
		// zurueckButton
		zurueckButton = new Button();
		zurueckButton.setCaption("Zur�ck");
		zurueckButton.setImmediate(true);
		zurueckButton.setWidth("-1px");
		zurueckButton.setHeight("-1px");
		zurueckButton.addClickListener(new Button.ClickListener() {		
	

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				instanz.pageChangeback();
//				zurueckButton.setCaption("Clicked");
				
			}
		});	
		mainLayout.addComponent(zurueckButton, "top:92.0%;left:90.0%;");
		
		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildEingabeLayout() {
		// common part: create layout
		eingabeLayout = new GridLayout();
		eingabeLayout.setImmediate(false);
		eingabeLayout.setWidth("100.0%");
		eingabeLayout.setHeight("90.0%");
		eingabeLayout.setMargin(false);
		eingabeLayout.setColumns(3);
		eingabeLayout.setRows(6);
		
		// kontoLable
		kontoLable = new Label();
		kontoLable.setImmediate(false);
		kontoLable.setWidth("-1px");
		kontoLable.setHeight("-1px");
		kontoLable.setValue("Konto");
		eingabeLayout.addComponent(kontoLable, 0, 0);
		eingabeLayout.setComponentAlignment(kontoLable, new Alignment(10));
		
		// kategorieLabel
		kategorieLabel = new Label();
		kategorieLabel.setImmediate(false);
		kategorieLabel.setWidth("-1px");
		kategorieLabel.setHeight("-1px");
		kategorieLabel.setValue("Kategorie");
		eingabeLayout.addComponent(kategorieLabel, 1, 0);
		eingabeLayout.setComponentAlignment(kategorieLabel, new Alignment(24));
		
		// werteLabel
		werteLabel = new Label();
		werteLabel.setImmediate(false);
		werteLabel.setWidth("-1px");
		werteLabel.setHeight("-1px");
		werteLabel.setValue("Wert");
		eingabeLayout.addComponent(werteLabel, 2, 0);
		eingabeLayout.setComponentAlignment(werteLabel, new Alignment(9));
		
		// kontoBox_1
		kontoBox_1 = new ComboBox();
		kontoBox_1.setImmediate(false);
		kontoBox_1.setWidth("-1px");
		kontoBox_1.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_1, 0, 1);
		eingabeLayout.setComponentAlignment(kontoBox_1, new Alignment(34));
		
		// kategorieBox_1
		kategorieBox_1 = new ComboBox();
		kategorieBox_1.setImmediate(false);
		kategorieBox_1.setWidth("-1px");
		kategorieBox_1.setHeight("-1px");
		eingabeLayout.addComponent(kategorieBox_1, 1, 1);
		eingabeLayout.setComponentAlignment(kategorieBox_1, new Alignment(48));
		
		// geldFeld_1
		geldFeld_1 = new TextField();
		geldFeld_1.setImmediate(false);
		geldFeld_1.setWidth("-1px");
		geldFeld_1.setHeight("-1px");
		eingabeLayout.addComponent(geldFeld_1, 2, 1);
		eingabeLayout.setComponentAlignment(geldFeld_1, new Alignment(33));
		
		// kontoBox_2
		kontoBox_2 = new ComboBox();
		kontoBox_2.setImmediate(false);
		kontoBox_2.setWidth("-1px");
		kontoBox_2.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_2, 0, 2);
		eingabeLayout.setComponentAlignment(kontoBox_2, new Alignment(34));
		
		// kategorieBox_2
		kategorieBox_2 = new ComboBox();
		kategorieBox_2.setImmediate(false);
		kategorieBox_2.setWidth("-1px");
		kategorieBox_2.setHeight("-1px");
		eingabeLayout.addComponent(kategorieBox_2, 1, 2);
		eingabeLayout.setComponentAlignment(kategorieBox_2, new Alignment(48));
		
		// geldFeld_2
		geldFeld_2 = new TextField();
		geldFeld_2.setImmediate(false);
		geldFeld_2.setWidth("-1px");
		geldFeld_2.setHeight("-1px");
		eingabeLayout.addComponent(geldFeld_2, 2, 2);
		eingabeLayout.setComponentAlignment(geldFeld_2, new Alignment(33));
		
		// kontoBox_3
		kontoBox_3 = new ComboBox();
		kontoBox_3.setImmediate(false);
		kontoBox_3.setWidth("-1px");
		kontoBox_3.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_3, 0, 3);
		eingabeLayout.setComponentAlignment(kontoBox_3, new Alignment(34));
		
		// kategorieBox_3
		kategorieBox_3 = new ComboBox();
		kategorieBox_3.setImmediate(false);
		kategorieBox_3.setWidth("-1px");
		kategorieBox_3.setHeight("-1px");
		eingabeLayout.addComponent(kategorieBox_3, 1, 3);
		eingabeLayout.setComponentAlignment(kategorieBox_3, new Alignment(48));
		
		// geldFeld_3
		geldFeld_3 = new TextField();
		geldFeld_3.setImmediate(false);
		geldFeld_3.setWidth("-1px");
		geldFeld_3.setHeight("-1px");
		eingabeLayout.addComponent(geldFeld_3, 2, 3);
		eingabeLayout.setComponentAlignment(geldFeld_3, new Alignment(33));
		
		// kontoBox_4
		kontoBox_4 = new ComboBox();
		kontoBox_4.setImmediate(false);
		kontoBox_4.setWidth("-1px");
		kontoBox_4.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_4, 0, 4);
		eingabeLayout.setComponentAlignment(kontoBox_4, new Alignment(34));
		
		// kategorieBox_4
		kategorieBox_4 = new ComboBox();
		kategorieBox_4.setImmediate(false);
		kategorieBox_4.setWidth("-1px");
		kategorieBox_4.setHeight("-1px");
		eingabeLayout.addComponent(kategorieBox_4, 1, 4);
		eingabeLayout.setComponentAlignment(kategorieBox_4, new Alignment(48));
		
		// geldFeld_4
		geldFeld_4 = new TextField();
		geldFeld_4.setImmediate(false);
		geldFeld_4.setWidth("-1px");
		geldFeld_4.setHeight("-1px");
		eingabeLayout.addComponent(geldFeld_4, 2, 4);
		eingabeLayout.setComponentAlignment(geldFeld_4, new Alignment(33));
		
		// neuButton
		neuButton = new Button();
		neuButton.setCaption("Neue Kategorie");
		neuButton.setImmediate(true);
		neuButton.setWidth("-1px");
		neuButton.setHeight("-1px");
		eingabeLayout.addComponent(neuButton, 0, 5);
		eingabeLayout.setComponentAlignment(neuButton, new Alignment(48));
		
		// speicherButton
		speicherButton = new Button();
		speicherButton.setCaption("Werte Speichern");
		speicherButton.setImmediate(true);
		speicherButton.setWidth("-1px");
		speicherButton.setHeight("-1px");
		eingabeLayout.addComponent(speicherButton, 2, 5);
		eingabeLayout.setComponentAlignment(speicherButton, new Alignment(48));
		
		return eingabeLayout;
	}

}