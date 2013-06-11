package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.server.Page;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

public class EingabeSeite extends CustomComponent implements OFKView,
		ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();
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

	private Notification speicherNotification;


	private String beschreibung;

	boolean isEinnahme;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public EingabeSeite(String beschreibung, boolean isEinnahme) {
		this.isEinnahme = isEinnahme;
		this.beschreibung = beschreibung;
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
		beschreibungslabel.setValue(beschreibung);
		mainLayout.addComponent(beschreibungslabel, "top:5.0%;left:45.0%;");

		// eingabeLayout
		eingabeLayout = buildEingabeLayout();
		mainLayout.addComponent(eingabeLayout, "top:10.0%;left:0.0px;");

		// zurueckButton
		zurueckButton = new Button("Zurück", this);
		zurueckButton.setImmediate(true);
		zurueckButton.setWidth("-1px");
		zurueckButton.setHeight("-1px");
		mainLayout.addComponent(zurueckButton, "top:92.0%;left:90.0%;");

		return mainLayout;
	}

	@AutoGenerated
	private GridLayout buildEingabeLayout() {
		// common part: cremany-to-oneate layout
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

		// neuButton
		neuButton = new Button();
		neuButton.setCaption("Neue Kategorie");
		neuButton.setImmediate(true);
		neuButton.setWidth("-1px");
		neuButton.setHeight("-1px");
		neuButton.setEnabled(false);
		eingabeLayout.addComponent(neuButton, 0, 5);
		eingabeLayout.setComponentAlignment(neuButton, new Alignment(48));

		// speicherButton
		speicherButton = new Button("Werte Speichern", this);
		speicherButton.setImmediate(true);
		speicherButton.setWidth("-1px");
		speicherButton.setHeight("-1px");
		eingabeLayout.addComponent(speicherButton, 2, 5);
		eingabeLayout.setComponentAlignment(speicherButton, new Alignment(48));

		return eingabeLayout;
	}

	@Override
	public void addListener(OFKViewListener listener) {
		listeners.add(listener);

	}

	@SuppressWarnings("deprecation")
	public void bestaetige() {

		speicherNotification = new Notification("Daten Sichern",
				"<br/>Eingaben Erfolgreich gespeichert",
				Notification.TYPE_HUMANIZED_MESSAGE, true);
		speicherNotification.setStyleName("positiv");
		speicherNotification.show(Page.getCurrent());
	}
	
	@SuppressWarnings("deprecation")
	public void warne(List<Integer> fehler) {

		speicherNotification = new Notification("Daten Sichern",
				"<br/> Eingaben in: "+ fehler+" nicht erfolgreich bitte nur Zahlen eingeben",Notification.TYPE_WARNING_MESSAGE,true
				);
		speicherNotification.setStyleName("negativ");
		speicherNotification.show(Page.getCurrent());
	}
	@SuppressWarnings("deprecation")
	public void eingabeFehler(int i) {

		speicherNotification = new Notification("Daten falsch eingegeben",
				"<br/> Bitte Eingaben Prüfen, eines der Felder in Zeile "+i + " ist leer",Notification.TYPE_WARNING_MESSAGE,true
				);
		speicherNotification.setStyleName("negativ");
		speicherNotification.show(Page.getCurrent());
	}

	@Override
	public void buttonClick(ClickEvent event) {

		for (OFKViewListener listener : listeners)
			listener.buttonClick(event.getButton().getCaption());

	}

	
	public boolean isEinnahme() {
		return this.isEinnahme;
	}

	public void feldErstellung(String[] konten, String[] kategorien) {

		// kontoBox_1
		kontoBox_1 = kontoBoxErstellung(konten);
		kontoBox_1.setImmediate(false);
		kontoBox_1.setWidth("-1px");
		kontoBox_1.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_1, 0, 1);
		eingabeLayout.setComponentAlignment(kontoBox_1, new Alignment(34));

		// kategorieBox_1
		kategorieBox_1 = kategorieErstellung(kategorien);
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
		kontoBox_2 = kontoBoxErstellung(konten);
		;
		kontoBox_2.setImmediate(false);
		kontoBox_2.setWidth("-1px");
		kontoBox_2.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_2, 0, 2);
		eingabeLayout.setComponentAlignment(kontoBox_2, new Alignment(34));

		// kategorieBox_2
		kategorieBox_2 = kategorieErstellung(kategorien);
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
		kontoBox_3 = kontoBoxErstellung(konten);
		;
		kontoBox_3.setImmediate(false);
		kontoBox_3.setWidth("-1px");
		kontoBox_3.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_3, 0, 3);
		eingabeLayout.setComponentAlignment(kontoBox_3, new Alignment(34));

		// kategorieBox_3
		kategorieBox_3 = kategorieErstellung(kategorien);
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
		kontoBox_4 = kontoBoxErstellung(konten);
		kontoBox_4.setImmediate(false);
		kontoBox_4.setWidth("-1px");
		kontoBox_4.setHeight("-1px");
		eingabeLayout.addComponent(kontoBox_4, 0, 4);
		eingabeLayout.setComponentAlignment(kontoBox_4, new Alignment(34));

		// kategorieBox_4
		kategorieBox_4 = kategorieErstellung(kategorien);
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
	}

	private ComboBox kontoBoxErstellung(String[] Konten) {
		ComboBox erstellung = new ComboBox();
		for (String name : Konten) {
			erstellung.addItem(name);
		}

		return erstellung;
	}

	private ComboBox kategorieErstellung(String[] Kategorien) {
		ComboBox erstellung = new ComboBox();
		for (String name : Kategorien) {
			erstellung.addItem(name);
		}
		return erstellung;
	}

	// Bei erfolgreichem Spichervorgang rückmeldung benötigt
	
	public String[] getGeldFieldValue() {
		String[] geldWerte = new String[4];
		if (!geldFeld_1.getValue().equals("")) {
			geldWerte[0]=geldFeld_1.getValue();
		} else {
			geldWerte[0]= "blanck";
		}
		if (!geldFeld_2.getValue().equals("")) {
			geldWerte[1]=geldFeld_2.getValue();
		} else {
			geldWerte[1]= "blanck";
		}
		if (!geldFeld_3.getValue().equals("")) {
			geldWerte[2]=geldFeld_3.getValue();
		} else {
			geldWerte[2]= "blanck";
		}
		if (!geldFeld_4.getValue().equals("")) {
			geldWerte[3]=geldFeld_4.getValue();
		} else {
			geldWerte[3]= "blanck";
		}
		return geldWerte;
	}
	public String[] getKategorieFieldValue() {
		String[] kategorieWerte = new String[4];
		if (kategorieBox_1.getValue() != null) {
			kategorieWerte[0]=(String) kategorieBox_1.getValue();
		} else {
			kategorieWerte[0]= "blanck";
		}
		if (kategorieBox_2.getValue() != null) {
			kategorieWerte[1]=(String) kategorieBox_2.getValue();
		} else {
			kategorieWerte[1]= "blanck";
		}
		if (kategorieBox_3.getValue() != null) {
			kategorieWerte[2]=(String) kategorieBox_3.getValue();
		} else {
			kategorieWerte[2]= "blanck";
		}
		if (kategorieBox_4.getValue() != null) {
			kategorieWerte[3]=(String) kategorieBox_4.getValue();
		} else {
			kategorieWerte[3]= "blanck";
		}
		return kategorieWerte;}
	
	public String[] getKontoFieldValue() {
		String[] kontoWerte = new String[4];
		if (kontoBox_1.getValue() != null) {
			kontoWerte[0]=(String) kontoBox_1.getValue();
		} else {
			kontoWerte[0]= "blanck";
		}
		if (kontoBox_2.getValue() != null) {
			kontoWerte[1]=(String) kontoBox_2.getValue();
		} else {
			kontoWerte[1]= "blanck";
		}
		if (kontoBox_3.getValue() != null) {
			kontoWerte[2]=(String) kontoBox_3.getValue();
		} else {
			kontoWerte[2]= "blanck";
		}
		if (kontoBox_4.getValue() != null) {
			kontoWerte[3]=(String) kontoBox_4.getValue();
		} else {
			kontoWerte[3]= "blanck";
		}
		return kontoWerte;
	}
	

}
