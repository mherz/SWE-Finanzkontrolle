package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Costs;

/**
 * @author felix
 *
 */
public class CostsDAO extends AbstractHibernateDAO<Costs> implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CostsDAO(){
		super(Costs.class);
	}
	
	/**
	 * @param account
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Costs> getCostsByAccount(Account account){
		return this.sessionFactory.getCurrentSession().createQuery("from Costs").list();
	}
}
