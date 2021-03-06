package de.dhbw.tinf11b2.ofk.view;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Cursor;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.Labels;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.style.SolidColor;

/**
 * Klasse die die Chartelemente in die Daten eingefügt werden müssen bereitstellt.
 * @author felix
 
 */
public class ChartElemente {
	
	/**
	 * Konstruktor
	 */
	public ChartElemente(){
		
	}
	
	/**
	 * Generiert ein einzelnes BarChart für die Zeitraumbetrachtung
	 * @param kategorien String Array mit den darzustellenden Kategorien
	 * @param werte Double Array mit den zusammengerechneten Werten 
	 * @param name String mit dem Namen der Ansicht
	 * @return Erstelltes Chart
	 * 
	 */
	public Chart barChartGen(String[] kategorien, Double[] werte, String name) {
		Chart chart = chartHeadBar();
		// Modify the default configuration a bit
		Configuration conf = chart.getConfiguration();
		conf.setTitle("In dieser Kategorie bist du:");
		conf.setSubTitle(name);
		conf.getLegend().setEnabled(true); // Disable legend
		// The data

		ListSeries series = new ListSeries(name);

		series.setData(werte); // als DOUBLE Array

		conf.addSeries(series);

		// Set the category labels on the axis correspondingly
		XAxis xaxis = new XAxis();
		xaxis.setCategories(kategorien); // als String Array
		xaxis.setTitle("Kategorien");
		conf.addxAxis(xaxis);
		// Set the Y axis title
		YAxis yaxis = new YAxis();
		yaxis.setTitle("Euro");
		yaxis.getLabels().setFormatter(
				"function() {return Math.floor(this.value) + \'€\';}");
		yaxis.getLabels().setStep(2);
		conf.getTooltip().setValueSuffix("€");
		conf.addyAxis(yaxis);
		return chart;
	}

	/**
	 * Generiert ein BarChart für die Gegenüberstellung von Einnahmen und Ausgaben nach Datum
	 * @param datum Zu den Werten gehörender Monat
	 * @param werte Double werte des eingetragenen ersten Namens
	 * @param kategorienName Art der Eintragung ( Einnahme oder Ausgabe)
	 * @param werte2 Double werte des eingetragenen zweiten Namens
	 * @param kategorienName2 ( Einnahme oder Ausgabe)
	 * @return
	 */
	public Chart setChartBarMulti(String[] datum, Double[] werte,
			String kategorienName, Double[] werte2, String kategorienName2) {

		Chart chart = chartHeadBar();
		// Modify the default configuration a bit
		Configuration conf = chart.getConfiguration();
		conf.setTitle("In dieser Kategorie bist du:");
		conf.setSubTitle("Gesamtübersicht");
		conf.getLegend().setEnabled(true); // Disable legend
		// The data

		ListSeries series = new ListSeries(kategorienName);
		ListSeries series2 = new ListSeries(kategorienName2);
		series.setData(werte); // als DOUBLE Array
		series2.setData(werte2);
		conf.addSeries(series);
		conf.addSeries(series2);
		// Set the category labels on the axis correspondingly
		XAxis xaxis = new XAxis();
		xaxis.setCategories(datum); // als String Array
		xaxis.setTitle("Kategorien");
		conf.addxAxis(xaxis);
		// Set the Y axis title
		YAxis yaxis = new YAxis();
		yaxis.setTitle("Euro");
		yaxis.getLabels().setFormatter(
				"function() {return Math.floor(this.value) + \'€\';}");
		yaxis.getLabels().setStep(2);
		conf.getTooltip().setValueSuffix("€");
		conf.addyAxis(yaxis);
		return chart;
	}

	/**
	 * Generiert ein PieChart für die Darstellung von Einnahmen oder Ausgaben nach Kategorien
	 * @param kategorien String Array mit den darzustellenden Kategorien
	 * @param werte Double Array mit den zusammengerechneten Werten 
	 * @param name String mit dem Namen der Ansicht
	 * @return Erstelltes Chart
	 */
	public Chart setChartPie(String[] kategorien, Double[] werte, String name) {
		Chart chart = new Chart(ChartType.PIE);
		chart.setWidth("90%");
		chart.setHeight("90%");

		Configuration conf = chart.getConfiguration();

		conf.setTitle("Du bist in dieser Kategorie:");
		conf.setSubTitle(name);

		PlotOptionsPie plotOptions = new PlotOptionsPie();
		plotOptions.setCursor(Cursor.POINTER);
		Labels dataLabels = new Labels();
		dataLabels.setEnabled(true);
		dataLabels.setColor(new SolidColor(0, 0, 0));
		dataLabels.setConnectorColor(new SolidColor(0, 0, 0));
		dataLabels
				.setFormatter("this.point.name +': '+ this.y +' €'" +
						"+ ' (' +Math.floor(this.percentage)+'%)'");
		plotOptions.setDataLabels(dataLabels);
		conf.setPlotOptions(plotOptions);

		DataSeries series = new DataSeries();
		for (int i = 0; i < kategorien.length; i++) {
			series.add(new DataSeriesItem(kategorien[i], werte[i]));
			series.setName(name);
		}
		conf.getTooltip().setValueSuffix("€");
		conf.setSeries(series);


		chart.drawChart(conf);

		return chart;

	}

	/**
	 * Einfache generierung der Grundelemente für ein BarChart
	 * @return
	 * Grundeigenschaften eines Bar Charts
	 */
	private Chart chartHeadBar() {
		Chart chart = new Chart(ChartType.BAR);
		chart.setWidth("90%");
		chart.setHeight("90%");

		return chart;
	}
}
