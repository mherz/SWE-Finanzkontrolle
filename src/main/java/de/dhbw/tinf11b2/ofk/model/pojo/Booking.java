package de.dhbw.tinf11b2.ofk.model.pojo;

import java.util.Date;

/**
 * @author felix
 *
 */
public  interface Booking {
	
	public Date getTimestamp();
	public Category getCategory();
	public double getValue();
	public void setCategory(Category category);
	public void setValue(double Value);
	public void setDescription(String descrition);
	public void setTimestamp(Date timestamp);
	
	
}
