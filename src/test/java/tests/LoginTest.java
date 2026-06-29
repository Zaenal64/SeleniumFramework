package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test");
		
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		
		Log.info("Adding Credentials");
		test.info("Adding Credentials");
		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		test.info("Clicking on Login Button");
		loginPage.clickLogin();
		
		System.out.println("Title of the page is : " + driver.getTitle());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		test.pass("Login Succesfull");
	}
	
	@Test
	public void testInValidLogin() {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test with invalid Credentials");
		
		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		
		
		Log.info("Adding Credentials");
		test.info("Adding Credentials");
		loginPage.enterUsername("Admin123");
		loginPage.enterPassword("admin123@");
		test.info("Clicking on Login Button");
		loginPage.clickLogin();
		
		System.out.println("Text of the invalid credentials is : " + loginPage.getInvalidCredentialsMessage());
		Log.info("Verifying Error text invalid credentials");
		test.info("Verifying Error Message");
		
		Assert.assertEquals(loginPage.getInvalidCredentialsMessage(), "Invalid credentials..123");
		
		test.pass("Login Succesfull");
	}
	
}
