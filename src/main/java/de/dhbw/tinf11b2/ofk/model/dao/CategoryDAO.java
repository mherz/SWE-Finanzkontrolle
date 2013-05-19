package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;

import de.dhbw.tinf11b2.ofk.model.pojo.Category;

public class CategoryDAO extends AbstractHibernateDAO implements Serializable {

	public CategoryDAO (){
		super(Category.class);
	}
}
