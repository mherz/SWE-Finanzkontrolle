package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;

/**
 * @author felix
 *
 */
public class AccountDAO extends AbstractHibernateDAO<Account> implements
		                                               Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AccountDAO() {
		super(Account.class);
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getAccounts() {
		List<Account> list = this.sessionFactory.getCurrentSession()
				.createQuery("from Account").list();
		return list;
	}

}
