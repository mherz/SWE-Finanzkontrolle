package de.dhbw.tinf11b2.ofk.model;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.dhbw.tinf11b2.ofk.model.OFKModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class LoginTest {

	@Autowired
	OFKModel model;
	
	@Test
	public void testAuthenticate() {
		//erfolgreicher Login mit Testuser
		assertEquals(1,model.authenticate("test", "test"));


	}
	
	@Test
	public void testUserDontExist() {
		//User nicht in Datenbank vorhanden
		assertEquals(-1, model.authenticate("", ""));
	}
	
	@Test
	public void testPasswordWrong(){
		//Passwort Falsch
		assertEquals(0, model.authenticate("test", "blubber"));
	}
	

}
