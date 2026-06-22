package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {
		
		System.out.println("Starting login test...");
		LoginPage loginPage = new LoginPage(driver);
		
		 System.out.println("Adding Credentials");
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		
		System.out.println("Title of the page is : " + driver.getTitle());
		 System.out.println("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
	
}
