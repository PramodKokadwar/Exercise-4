package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	// insert userId
	@FindBy(id = "userId")
	WebElement userId;

	// insert  password
	@FindBy(xpath = "password")
	WebElement password;
	
	// Initializing the Page Objects:
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
	
		public void insertUserId(String userid){
			userId.sendKeys(userid);
		}
		
		public void insertPassword(String pwd){
			password.sendKeys(pwd);
		}
}
