package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;

public class IncomeDAO extends AbstractHibernateDAO implements Serializable{

	public IncomeDAO (){
		super(Income.class);
	}
	
	public List<Income> getIncomeByCategory(Category cat){
		
		return this.sessionFactory
				.getCurrentSession()
				.createQuery("select * from Income where Category_Id=:catid")
				.setParameter("catId", cat.getCatId())
				.list();
	}
	
	public List<Income> getIncomeByAccount(Account account){
		
		
		
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Income")
				.list();
	}
}
