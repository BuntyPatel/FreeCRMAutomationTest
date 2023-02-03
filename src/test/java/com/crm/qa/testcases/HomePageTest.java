package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	

	public HomePageTest() {
		super();
	}
	
	
	//test cases should be separated -- indepent with eachother
	//Before each test case -- lauch the browser and login
	//@test -- execute tets case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String homePagetitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRMPRO", "Home page title not matched");
	}
	
	@Test(priority = 2)
	public void verifyCorrectUserName() {
		testUtil.SwitchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName()); 
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.SwitchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
