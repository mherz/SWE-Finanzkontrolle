package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;;

public class Income implements Serializable{
	
	public Income(){
		
	}
	
	public Income(double value, String description, Date timestamp,Account account){
		
		this.value = value;
		this.description = description;
		this.timestamp = timestamp;
		this.account = account;
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Income_Id", unique = true, nullable = false)
	private int incomeId;
	@Column(name="Income_Value", nullable = false)
	private double value;
	@Column(name="Income_Description")
	private String description;
	@Column(name="Income_Timestamp", nullable = false)
	private Date timestamp;
	
	private Account account;
	
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

	public Account getAccount() {
		return account;
	}

	public void setAccountId(Account account) {
		this.account = account;
	}
	
	
	
}
