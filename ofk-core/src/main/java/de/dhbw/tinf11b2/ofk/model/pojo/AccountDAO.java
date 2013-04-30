package de.dhbw.tinf11b2.ofk.model.pojo;

public class AccountDAO {

	public AccountDAO(){
		
	}
	
	public AccountDAO(String name, int userId){
		this.name = name;
		this.userId = userId;
	}
	
	private int accountId;
	private String name;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
