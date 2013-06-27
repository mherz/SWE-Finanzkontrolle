package de.dhbw.tinf11b2.ofk.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.dhbw.tinf11b2.ofk.model.dao.AccountDAO;
import de.dhbw.tinf11b2.ofk.model.dao.CategoryDAO;
import de.dhbw.tinf11b2.ofk.model.dao.CostsDAO;
import de.dhbw.tinf11b2.ofk.model.dao.IncomeDAO;
import de.dhbw.tinf11b2.ofk.model.dao.UserDAO;
import de.dhbw.tinf11b2.ofk.model.pojo.Account;
import de.dhbw.tinf11b2.ofk.model.pojo.Booking;
import de.dhbw.tinf11b2.ofk.model.pojo.Category;
import de.dhbw.tinf11b2.ofk.model.pojo.Costs;
import de.dhbw.tinf11b2.ofk.model.pojo.Income;
import de.dhbw.tinf11b2.ofk.model.pojo.User;

public class ActiveUserModel implements OFKModel{

	private User user;
	private Account account;
	private List<Category> categories;
	private List<Income> income;
	private List<Costs> costs;

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


	public List<Income> getIncomeByAccount(Account account) {
		List<Income> list = incomeDAO.getIncomeByAccount(account);
		List<Income> result = new ArrayList<Income>();

		for (int i = 0; i < categories.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getCategory().getCatId() == categories.get(i)
						.getCatId())
					result.add(list.get(j));
			}
		}
		return result;
	}

	
	public List<Costs> getCostsByAccount(Account account) {
		List<Costs> list = costsDAO.getCostsByAccount(account);
		List<Costs> result = new ArrayList<Costs>();

		for (int i = 0; i < categories.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getCategory().getCatId() == categories.get(i)
						.getCatId())
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
	


	/** Statt Timestamp Gregorian Calendar
	 * @param booking
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private HashMap<Integer,Double> getValuesDate(List<? extends  Booking> booking) {
		HashMap<Integer,Double> result = new  HashMap<Integer,Double>(); // Map Monat => Summe
		for (int i = 0; i < booking.size(); i++) {
			Booking help = booking.get(i); //
			int monat = help.getTimestamp().getMonth();
			
			final boolean schonDa = result.containsKey(monat);
			System.out.println("getCostValuesDate monat="+monat+" value="+help.getValue()+" schonDa="+schonDa);
			result.put(monat, (schonDa)
                              ? result.get(monat) + help.getValue()
                              : help.getValue());
			System.out.println("getCostValuesDate monat="+monat+" value="+help.getValue()+" result="+result.get(monat));
		}
		return result;
	}

	public HashMap<Integer, Double> getCostValuesDate() {

		return getValuesDate(costs);
	}

	public HashMap<Integer, Double> getIncomeValuesDate() {

		return getValuesDate(income);
	}

	public Double[] getValues(List<? extends Booking> booking){
		Double[] result = new Double[categories.size()];
		Booking help = null;
		for (int j = 0; j < categories.size(); j++) {
			result[j] = 0D;
			for (int i = 0; i < booking.size(); i++) {
				help = booking.get(i);
				if (help.getCategory().getCatId() == categories.get(j)
						.getCatId())
					result[j] = result[j] + help.getValue();
			}
		}
		return result;
	}
	public Double[] getIncomeValues() {
		return getValues(income);
	}

	public Double[] getCostValues() {
		return getValues(costs);
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
		costs = getCostsByAccount(account);
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

	public List<Costs> getCosts() {
		return costs;
	}

	public void setCosts(List<Costs> costs) {
		this.costs = costs;
	}

}
