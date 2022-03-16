package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;


public class LoginTest extends TestBase {
	
	LandingPage landingPage;
	LoginPage loginPage;
	TestUtil testUtil;

	public LoginTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
 
	}
	
	@Test(priority = 1)
	public void verifyLandingPageTitleTest() throws InterruptedException {
		
		// Verify title of home page
		String landingPageTitle = landingPage.verifyLandingPageTitle();
		Assert.assertEquals(landingPageTitle, "Express Delivery, Courier & Shipping Services | FedEx United Kingdom",
				"Ladning page title not matched");
	}
	
	
	@Test(priority = 2)
	public void verifyLocationPopupTest() throws IOException {

		// Verify Cookies PopUp
		Assert.assertTrue(landingPage.verifyLocationPopup());
		
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		// Verify title of home page
		String CookiesPolicyTitle = landingPage.verifyLocationPopUpTitle();
		Assert.assertEquals(CookiesPolicyTitle, "Choose your location", "location title not matched");
		
		// Click on location
		landingPage.clickonEnglish();

	}
	
	
	@Test(priority = 3)
	public void verifyCookiesPopupTest() throws IOException {

		// Verify Cookies PopUp
		Assert.assertTrue(landingPage.verifyCookiesPopup());
		
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		// click on track cookies and accept
		landingPage.clickTrackcookies();
		landingPage.clickonAcceptCookies();
		 
	}
	
	@Test(priority = 4)
	public void verifyNotificationTest() throws IOException {

		// Verify Cookies PopUp
		Assert.assertTrue(landingPage.verifyLocationPopup());
		
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		// verify and close notification
		landingPage.VerifyNotication();
		landingPage.closeNotification();

	}
	
	
	
	@Test(priority = 5)
	public void fedExLogin() throws IOException {

		// click on login link
		landingPage.clickOnLoginLink();
		
		// Verify title of home page
				String loginPageTitle = loginPage.verifyLoginPageTitle();
				Assert.assertEquals(loginPageTitle, "Log in",
						"Login Page title not matched");
		 
		loginPage.insertUserId("pramodkokadwar@gmail.com");	
		loginPage.insertPassword("Fedex@12345");
		
	}
	

	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
