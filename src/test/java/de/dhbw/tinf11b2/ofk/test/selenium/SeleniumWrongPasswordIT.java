package de.dhbw.tinf11b2.ofk.test.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.dhbw.tinf11b2.ofk.view.LoginSeite;
import de.dhbw.tinf11b2.ofk.presenter.OFKUI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/testApplicationContext.xml" })
public class SeleniumWrongPasswordIT {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	@Autowired
	private OFKUI OFKUI;
	
	@Before
	public void setUp() throws Exception {
		OFKUI.setStartView(new LoginSeite());
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/ofk-core";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSeleniumWrongPassword() throws Exception {
		driver.get(baseUrl + "/ofk-core");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (driver.findElement(By.xpath("//input[@type='text']"))
						.isDisplayed())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(
				"blubb");
		driver.findElement(By.cssSelector("span.v-button-caption")).click();
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver
				.findElement(By.cssSelector("BODY"))
				.getText()
				.matches(
						"^[\\s\\S]*Bitte geben Sie ihr Passwort erneut ein[\\s\\S]*$"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
