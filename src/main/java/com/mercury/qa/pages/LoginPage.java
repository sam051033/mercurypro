package com.mercury.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mercury.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public static String appTime;

	@FindBy(name="userName") 
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbutton;
	
	@FindBy(xpath="//div[@class='footer']")
	WebElement version;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody"
			+ "/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")
	WebElement time;
	
	

	//initializing the page elements thru constractor
	public LoginPage() {
		PageFactory.initElements(driver, this); //we can also put "this" instead of LoginPage.class
	}
	
	
	public String timecheck() {
		appTime=time.getText();
		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	
	public String title() {
		return driver.getTitle();
		
	}
	
	
	public String version() {
		return version.getText();
	}
	
	
	 
	public String login(String uname, String pword) {
		 username.sendKeys(uname);
		 password.sendKeys(pword);
		 loginbutton.click(); 
		 
		return driver.getTitle();
		 
		 
		
		
	}

	
	
}
