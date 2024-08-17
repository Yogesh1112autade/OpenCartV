package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//h2[contains(text(),\"My Account\")]")
	WebElement SmgHeading;
	
	@FindBy(xpath="(//a[contains(text(),\"Logout\")])[2]")
	WebElement clkLogOut;

	public boolean isAccountPageExits() {
		try {
		return (SmgHeading.isDisplayed());
		}catch(Exception e) {
			return false;
		}
	}
	public void clickLogOut() {
		clkLogOut.click();
	}

}
