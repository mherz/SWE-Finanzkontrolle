package de.dhbw.tinf11b2.ofk.view;

/**
 * Klasse zum Festlegen von Standard variablen wie die Position der
 * Beschreibungslabels
 * 
 * @author felix
 */
public class Koordinaten {

	/**
	 * Konstruktor
	 */
	public Koordinaten() {
	}

	/**
	 * Koordinaten für den ZurückButton
	 * 
	 * @return String mit Koordinaten
	 */
	public String getZurueck() {
		String zurueckX = "top:92.0%;left:90.0%;";
		test(zurueckX);
		return zurueckX;
	}

	/**
	 * Wert für die Standartbelegungsvariable für die Eingabeseite
	 * 
	 * @return String mit Leerwert
	 */
	public String empty() {
		return "blank";
	}

	/**
	 * Wert für die Koordinaten von Labels
	 * 
	 * @return Label koordinaten
	 */
	public String getLabel() {
		String labelX = "top:3.0%;left:45.0%;";
		test(labelX);
		return labelX;
	}

	/**
	 * Festlegen der Hauptfenster Koordinaten
	 * @return Standardkoordinaten für das Mainfenster
	 */
	public String getMain() {
		String mainX = "top:10.0%;left:0.0px;";
		test(mainX);
		return mainX;
	}

	/**
	 * Festlegung der Chart Position
	 * @return Position für die Charts
	 */
	public String getChart() {
		String chartX = "top:12.0%;left:0.0%;";
		test(chartX);
		return chartX;
	}

	/**
	 * Testfunktion für Aufruf
	 * @param test  Testwert 
	 */
	private void test(String test) {
		// System.out.println(test);
	}

}
