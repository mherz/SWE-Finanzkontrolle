package de.dhbw.tinf11b2.ofk.model.dao;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;

public class AccountDAO extends AbstractHibernateDAO {
	
	public AccountDAO ()
	{
		super(Account.class);
	}

}
