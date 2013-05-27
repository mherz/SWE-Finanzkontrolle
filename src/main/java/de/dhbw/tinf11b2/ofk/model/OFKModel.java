package de.dhbw.tinf11b2.ofk.model;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbw.tinf11b2.ofk.model.dao.AccountDAO;
import de.dhbw.tinf11b2.ofk.model.dao.CategoryDAO;
import de.dhbw.tinf11b2.ofk.model.dao.IncomeDAO;
import de.dhbw.tinf11b2.ofk.model.dao.UserDAO;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;
import de.dhbw.tinf11b2.ofk.model.pojo.User;

public class OFKModel {

	private User user;
	private Account account;

	private UserDAO userDAO;
	private AccountDAO accountDAO;
	private CategoryDAO categoryDAO;
	private IncomeDAO incomeDAO;

	public int authenticate(String username, String password) {
		user = (User) userDAO.getUserByName(username);
		if (user != null )
			if(user.getPassword().equals(password))
				return 1;
			else
				return 0;
		else
			return -1;
	}
	public List<Account> getAccounts(){
		return accountDAO.getAccounts();
	}
//	public List<Category> getCategories(){
//		System.out.println(categoryDAO);
//		return categoryDAO.getAll();
//	}
	public void addIncome(Double value, String description){
		Income inc = new Income();
		inc.setValue(value);
		inc.setDescription(description);
		inc.setTimestamp(new Date());
		incomeDAO.create(inc);
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
	}

}
