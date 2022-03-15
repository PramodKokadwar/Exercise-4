package com.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {


	// location popUp
	@FindBy(xpath = "//div[@role='dialog']/div[@class='fxg-u-modal__wrapper u-scroll-vertical']/div[1]")
	WebElement locationPopUp;

	// location 
	@FindBy(xpath = "//h3[@class='fxg-geo-locator__title js-fxg-geo-title']")
	WebElement locationTitle;

	@FindBy(xpath = "//span[@class='fxg-geo-locator__button-label'][normalize-space()='English']")
	WebElement englishButton;

	@FindBy(xpath = "//span[@class='fxg-geo-locator__button-label'][normalize-space()='Deutsch']")
	WebElement deutschButton;

	@FindBy(xpath = "//a[contains(@title,'close')]")
	WebElement closeButton;


	// Cookies
	@FindBy(xpath = "//button[contains(text(),'ACCEPT ALL COOKIES')]")
	WebElement acceptAllCookieButton;


	@FindBy(xpath = "//label[contains(text(),'Tracking Cookies')]")
	WebElement  trackingCookiesCheckBox;


	// cookies popUp
	@FindBy(xpath = "//div[@class='fxg-cookie-consent__wrapper u-scroll-vertical']")
	WebElement cookiespopUp;


	// login button on home page
	@FindBy(xpath = "//span[contains(text(),'Sign Up/Log In')]")
	WebElement loginSignUpLink;

	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	WebElement loginLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	public boolean verifyLocationPopup()
	{
		return locationPopUp.isDisplayed();
	}

	public String verifyLocationPopUpTitle(){

		return locationTitle.getText();
	}

	public void clickonEnglish(){
		englishButton.click();
	}

	public boolean verifyCookiesPopup()
	{
		return cookiespopUp.isDisplayed();
	}

	public void clickTrackcookies(){
		trackingCookiesCheckBox.click();
	}

	public void clickonAcceptCookies(){
		acceptAllCookieButton.click();
	}

 
	public LoginPage clickOnLoginLink() throws IOException
	{ 
		Actions action = new Actions(driver);
	    action.moveToElement(loginSignUpLink).build().perform();
	    
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		loginLink.click();
	    return new LoginPage();  
	}



}
