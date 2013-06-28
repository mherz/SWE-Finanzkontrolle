package de.dhbw.tinf11b2.ofk.view;

/**
 * @author felix
 *
 */
public class Koordinaten {

	/**
	 * 
	 */
	public Koordinaten() {
	}

	/**
	 * @return
	 */
	public String getZurueck() {
		String zurueckX = "top:92.0%;left:90.0%;";
		test(zurueckX);
		return zurueckX;
	}
	
	/**
	 * @return
	 */
	public String empty(){
		return "blank";
	}

	/**
	 * @return
	 */
	public String getLabel() {
		String labelX = "top:3.0%;left:45.0%;";
		test(labelX);
		return labelX;
	}

	/**
	 * @return
	 */
	public String getMain() {
		String mainX = "top:10.0%;left:0.0px;";
		test(mainX);
		return mainX;
	}


	/**
	 * @return
	 */
	public String getChart() {
		String chartX = "top:12.0%;left:0.0%;";
		test(chartX);
		return chartX;
	}
	
	/**
	 * @param test
	 */
	private void test(String test){
//		System.out.println(test);
	}

}
