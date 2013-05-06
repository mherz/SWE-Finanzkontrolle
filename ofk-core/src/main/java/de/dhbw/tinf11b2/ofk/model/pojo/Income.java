package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;
import java.util.Date;

public class Income implements Serializable{
	
	public Income(){
		
	}
	
	public Income(double value, String description, Date timestamp,int accountId){
		
		this.value = value;
		this.description = description;
		this.timestamp = timestamp;
		this.accountId = accountId;
		
	}

	private int incomeId;
	private double value;
	private String description;
	private Date timestamp;
	private int accountId;
	
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
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
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	
}
