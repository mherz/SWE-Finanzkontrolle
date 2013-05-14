package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;

public class User implements Serializable{

	public User(){
		
	}
	
	public User(String name, String email, String password)
	{
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	private int userId;
	private String name;
	private String email;
	private String password;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
