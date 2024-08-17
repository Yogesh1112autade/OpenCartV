package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnkRegister;

@FindBy(xpath="//a[contains(text(),\"Login\")]") 
WebElement lnkLogin;

public void clickMyAccount()
{		
//	WebDriverWait w =new WebDriverWait(driver,50);
//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class=\"d-none d-md-inline\"])[3]")));
	lnkMyaccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}
  public void clickLogin() {
	  lnkLogin.click();
  }

}
