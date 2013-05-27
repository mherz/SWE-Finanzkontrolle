package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name = "User", uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Id"),
		@UniqueConstraint(columnNames = "User_Name") })
public class User implements Serializable{

	public User(){
		
	}
	
	public User(String name, String email, String password)
	{
		this.name = name;
		this.email = email;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Id",unique = true, nullable = false)
	private int userId;
	@Column(name="User_Name",unique = true, nullable = false)
	private String name;
	@Column(name="User_EMail",unique = true, nullable = false)
	private String email;
	@Column(name="User_Password",nullable = false)
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
