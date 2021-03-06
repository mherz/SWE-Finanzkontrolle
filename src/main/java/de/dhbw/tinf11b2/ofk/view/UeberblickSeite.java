package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.addon.charts.Chart;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;

/**
 * Erstellung der Seite für die Tabellenübersicht
 * 
 * @author felix
 */
public class UeberblickSeite extends CustomComponent implements OFKView,
		ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();
	private static final long serialVersionUID = 1L;
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private TabSheet ubersichtSheet;
	@AutoGenerated
	private AbsoluteLayout ausgabenLayout;
	@AutoGenerated
	private ComboBox chartSelect;
	@AutoGenerated
	private NativeSelect zeitraumSelect;
	@AutoGenerated
	private AbsoluteLayout gesamtLayout;

	@AutoGenerated
	private AbsoluteLayout einnahmenLayout;
	@AutoGenerated
	private Button zurueckButton;
	@AutoGenerated
	private Label uebersichtLabel;

	private ComboBox chartSelectE;
	private ComboBox chartSelectA;

	private Button einnahmenButton;
	private Button ausgabeButton;
	private Button gesamtButton;

	private String gesamt = "Gesamtübersicht";
	private String zeit = "Zeitübersicht";

	private StandardElement elemente = new StandardElement();
	private Koordinaten koordinaten = new Koordinaten();
	private ChartElemente charts = new ChartElemente();

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 * 
	 * @param finanzkontrolleUI
	 */
	public UeberblickSeite() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
	}

	/**
	 * Generierung des Mainlayouts mit der Belegung von Standardvariablen
	 * 
	 * @return Generiertes Mainlayout
	 */
	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = elemente.absoluteGen();

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		// uebersichtLabel
		uebersichtLabel = elemente.beschrGen();
		uebersichtLabel.setValue("Grafischeübersicht");
		mainLayout.addComponent(uebersichtLabel, koordinaten.getLabel());

		// ubersichtSheet
		ubersichtSheet = buildUbersichtSheet();
		mainLayout.addComponent(ubersichtSheet, koordinaten.getMain());

		// zurueckButton
		zurueckButton = elemente.zurueckGen();
		zurueckButton.setId("Zurück");
		zurueckButton.addClickListener(this);
		mainLayout.addComponent(zurueckButton, koordinaten.getZurueck());

		return mainLayout;
	}

	/**
	 * Erstellung des Tabsheets indem die Darstellung ausgewählt werden kann
	 * 
	 * @return Erstelltes Tabsheet
	 */
	@AutoGenerated
	private TabSheet buildUbersichtSheet() {
		// common part: create layout
		ubersichtSheet = new TabSheet();
		ubersichtSheet.setImmediate(true);
		ubersichtSheet.setWidth("100.0%");
		ubersichtSheet.setHeight("90.0%");

		// verticalLayout_1
		einnahmenLayout = buildEinnahmenLayout();
		ubersichtSheet.addTab(einnahmenLayout, "Einnahmen Uebersicht", null);

		// gesamtUebersicht
		gesamtLayout = buildGesamtLayout();
		ubersichtSheet.addTab(gesamtLayout, "Gesamt Uebersicht", null);

		// verticalLayout_2
		ausgabenLayout = buildAusgabenLayout();
		ubersichtSheet.addTab(ausgabenLayout, "Ausgaben Uebersicht", null);

		return ubersichtSheet;
	}

	/**
	 * Generierung des EinnahmenLayouts für die Chartdarstellung
	 * 
	 * @return Generiertes Layout zur Einnahmendarstellung
	 */
	@AutoGenerated
	private AbsoluteLayout buildEinnahmenLayout() {
		// common part: create layout
		einnahmenLayout = new AbsoluteLayout();
		einnahmenLayout.setImmediate(false);
		einnahmenLayout.setWidth("100.0%");
		einnahmenLayout.setHeight("100.0%");
		chartSelectE = selection();
		einnahmenLayout.addComponent(chartSelect, "top:5.0%;left:0.0%;");
		einnahmenButton = new Button("Wechsel", this);
		einnahmenButton.setId("WechselE");
		einnahmenLayout.addComponent(einnahmenButton, "top:5.0%;left:20.0%;");
		return einnahmenLayout;
	}

	/**
	 * Generierung des Gesamtüberblicks mit Charts über Einnahmen und Ausgaben
	 * 
	 * @return Layout für die Gesamtübersicht
	 */
	@AutoGenerated
	private AbsoluteLayout buildGesamtLayout() {
		// common part: create layout
		gesamtLayout = new AbsoluteLayout();
		gesamtLayout.setImmediate(false);
		gesamtLayout.setWidth("100.0%");
		gesamtLayout.setHeight("100.0%");
		gesamtButton = new Button("Anzeigen", this);
		gesamtButton.setId("WechselG");
		gesamtLayout.addComponent(gesamtButton, "top:5.0%;left:0.0%;");

		return gesamtLayout;
	}

	/**
	 * Generierung des Layouts für die Chartdarstellung von Ausgaben
	 * 
	 * @return Generiertes Layout für die Ausgabendarstellung
	 */
	@AutoGenerated
	private AbsoluteLayout buildAusgabenLayout() {
		// common part: create layout
		ausgabenLayout = new AbsoluteLayout();
		ausgabenLayout.setImmediate(false);
		ausgabenLayout.setWidth("100.0%");
		ausgabenLayout.setHeight("100.0%");
		chartSelectA = selection();
		ausgabeButton = new Button("Wechsel", this);
		ausgabeButton.setId("WechselA");
		ausgabenLayout.addComponent(chartSelect, "top:5.0%;left:0.0%;");
		ausgabenLayout.addComponent(ausgabeButton, "top:5.0%;left:20.0%;");

		return ausgabenLayout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.dhbw.tinf11b2.ofk.view.OFKView#addListener(de.dhbw.tinf11b2.ofk.presenter
	 * .OFKViewListener)
	 */
	@Override
	public void addListener(OFKViewListener listener) {
		listeners.add(listener);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.
	 * ClickEvent)
	 */
	@Override
	public void buttonClick(ClickEvent event) {

		for (OFKViewListener listener : listeners)
			listener.buttonClick(event.getButton().getId());

	}

	/**
	 * Erstellung der ComboBox für die Auswahl der Darstellungsart
	 * 
	 * @return ComboBox für die Darstellungswahl
	 */
	private ComboBox selection() {
		// nativeSelect_1
		chartSelect = elemente.comboGen();
		chartSelect.setCaption("Chart Art");
		chartSelect.addItem(gesamt);
		chartSelect.addItem(zeit);
		chartSelect.setValue(zeit);
		chartSelect.setDescription("Hier kann eine Kategorie gewählt werden");
		chartSelect.setImmediate(true);
		return chartSelect;
	}

	/**
	 * Darstellungsfunktion für die Darstellung von Einnahmen als Zeit und
	 * Kategoriewert
	 * 
	 * @param strings
	 *            Kategorien Werte als String Array
	 * @param doubles
	 *            Kategorien Geldwerte als Double Array
	 * @param strings2
	 *            Monatsnamen als String Array
	 * @param doubles2
	 *            Monatswerte als Double Array
	 */
	public void wechselDichE(String[] strings, Double[] doubles,
			String[] strings2, Double[] doubles2) {
		Chart chart;

		if (chartSelectE.getValue().equals(gesamt)) {
			chart = charts.setChartPie(strings, doubles, "Einnahmen " + gesamt);
		} else {
			chart = charts.barChartGen(strings2, doubles2, "Einnahmen " + zeit);
		}

		if (chart != null)
			einnahmenLayout.addComponent(chart, koordinaten.getChart());

	}

	/**
	 * Darstellungsfunktion für die Darstellung von Ausgaben als Zeit und
	 * Kategoriewert
	 * 
	 * @param strings
	 *            Kategorien Werte als String Array
	 * @param doubles
	 *            Kategorien Geldwerte als Double Array
	 * @param strings2
	 *            Monatsnamen als String Array
	 * @param doubles2
	 *            Monatswerte als Double Array
	 */
	public void wechselDichA(String[] strings, Double[] doubles,
			String[] strings2, Double[] doubles2) {
		Chart chart;

		if (chartSelectA.getValue().equals(gesamt)) {
			chart = charts.setChartPie(strings, doubles, "Ausgaben " + gesamt);
		} else {
			chart = charts.barChartGen(strings2, doubles2, "Ausgaben " + zeit);
		}

		// Chart
		if (chart != null)
			ausgabenLayout.addComponent(chart, koordinaten.getChart());

	}

	/**
	 * Darstellungsfunktion für die Darstellung von Einnahmen und Ausgaben
	 * Kategoriewert
	 * 
	 * @param kategorien Kategorien namen als String Array
	 * @param einnahmen Einnahmen Werte als Double Array
	 * @param ausgaben Ausgaben Werte als Double Array
	 */
	public void wechselDichG(String[] kategorien, Double[] einnahmen,
			Double[] ausgaben) {
		Chart chart;

		chart = charts.setChartBarMulti(kategorien, einnahmen, "Einnahmen",
				ausgaben, "Ausgaben");

		gesamtLayout.addComponent(chart, koordinaten.getChart());

	}

}
