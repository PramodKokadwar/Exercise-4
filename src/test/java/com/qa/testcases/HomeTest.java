package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomeTest extends TestBase {
	
	LandingPage landingPage;
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;

	public HomeTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
 
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageAfterlogIn() throws InterruptedException, IOException {
		

		// click on login link
		landingPage.clickOnLoginLink();
		
		// Verify title of home page
				String loginPageTitle = loginPage.verifyLoginPageTitle();
				Assert.assertEquals(loginPageTitle, "Log in",
						"Login Page title not matched");
		 
		loginPage.insertUserId("pramodkokadwar@gmail.com");	
		loginPage.insertPassword("Fedex@12345");
		
		homePage.verifyAccount();
	
	}
	
	@Test(priority = 2)
	public void talkwithAskFedEx() throws InterruptedException, IOException {
		

		// click on login link
		landingPage.clickOnLoginLink();
		
		// Verify title of home page
				String loginPageTitle = loginPage.verifyLoginPageTitle();
				Assert.assertEquals(loginPageTitle, "Log in",
						"Login Page title not matched");
		 
		loginPage.insertUserId("pramodkokadwar@gmail.com");	
		loginPage.insertPassword("Fedex@12345");
		
		homePage.verifyAccount();
		
		
		// Ask FedEx Virtual Assistant
		homePage.clickFedExVirtualAssistant();
		homePage.UserInputFieldFedEx("Hello, I'm Pramod");
		homePage.verifyuserSays();
		
	
	}
	
	@Test(priority = 3)
	public void LocationStationNearByme() throws InterruptedException, IOException {
		

		// click on login link
		landingPage.clickOnLoginLink();
		
		// Verify title of home page
				String loginPageTitle = loginPage.verifyLoginPageTitle();
				Assert.assertEquals(loginPageTitle, "Log in",
						"Login Page title not matched");
		 
		loginPage.insertUserId("pramodkokadwar@gmail.com");	
		loginPage.insertPassword("Fedex@12345");
		
		// search your near by location
		homePage.verifyAccount();
		homePage.clickOnLocationLink();
		homePage.inputlocationName("Wiesbaden Germany");
		homePage.verifyLocationResult();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
