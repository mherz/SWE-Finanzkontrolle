package de.dhbw.tinf11b2.ofk.model;

import java.util.Date;

import de.dhbw.tinf11b2.ofk.model.dao.CostsDAO;
import de.dhbw.tinf11b2.ofk.model.dao.IncomeDAO;
import de.dhbw.tinf11b2.ofk.model.dao.UserDAO;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.model.pojo.Costs;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;
import de.dhbw.tinf11b2.ofk.model.pojo.User;

/**
 * @author felix
 * Class which contains methods for adding
 * new objects to the database
 *
 */
public class CreateModel implements OFKModel {

	private IncomeDAO incomeDAO;
	private CostsDAO costsDAO;
	private UserDAO userDAO;

	/**
	 * @param category
	 * @param value
	 * @param description
	 * Method to add income objects to the database
	 * @return false if the object could not stored into the database
	 */
	public boolean addIncome(Category category, double value, String description) {

		Income inc = new Income();
		inc.setCategory(category);
		inc.setValue(value);
		inc.setDescription(description);
		inc.setTimestamp(new Date());
		try {
			incomeDAO.create(inc);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param category
	 * @param value
	 * @param description
	 * Method to add Costs object into the database
	 * @return
	 */
	public boolean addCosts(Category category, double value, String description) {

		Costs costs = new Costs();
		costs.setCategory(category);
		costs.setValue(value);
		costs.setDescription(description);
		costs.setTimestamp(new Date());
		try {
			costsDAO.create(costs);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param email
	 * @param name
	 * @param password
	 * Method to add users into the database
	 */
	public void addUser(String email, String name, String password) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		userDAO.create(user);
	}

	public IncomeDAO getIncomeDAO() {
		return incomeDAO;
	}

	public void setIncomeDAO(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public CostsDAO getCostsDAO() {
		return costsDAO;
	}

	public void setCostsDAO(CostsDAO costsDAO) {
		this.costsDAO = costsDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	

}
