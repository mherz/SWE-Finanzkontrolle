package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import de.dhbw.tinf11b2.ofk.model.pojo.User;

public class UserDAO extends AbstractHibernateDAO implements Serializable {

	public UserDAO() {
		super(User.class);
	}
	public User getUserByName(String username){
		List<User> result = this.sessionFactory.getCurrentSession().createQuery("from User where name = :username").setParameter("username",username).list();
		return !result.isEmpty() ? result.get(0) : null;
	}
	
}
