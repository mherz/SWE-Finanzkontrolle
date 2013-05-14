package de.dhbw.tinf11b2.ofk.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbw.tinf11b2.ofk.model.dao.AccountDAO;
import de.dhbw.tinf11b2.ofk.model.dao.UserDAO;
import de.dhbw.tinf11b2.ofk.model.pojo.User;

public class OFKModel implements Serializable {

	private User user;

	private UserDAO userDAO = new UserDAO();
	
	
	public boolean authenticate(String username, String password){
		System.out.println(userDAO);
		user = (User) userDAO.getByName(username);
		
		if(user.getPassword().equals(password))
			return true;
		else
			return false;
	}
	
}
