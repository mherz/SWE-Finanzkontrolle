package de.dhbw.tinf11b2.ofk.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbw.tinf11b2.ofk.model.dao.AccountDAO;
import de.dhbw.tinf11b2.ofk.model.dao.CategoryDAO;
import de.dhbw.tinf11b2.ofk.model.dao.CostsDAO;
import de.dhbw.tinf11b2.ofk.model.dao.IncomeDAO;
import de.dhbw.tinf11b2.ofk.model.dao.UserDAO;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.model.pojo.Costs;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;
import de.dhbw.tinf11b2.ofk.model.pojo.User;

public class OFKModel {

	private User user;
	private Account account;
	private List<Category> categories;
	private List<Income> income;

	private UserDAO userDAO;
	private AccountDAO accountDAO;
	private CategoryDAO categoryDAO;
	private IncomeDAO incomeDAO;
	private CostsDAO costsDAO;

	public int authenticate(String username, String password) {
		user = (User) userDAO.getUserByName(username);
		if (user != null)
			if (user.getPassword().equals(password)) {
				setAccount(accountDAO.getAccounts().get(0));
				return 1;
			} else
				return 0;
		else
			return -1;
	}

	public void addIncome(Category category, double value, String description) {
		Income inc = new Income();
		inc.setCategory(category);
		inc.setValue(value);
		inc.setDescription(description);
		inc.setTimestamp(new Date());
		incomeDAO.create(inc);
	}

	public void addCosts(Category category, double value, String description) {
		Costs costs = new Costs();
		costs.setCategory(category);
		costs.setValue(value);
		costs.setDescription(description);
		costs.setTimestamp(new Date());
		costsDAO.create(costs);

	}

	public Category getCategoryByName(String catName) {
		for (Category iterator : categories) {
			if (iterator.getName().contentEquals(catName))
				return iterator;
		}

		return null;
	}

	public List<Category> getCategoriesByAccount(Account account) {
		System.out.println(categoryDAO);
		return categoryDAO.getAccCategories(account);
	}

	public List<Income> getIncomeByCategory(Category category) {
		List<Income> list = incomeDAO.getIncomeByCategory(category);

		return list;
	}

	public List<Income> getIncomeByAccount(Account account) {
		return incomeDAO.getIncomeByAccount(account);
	}

	public String[] getCategoryNames() {
		String[] result = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = categories.get(i).getName();
		}

		return result;
	}

	public Double[] getIncomeValues() {
		Double[] result = new Double[income.size()];
		Income help = null;
		for (int j = 0; j < categories.size(); j++) {
			for (int i = 0; i < income.size(); i++) {
				help = income.get(i);
				if (help.getCategory().equals(categories.get(j)))
					result[j] += income.get(i).getValue();
			}
		}
		return result;
	}

	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
		categories = getCategoriesByAccount(account);
		income = getIncomeByAccount(account);
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public IncomeDAO getIncomeDAO() {
		return incomeDAO;
	}

	public void setIncomeDAO(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public List<Income> getIncome() {
		return income;
	}

	public void setIncome(List<Income> income) {
		this.income = income;
	}

	public CostsDAO getCostsDAO() {
		return costsDAO;
	}

	public void setCostsDAO(CostsDAO costsDAO) {
		this.costsDAO = costsDAO;
	}

	public void logout() {
		user = null;
		account = null;
		categories = null;
		income = null;

	}

}
