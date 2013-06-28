package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;

/**
 * @author felix
 *
 */
public class IncomeDAO extends AbstractHibernateDAO<Income> implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public IncomeDAO (){
		super(Income.class);
	}
	
	/**
	 * @param account
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Income> getIncomeByAccount(Account account){
		List<Income> result = this.sessionFactory.getCurrentSession()
				.createQuery("select I.* from Income as I,Category as C,Account as A " +
						"where I.Category_Id = C.Category_Id" +
						"and C.Account_Id = A.Account_Id")
				.setParameter("accId", account.getAccountId())
				.list();
//		return this.sessionFactory.getCurrentSession().createQuery("from Income").list();
		return result;
	}
}
