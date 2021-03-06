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
@Table(name = "Category", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Category_Id")})
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * 
	 */
	public Category(){
		
	}
	
	/**
	 * @param name
	 * @param account
	 */
	public Category(String name, Account account){
		this.name = name;
		this.account = account;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Category_Id", unique = true, nullable = false)
	private int catId;
	@Column(name="Category_Name", nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name="Account_Id")
	private Account account;
	
	
	
	/**
	 * @return
	 */
	public int getCatId() {
		return catId;
	}
	/**
	 * @param catId
	 */
	public void setCatId(int catId) {
		this.catId = catId;
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
