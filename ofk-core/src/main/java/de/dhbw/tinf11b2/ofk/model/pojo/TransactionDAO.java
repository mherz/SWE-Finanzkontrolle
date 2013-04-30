package de.dhbw.tinf11b2.ofk.model.pojo;

import java.util.Date;

public class TransactionDAO {

	public TransactionDAO(){
		
	}
	
	public TransactionDAO(String message, Date tDate, int accountId){
		this.message = message;
		this.tDate = tDate;
		this.accountId = accountId;
	}
	
	private int tId;
	private String message;
	private Date tDate;
	private int accountId;
	

	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

}
