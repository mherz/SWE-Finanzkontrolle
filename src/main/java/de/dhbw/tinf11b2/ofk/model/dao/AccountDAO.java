package de.dhbw.tinf11b2.ofk.model.dao;


import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;

@SuppressWarnings("rawtypes")
public class AccountDAO extends AbstractHibernateDAO implements Serializable {
	
	@SuppressWarnings("unchecked")
	public AccountDAO ()
	{
		super(Account.class);
	}
	@SuppressWarnings("unchecked")
	public List<Account> getAccounts(){
		List<Account> list = this.sessionFactory.getCurrentSession().createQuery("from Account").list();
		return list;
	}
	
}
