package de.dhbw.tinf11b2.ofk.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import de.dhbw.tinf11b2.ofk.model.ActiveUserModel;
import de.dhbw.tinf11b2.ofk.model.CreateModel;

@ContextConfiguration(locations = { "classpath:/cucumber.xml" })
public class InsertcostsStepDefinitions {
	
	@Autowired
	ActiveUserModel activeUser = new ActiveUserModel();
	@Autowired
	CreateModel model = new CreateModel();

	
	@Given("^an existing <account> is chosen$")
	public void an_existing_account_is_chosen() throws Throwable {
		
		
	    activeUser.authenticate("test", "test");
	    assertTrue("The user exists",activeUser.getUser()!=null);
	}

	@When("^I enter €(\\d+) single costs$")
	public void I_enter_€_single_costs(int arg1) throws Throwable {
		assertTrue("costs added",model.addCosts(activeUser.getCategoryByName("default"), 100D, "test"));
	}
}
