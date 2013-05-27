package de.dhbw.tinf11b2.ofk.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

import de.dhbw.tinf11b2.ofk.presenter.OFKViewListener;


public class UeberblickSeite extends CustomComponent implements OFKView, ClickListener {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * 
	 */
	
	List<OFKViewListener> listeners = new ArrayList<OFKViewListener>();
	private static final long serialVersionUID = 1L;
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private TabSheet ubersichtSheet;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private NativeSelect nativeSelect_5;
	@AutoGenerated
	private NativeSelect nativeSelect_3;
	@AutoGenerated
	private AbsoluteLayout gesamtUebersicht;
	@AutoGenerated
	private NativeSelect nativeSelect_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private NativeSelect nativeSelect_2;
	@AutoGenerated
	private NativeSelect nativeSelect_4;
	@AutoGenerated
	private Button zurueckButton;
	@AutoGenerated
	private Label uebersichtLabel;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 * @param finanzkontrolleUI 
	 */
	public UeberblickSeite() {
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
		
		// uebersichtLabel
		uebersichtLabel = new Label();
		uebersichtLabel.setImmediate(false);
		uebersichtLabel.setWidth("-1px");
		uebersichtLabel.setHeight("-1px");
		uebersichtLabel.setValue("Übersicht");
		mainLayout.addComponent(uebersichtLabel, "top:0.0px;left:120.0px;");
		
		// zurueckButton
		zurueckButton = new Button("Zurück",this);
		zurueckButton.setImmediate(false);
		zurueckButton.setWidth("-1px");
		zurueckButton.setHeight("-1px");
		mainLayout.addComponent(zurueckButton, "top:92.0%;left:90.0%;");
		
		// ubersichtSheet
		ubersichtSheet = buildUbersichtSheet();
		mainLayout.addComponent(ubersichtSheet, "top:40.0px;left:0.0px;");
		
		return mainLayout;
	}

	@AutoGenerated
	private TabSheet buildUbersichtSheet() {
		// common part: create layout
		ubersichtSheet = new TabSheet();
		ubersichtSheet.setImmediate(true);
		ubersichtSheet.setWidth("100.0%");
		ubersichtSheet.setHeight("90.0%");
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		ubersichtSheet.addTab(verticalLayout_1, "Einnahmen �bersicht", null);
		
		// gesamtUebersicht
		gesamtUebersicht = buildGesamtUebersicht();
		ubersichtSheet.addTab(gesamtUebersicht, "Gesamt �bersicht", null);
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		ubersichtSheet.addTab(verticalLayout_2, "Ausgaben �bersicht", null);
		
		return ubersichtSheet;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("100.0%");
		verticalLayout_1.setHeight("100.0%");
		verticalLayout_1.setMargin(false);
		
		// nativeSelect_4
		nativeSelect_4 = new NativeSelect();
		nativeSelect_4.setCaption("Kategorie");
		nativeSelect_4.setImmediate(false);
		nativeSelect_4.setWidth("250px");
		nativeSelect_4.setHeight("-1px");
		verticalLayout_1.addComponent(nativeSelect_4);
		
		// nativeSelect_2
		nativeSelect_2 = new NativeSelect();
		nativeSelect_2.setCaption("Chart Art");
		nativeSelect_2.setImmediate(false);
		nativeSelect_2.setWidth("250px");
		nativeSelect_2.setHeight("-1px");
		verticalLayout_1.addComponent(nativeSelect_2);
		verticalLayout_1
				.setComponentAlignment(nativeSelect_2, new Alignment(9));
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private AbsoluteLayout buildGesamtUebersicht() {
		// common part: create layout
		gesamtUebersicht = new AbsoluteLayout();
		gesamtUebersicht.setImmediate(false);
		gesamtUebersicht.setWidth("100.0%");
		gesamtUebersicht.setHeight("100.0%");
		
		// nativeSelect_1
		nativeSelect_1 = new NativeSelect();
		nativeSelect_1.setCaption("Chart Art");
		nativeSelect_1.setImmediate(false);
		nativeSelect_1.setWidth("-1px");
		nativeSelect_1.setHeight("-1px");
		gesamtUebersicht.addComponent(nativeSelect_1,
				"top:606.0px;left:19.0px;");
		
		return gesamtUebersicht;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("100.0%");
		verticalLayout_2.setHeight("100.0%");
		verticalLayout_2.setMargin(false);
		
		// nativeSelect_3
		nativeSelect_3 = new NativeSelect();
		nativeSelect_3.setCaption("Kategorie");
		nativeSelect_3.setImmediate(false);
		nativeSelect_3.setWidth("250px");
		nativeSelect_3.setHeight("-1px");
		verticalLayout_2.addComponent(nativeSelect_3);
		
		// nativeSelect_5
		nativeSelect_5 = new NativeSelect();
		nativeSelect_5.setCaption("Chart Art");
		nativeSelect_5.setImmediate(false);
		nativeSelect_5.setWidth("250px");
		nativeSelect_5.setHeight("-1px");
		verticalLayout_2.addComponent(nativeSelect_5);
		verticalLayout_2
				.setComponentAlignment(nativeSelect_5, new Alignment(9));
		
		return verticalLayout_2;
	}

	@Override
	public void addListener(OFKViewListener listener) {
		listeners.add(listener);
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		 for (OFKViewListener listener: listeners)
	            listener.buttonClick(event.getButton()
	                                 .getCaption());
		
	}

}