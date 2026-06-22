package base;

import utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;



public class BaseTest {

	protected WebDriver driver;

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
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			Log.info("Closing Browser...");
//			driver.quit();
		}
	}

}
