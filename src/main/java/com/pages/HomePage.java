package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage  extends TestBase {


	// Ask FedEx
	@FindBy(id = "vaHeaderId")
	WebElement askFedex;

	// account name
	@FindBy(xpath = "//span[contains(text(),'Pramod')]")
	WebElement locationPopUp;


	// Ask FedEx Virtual Assistant
	@FindBy(xpath = "//textarea[@class='nw_UserInputField nw_UserInputFocus']")
	WebElement UserInputField;

	// submit button
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement clickSbumit;

	// submit button
	@FindBy(xpath = "//div[@class='nw_UserSays']")
	WebElement verifyUserSays;


	// close the FedEx Virtual Assistant
	@FindBy(xpath = "//div[@class='nw_CloseXX']")
	WebElement clickOnClose;

	// click on shipping
	@FindBy(xpath = "//span[normalize-space()='Shipping']")
	WebElement ShippingLink;


	// click on shipping
	@FindBy(xpath = "//a[@aria-label='Locations']")
	WebElement locationLink;

	// input text in search
	@FindBy(xpath = "//input[@placeholder ='Find locations near...']")
	WebElement locationsNearByme;


	// click on shipping
	@FindBy(xpath = "//input[@aria-label ='Search for locations (new window)']")
	WebElement clickOnsearchBtn;
	
	
	// verify result
	@FindBy(xpath = "//div[@class='placardDetails']//p[@class='fx-location-address'][contains(text(),'Unterer Zwerchweg 111')]")
	WebElement verifyLocationResult;


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	// verify user is login
	public boolean verifyAccount()
	{
		return locationPopUp.isDisplayed();
	}


	// click on FedEx Virtual Assistant
	public void clickFedExVirtualAssistant()
	{
		askFedex.click();
	}

	public void UserInputFieldFedEx(String question)
	{
		UserInputField.sendKeys(question);
		clickSbumit.click();
	}

	public boolean verifyuserSays()
	{
		return verifyUserSays.isDisplayed();
	}
	
	public HomePage clickOnLocationLink() throws IOException
	{ 
		Actions action = new Actions(driver);
	    action.moveToElement(ShippingLink).build().perform();
	    
		// Take screenshot
		TestUtil.takeScreenshotAtEndOfTest();
		
		locationLink.click();
	    return new HomePage();  
	}
	
	public void inputlocationName(String locationName)
	{
		locationsNearByme.sendKeys(locationName);
		clickOnsearchBtn.click();
		
	}
	
	// location is display
	public boolean verifyLocationResult()
	{
		return verifyLocationResult.isDisplayed();
	}

}
