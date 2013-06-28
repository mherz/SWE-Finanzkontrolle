package de.dhbw.tinf11b2.ofk.model.dao;

import java.io.Serializable;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.pojo.User;

/**
 * @author felix
 *
 */
public class UserDAO extends AbstractHibernateDAO<User> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public UserDAO() {
		super(User.class);
	}
	/**
	 * @param username
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User getUserByName(String username){
		List<User> result = this.sessionFactory.getCurrentSession().createQuery("from User where name = :username").setParameter("username",username).list();
		return !result.isEmpty() ? result.get(0) : null;
	}
	
}
