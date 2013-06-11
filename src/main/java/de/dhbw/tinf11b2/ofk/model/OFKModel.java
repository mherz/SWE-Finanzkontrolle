package de.dhbw.tinf11b2.ofk.model;

import java.rmi.ConnectException;
import java.util.ArrayList;
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

	public boolean addIncome(Category category, double value, String description) {

		Income inc = new Income();
		inc.setCategory(category);
		inc.setValue(value);
		inc.setDescription(description);
		inc.setTimestamp(new Date());
		try{
		incomeDAO.create(inc);
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		setIncome(incomeDAO.getAll());
		return true;
	}

	public boolean addCosts(Category category, double value, String description) {
		
		Costs costs = new Costs();
		costs.setCategory(category);
		costs.setValue(value);
		costs.setDescription(description);
		costs.setTimestamp(new Date());
		try{
		costsDAO.create(costs);
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Category getCategoryByName(String catName) {
		for (Category iterator : categories) {
			if (iterator.getName().contentEquals(catName))
				return iterator;
		}

		return null;
	}

	public List<Category> getCategoriesByAccount(Account account) {
		
		return categoryDAO.getAccCategories(account);
	}

	public List<Income> getIncomeByCategory(Category category) {
		List<Income> list = incomeDAO.getIncomeByCategory(category);

		return list;
	}

	public List<Income> getIncomeByAccount(Account account) {
		List<Income> list = incomeDAO.getIncomeByAccount(account);
		List<Income> result = new ArrayList<Income>();
		
		for(int i = 0;i<categories.size();i++){
			for(int j = 0;j<list.size();j++){
				if(list.get(j).getCategory().getCatId()==categories.get(i).getCatId())
				result.add(list.get(j));
			}
		}
		
		return result;
	}

	public String[] getCategoryNames() {
		String[] result = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = categories.get(i).getName();
		}

		return result;
	}

	public Double[] getIncomeValues() {
		Double[] result = new Double[categories.size()];
		Income help = null;
		for (int j = 0; j < categories.size(); j++) {
			result[j] = 0D;
			for (int i = 0; i < income.size(); i++) {
				help = income.get(i);
				if (help.getCategory().getCatId()==categories.get(j).getCatId())
					result[j] = result[j] + help.getValue();
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
