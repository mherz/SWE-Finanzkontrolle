package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;

import de.dhbw.tinf11b2.ofk.model.pojo.Costs;

public class CostsDAO extends AbstractHibernateDAO implements Serializable{

	public CostsDAO(){
		super(Costs.class);
	}
	
}
