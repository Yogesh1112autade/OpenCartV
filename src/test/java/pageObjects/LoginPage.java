package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement txtPass;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement btnLogin;
	
	public void setEmail(String Email) {
		txtemail.sendKeys(Email);
	}
	public void setPassword(String pass) {
		txtPass.sendKeys(pass);
	}
	
	public void ClickLogin() {
		btnLogin.click();
	}
	
	
}
