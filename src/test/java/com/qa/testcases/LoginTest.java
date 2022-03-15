package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;


public class LoginTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;

	public LoginTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
 
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() throws InterruptedException {
		
		// Verify title of home page
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Express Delivery, Courier & Shipping Services | FedEx United Kingdom",
				"Ladning page title not matched");
	}
	
	
	@Test(priority = 2)
	public void verifyLocationPopupTest() throws IOException {

		// Verify Cookies PopUp
		Assert.assertTrue(homePage.verifyLocationPopup());
		
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		// Verify title of home page
		String CookiesPolicyTitle = homePage.verifyLocationPopUpTitle();
		Assert.assertEquals(CookiesPolicyTitle, "Choose your location", "location title not matched");
		
		// Click on location
		homePage.clickonEnglish();

	}
	
	
	@Test(priority = 3)
	public void verifyCookiesPopupTest() throws IOException {

		// Verify Cookies PopUp
		Assert.assertTrue(homePage.verifyCookiesPopup());
		
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		// click on track cookies and accept
		homePage.clickTrackcookies();
		homePage.clickonAcceptCookies();
		 
	}
	
	
	@Test(priority = 4)
	public void fedExLogin() throws IOException {

		// click on login link
		homePage.clickOnLoginLink();
		
		// Verify title of home page
				String homePageTitle = homePage.verifyHomePageTitle();
				Assert.assertEquals(homePageTitle, "Log in",
						"Login Page title not matched");
		 
		loginPage.insertUserId("pramodkokadwar@gmail.com");	
		loginPage.insertPassword("Greate@123");
		
	}
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
