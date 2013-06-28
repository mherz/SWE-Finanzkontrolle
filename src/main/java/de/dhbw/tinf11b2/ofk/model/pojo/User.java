package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




/**
 * @author felix
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "User", uniqueConstraints = {
		@UniqueConstraint(columnNames = "User_Id"),
		@UniqueConstraint(columnNames = "User_Name") })
public class User implements Serializable{

	/**
	 * 
	 */
	public User(){
		
	}
	
	/**
	 * @param name
	 * @param email
	 * @param password
	 */
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
	
	
	/**
	 * @return
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
