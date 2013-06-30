package de.dhbw.tinf11b2.ofk.test.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumZeitUebersichtIntegrationTest {
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
  public void testSeleniumZeitBersicht() throws Exception {
	    driver.get(baseUrl + "/ofk-core/");
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.xpath("//input[@type='text']")).isDisplayed()) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }

	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test");
	    driver.findElement(By.cssSelector("span.v-button-caption")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (driver.findElement(By.cssSelector("span.v-button-wrap")).isDisplayed()) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("span.v-button-wrap")).isDisplayed()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("span.v-button-wrap")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("div.v-filterselect-button")).isDisplayed()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("span.v-button-caption")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("g.highcharts-tracker > g > rect")).isDisplayed()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertTrue(isElementPresent(By.cssSelector("g.highcharts-tracker > g > rect")));
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
