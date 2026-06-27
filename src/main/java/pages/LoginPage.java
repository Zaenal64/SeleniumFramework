package pages;

import org.openqa.selenium.By;
import utils.Log;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	private WebDriver driver;

	private By passwordTextBox = By.name("password");
	private By loginButton = By.cssSelector("button[type='submit']");


	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		Log.info("Entering Username");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		emailField.clear();
		emailField.sendKeys(username);
	}

	public void enterPassword(String password) {
		Log.info("Entering Password");
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		Log.info("Clicking login button.");
		driver.findElement(loginButton).click();
	}

}
