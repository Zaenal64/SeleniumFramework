package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;
import utils.ExcelUtils;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = System.getProperty("user.dir") + "/testdata/testAutomation.xlsx";
		ExcelUtils.loadExcel(filePath, "testAutomation");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];

		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
//	@DataProvider(name="LoginData2")
//	public Object[][] getData(){
//		
//		return new Object[][] {
//			{"user1", "pass1"},
//			{"user2", "pass2"},
//			{"Admin", "admin123"}
//		};
//	}

	
//	@Test(dataProvider = "LoginData2")
	@Test
	@Parameters({"username","password"})
	public void testValidLogin(String username, String password) {

		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test " + username);

		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);

		Log.info("Adding Credentials");
		test.info("Adding Credentials");
//		loginPage.enterUsername("Admin");
//		loginPage.enterPassword("admin123");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		test.info("Clicking on Login Button");
		loginPage.clickLogin();

		System.out.println("Title of the page is : " + driver.getTitle());
		System.out.println("URl of the page is : " + driver.getCurrentUrl());
		Log.info("Verifying page title");
		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));

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

		test.fail("Login Unsuccesfull");
	}

}
