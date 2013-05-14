package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;

public class Account implements Serializable{

	public Account(){
		
	}
	
	public Account(String name, int userId){
		this.name = name;
		this.userId = userId;
	}
	
	private int accountId;
	private String name;
	private double value;
	private int userId;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
