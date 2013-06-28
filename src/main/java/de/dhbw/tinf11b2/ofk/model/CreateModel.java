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
	 * @return
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
	 */
	public void addUser(String email, String name, String password) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		userDAO.create(user);
	}

}
