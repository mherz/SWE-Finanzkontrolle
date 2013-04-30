package de.dhbw.tinf11b2.ofk.model.pojo;

public class CategoryDAO {

	public CategoryDAO(){
		
	}
	
	public CategoryDAO(String name, int accountId){
		this.name = name;
		this.accountId = accountId;
	}
	
	private int catId;
	private String name;
	private int accountId;
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	
}
