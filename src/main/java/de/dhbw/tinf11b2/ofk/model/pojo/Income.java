package de.dhbw.tinf11b2.ofk.model.pojo;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Income", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Income_Id")})
public class Income extends Booking implements Serializable{
	private static final long serialVersionUID = 1L;

	public Income() {

	}
	
	public Income(double value, String description, Date timestamp,Category category){
		
		this.value = value;
		this.description = description;
		this.timestamp = timestamp;
		this.category = category;
		
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
	@ManyToOne
	@JoinColumn(name="Category_Id",nullable = false)
	private Category category;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
