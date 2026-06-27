package base;

import utils.Log;
import utils.ExtentReportManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments(
		    "user-data-dir=C:\\Users\\Zaenal\\AppData\\Local\\Google\\Chrome\\User Data"
		);
		options.addArguments("--profile-directory=Default");
		
		Log.info("Starting WebDriver...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to URL...");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			Log.info("Closing Browser...");
			driver.quit();
		}
	}

}
