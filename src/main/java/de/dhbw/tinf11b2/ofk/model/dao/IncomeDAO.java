package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;

public class IncomeDAO extends AbstractHibernateDAO<Income> implements Serializable{
	private static final long serialVersionUID = 1L;

	public IncomeDAO (){
		super(Income.class);
	}
	
	
	public List<Income> getIncomeByAccount(Account account){
		
		return this.sessionFactory.getCurrentSession().createQuery("from Income").list();
//		return this.sessionFactory.getCurrentSession()
//				.createQuery("from Income as inc join Category.Category_Id as cat" +
//						" where cat.Account_Id=:accId")
//				.setParameter("accId", account.getAccountId())
//				.list();
	}
}
