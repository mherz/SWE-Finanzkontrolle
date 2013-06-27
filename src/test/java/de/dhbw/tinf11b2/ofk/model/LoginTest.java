package de.dhbw.tinf11b2.ofk.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/testApplicationContext.xml" })
public class LoginTest {

	@Autowired
	CreateModel model;
	@Autowired
	ActiveUserModel activeUser;
	
	@Before
	public void setUp(){
		try{
		model.addUser("test@testuser.de","test" , "test");
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("MySQL Exception falls User bereits existiert (setUp Methode)");
			System.out.println("MySQL Exception für Test nicht relevant (setUp Methode)");
		}
	}
	
	@Test
	public void testAuthenticate() {
		//erfolgreicher Login mit Testuser
		assertEquals(1,activeUser.authenticate("test", "test"));


	}
	
	@Test
	public void testUserDontExist() {
		//User nicht in Datenbank vorhanden
		assertEquals(-1, activeUser.authenticate("", ""));
	}
	
	@Test
	public void testPasswordWrong(){
		//Passwort Falsch
		assertEquals(0, activeUser.authenticate("test", "blubber"));
	}
	

}
