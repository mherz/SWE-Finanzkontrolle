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


/**
 * @author felix
 *
 */
@Entity
@Table(name = "Account", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Account_Id")})
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	public Account(){
		
	}
	
	/**
	 * @param name
	 * @param user
	 */
	public Account(String name, User user){
		this.name = name;
		this.user = user;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Account_Id", unique = true, nullable = false)
	private int accountId;
	
	@Column(name="Account_Name",nullable = false)
	private String name;
	
	@Column(name="Account_Value")
	private double value;
	@ManyToOne
	@JoinColumn(name="User_Id")
	private User user;

	
	/**
	 * @return
	 */
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param user
	 */
	public void setUserId(User user) {
		this.user = user;
	}



}
