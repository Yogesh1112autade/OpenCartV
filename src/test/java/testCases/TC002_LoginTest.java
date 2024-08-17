package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void LoginPage() {
		
		HomePage h=new HomePage(driver);
		h.clickMyAccount();
		h.clickLogin();
		
		LoginPage l=new LoginPage(driver);
		l.setEmail(p.getProperty("email"));
		l.setPassword(p.getProperty("password"));
		l.ClickLogin();
		
		MyAccountPage a=new MyAccountPage(driver);
		Assert.assertTrue(a.isAccountPageExits());
		}

}
