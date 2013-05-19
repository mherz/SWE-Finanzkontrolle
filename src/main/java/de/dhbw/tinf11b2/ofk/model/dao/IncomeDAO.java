package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;

import de.dhbw.tinf11b2.ofk.model.pojo.Income;

public class IncomeDAO extends AbstractHibernateDAO implements Serializable{

	public IncomeDAO (){
		super(Income.class);
	}
	
}
