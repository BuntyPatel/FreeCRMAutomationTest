package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.info("***********************Starting Test Case*************************");
		log.info("***********************loginPageTitleTest*************************");
		String title = loginPage.validateLoginPageTitle();
		log.info("Login Page title is --->" + title);
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.", "Login page title not matched");
		log.info("***********************Ending Test Case*************************");
		log.info("***********************loginPageTitleTest*************************");
		
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		log.info("***********************Starting Test Case*************************");
		log.info("***********************crmLogoImageTest*************************");
		boolean flag = loginPage.validatCRMImage();
		log.info("Checking the CRM logo image");
		Assert.assertTrue(flag);
		log.info("***********************Ending Test Case*************************");
		log.info("***********************crmLogoImageTest*************************");
	}
	
	@Test(priority=3)
	public void loginTest() {
		log.info("***********************Starting Test Case*************************");
		log.info("***********************loginTest*************************");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Logging in into App");
		log.info("***********************Ending Test Case*************************");
		log.info("***********************loginTest*************************");
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("=======================Browser Closed=========================");
		log.info("=======================LoginPageTest Ended=========================");
	}
	

	
	
}
