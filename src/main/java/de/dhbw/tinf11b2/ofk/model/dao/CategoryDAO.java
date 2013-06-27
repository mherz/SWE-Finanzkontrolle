package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;


public class CategoryDAO extends AbstractHibernateDAO<Category> implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategoryDAO (){
		super(Category.class);
	}
	@SuppressWarnings("unchecked")
	public List<Category> getAccCategories(Account account){
		int accId = account.getAccountId();
		List<Category> result = this.sessionFactory
				.getCurrentSession()
				.createQuery("from Category where Account_Id=:accId")
				.setParameter("accId", accId).list();
		return result;
		
	}
}
