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


/**
 * @author felix
 *
 */
@Entity
@Table(name = "Income", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Income_Id")})
public class Income implements Serializable,Booking{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Income() {

	}
	
	/**
	 * @param value
	 * @param description
	 * @param timestamp
	 * @param category
	 */
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
	
	/**
	 * @return
	 */
	public int getIncomeId() {
		return incomeId;
	}
	/**
	 * @param incomeId
	 */
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#getValue()
	 */
	public double getValue() {
		return value;
	}
	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#setValue(double)
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#setDescription(java.lang.String)
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#getTimestamp()
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#setTimestamp(java.util.Date)
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#getCategory()
	 */
	public Category getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see de.dhbw.tinf11b2.ofk.model.pojo.Booking#setCategory(de.dhbw.tinf11b2.ofk.model.pojo.Category)
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
