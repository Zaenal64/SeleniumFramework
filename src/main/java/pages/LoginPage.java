package pages;

import org.openqa.selenium.By;
import utils.Log;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	private WebDriver driver;

	@FindBy(name="username")
	WebElement usernameTextbox;
	
	@FindBy(name="password")
	WebElement passwordTesxtBox;
	
	@FindBy(css = "button[type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement textInvalidCredentials;
	
	
//	private By passwordTextBox = By.name("password");
//	private By loginButton = By.cssSelector("button[type='submit']");
//	private By textInvalidCredentials = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		Log.info("Entering Username");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(usernameTextbox));
		emailField.clear();
		emailField.sendKeys(username);
	}

	public void enterPassword(String password) {
		Log.info("Entering Password");
		passwordTesxtBox.clear();
		passwordTesxtBox.sendKeys(password);
//		driver.findElement(passwordTextBox).clear();
//		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		Log.info("Clicking login button.");
		loginButton.click();
//		driver.findElement(loginButton).click();
	}
	
	public String getInvalidCredentialsMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Log.info("Invalid Credentials");
		return wait.until(ExpectedConditions
	            .visibilityOf(textInvalidCredentials))
	            .getText();
	}

}
