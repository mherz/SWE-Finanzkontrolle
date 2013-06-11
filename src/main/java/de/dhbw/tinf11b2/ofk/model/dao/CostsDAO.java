package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Costs;

@SuppressWarnings({ "serial", "rawtypes" })
public class CostsDAO extends AbstractHibernateDAO implements Serializable{

	@SuppressWarnings("unchecked")
	public CostsDAO(){
		super(Costs.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Costs> getCostsByAccount(Account account){
		
		return this.sessionFactory.getCurrentSession().createQuery("from Income").list();
	
	}
	
}
