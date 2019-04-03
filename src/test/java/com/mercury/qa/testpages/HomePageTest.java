package com.mercury.qa.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;

import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SignonPage;
import com.mercury.qa.util.excelutility;

public class HomePageTest extends TestBase{
	
	LoginPage loginpg;
	HomePage homepg;
	SignonPage signonpg;
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		loginpg=new LoginPage();
		homepg=new HomePage(); 
	
		
	}
	
	
	@Test(priority=1)
	public void LogoutValidation() throws Exception {
		//first need to login and username and password will be provided from Excel sheet
		String path =prop.getProperty("excelpath");
		excelutility.setExcelFile(path, "Sheet1");
		int rowcount =excelutility.getRowCount(path, "Sheet1");
		
		System.out.println("ExcelData sheet total row "+rowcount);
		
			for(int i=1;i<=1;i++) {
			String  username = excelutility.getCellData(path, "Sheet1", i, 0);
			String password = excelutility.getCellData(path,"Sheet1",i, 1);
		
			String title=loginpg.login(username, password);
			
			Thread.sleep(2000);
			homepg.logout();
			String signonpageTitle=driver.getTitle();
			AssertJUnit.assertEquals(signonpageTitle, "Sign-on: Mercury Tours");
			System.out.println("SighOff page title :" +signonpageTitle);
			}
			
			
		
	
	}
	
	
	@AfterMethod
	public void captureScreen(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") +"/FailedScreenshots/" + result.getName() + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("!!!!!!!screenshot captured !!!!!!");
			
			
		}	
	}
	

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
