package de.dhbw.tinf11b2.ofk.model.dao;


import de.dhbw.tinf11b2.ofk.model.pojo.Account;

@SuppressWarnings("rawtypes")
public class AccountDAO extends AbstractHibernateDAO {
	
	@SuppressWarnings("unchecked")
	public AccountDAO ()
	{
		super(Account.class);
	}
	
}
