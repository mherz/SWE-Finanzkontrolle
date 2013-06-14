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

import de.dhbw.tinf11b2.ofk.presenter.OFKPresenter;
import de.dhbw.tinf11b2.ofk.view.Startseite;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/testApplicationContext.xml" })
public class SeleniumEingabenEingebenIT {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/ofk-core";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSeleniumEingabenEingeben() throws Exception {
		driver.get(baseUrl + "/ofk-core/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By
						.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div/div")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div/div/div[4]/div/span"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By
						.cssSelector("div.v-filterselect-button")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.cssSelector("div.v-filterselect-button")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[6]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(
				"600");
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[8]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[12]/div/div"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[8]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[9]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(
				"700");
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[11]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[12]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[14]/div/div"))
				.click();
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys(
				"800");
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[14]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[15]/div/div"))
				.click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("VAADIN_COMBOBOX_OPTIONLIST")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(
				By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"))
				.click();
		driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(
				"900");
		driver.findElement(
				By.xpath("//div[@id='ofkcore-1544256749']/div/div[2]/div/div/div/div[2]/div/div[18]/div/span/span"))
				.click();
		// Warning: verifyTextPresent may require manual changes
		try {
			assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
					.matches("^[\\s\\S]*Daten Eingegeben[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		// Warning: assertTextPresent may require manual changes
		assertTrue(driver.findElement(By.cssSelector("BODY")).getText()
				.matches("^[\\s\\S]*Daten Eingegeben[\\s\\S]*$"));
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
