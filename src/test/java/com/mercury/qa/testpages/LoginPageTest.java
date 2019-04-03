package com.mercury.qa.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.util.excelutility;



public class LoginPageTest extends TestBase{
	LoginPage loginpg;
	HomePage homepg;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		Thread.sleep(2000);
		loginpg=new LoginPage();
		homepg=new HomePage();
	}
	
	
	
	@Test(priority=1)
	public void PageTitleValidation() {
		String title=loginpg.title();
		AssertJUnit.assertEquals(title, "Welcome: Mercury Tours");
		System.out.println("page title :" +title);
	}
	
	 
	
	@Test(priority=2)
	public void loginpageTimeValidation() throws InterruptedException {
		
		String systemtime=loginpg.timecheck();
		System.out.println(systemtime);
		AssertJUnit.assertEquals(loginpg.appTime, systemtime);
		
		
	}
	
	
	@Test(priority=3)
	public void applicationVersion() {
		String version=loginpg.version();
		AssertJUnit.assertEquals(version, "© 2005, Mercury Interactive (v. 011003-1.01-058)");
		System.out.println("application version :" +version);
	}
	
	
	@Test(priority=4)
	public void loginvalidationwith_ValidUserName_and_ValidPassword() throws Exception {
		
		String path =prop.getProperty("excelpath");
		excelutility.setExcelFile(path, "Sheet1");
		int rowcount =excelutility.getRowCount(path, "Sheet1");
		
		System.out.println("ExcelData sheet total row "+rowcount);
		
			for(int i=1;i<=1;i++) {
			String  username = excelutility.getCellData(path, "Sheet1", i, 0);
			String password = excelutility.getCellData(path,"Sheet1",i, 1);
		
			String title =loginpg.login(username, password);
			System.out.println("Homepage title :" +title);
			AssertJUnit.assertEquals(title, "Find a Flight: Mercury Tours:");
			}
			System.out.println("Login Success !!!!!");
			


			
	 }
		
			@Test(priority=5)
			public void loginvalidationwithInvalidUserNameandValidPassword() throws Exception {
				
				//String path= "/Users/abdullah/eclipse-workspace/Amercury/src/main/java/exceldata/logindata.xlsx";
				String path =prop.getProperty("excelpath");
				excelutility.setExcelFile(path, "Sheet1");
				int rowcount =excelutility.getRowCount(path, "Sheet1");
				
				System.out.println(rowcount);
				
					for(int i=2;i<=rowcount;i++) {
					String  username = excelutility.getCellData(path, "Sheet1", i, 0);
					String password = excelutility.getCellData(path,"Sheet1",i, 1);
					//int per = Integer.parseInt(excelutility.getCellData(path,"Sheet1",i, 2));
					
					Thread.sleep(2000);
					
					String title=loginpg.login(username, password);
					
					//String homepageTitle=driver.getTitle();
					AssertJUnit.assertEquals(title, "Find a Flight: Mercury Tours:");
					
					 
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
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
