package de.dhbw.tinf11b2.ofk.model.dao;

import de.dhbw.tinf11b2.ofk.model.pojo.Category;

public class CategoryDAO extends AbstractHibernateDAO {

	public CategoryDAO (){
		super(Category.class);
	}
}