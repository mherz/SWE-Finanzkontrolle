package de.dhbw.tinf11b2.ofk.model.pojo;

import java.util.Date;

public abstract class Booking {
	
	public abstract Date getTimestamp();
	public abstract Category getCategory();
	public abstract double getValue();
}
