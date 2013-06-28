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
@Table(name = "Costs", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Costs_Id")})
public class Costs implements Serializable,Booking{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Costs_Id",unique = true, nullable = false)
	private int costsId;
	@Column(name="Costs_Value",nullable = false)
	private double value;
	@Column(name="Costs_Description")
	private String description;
	@Column(name="Costs_Timestamp",nullable = false)
	private Date timestamp;
	@ManyToOne
	@JoinColumn(name="Category_Id")
	private Category category;
	
	/**
	 * @return
	 */
	public int getCostsId() {
		return costsId;
	}
	/**
	 * @param costsId
	 */
	public void setCostsId(int costsId) {
		this.costsId = costsId;
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
