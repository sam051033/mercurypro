package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(linkText="SIGN-OFF") 
	WebElement logout;
	
//	public LoginPage() {
//		PageFactory.initElements(driver, this); //we can also put "this" instead of LoginPage.class
//	}
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void logout() {
		logout.click();
	 
	}
	
	
}
