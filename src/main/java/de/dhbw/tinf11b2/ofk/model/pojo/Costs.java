package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;

public class Costs implements Serializable{

	private int costsId;
	private double value;
	private String description;
	private int accountId;
	
	public int getCostsId() {
		return costsId;
	}
	public void setCostsId(int costsId) {
		this.costsId = costsId;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
}
