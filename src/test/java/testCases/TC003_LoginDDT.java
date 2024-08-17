package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups=("Datadriven"))
	public void verify_LoginDDT(String email,String pwd,String exp) {
		
		try {
		HomePage h=new HomePage(driver);
		h.clickMyAccount();
		h.clickLogin();
		
		LoginPage l=new LoginPage(driver);
		l.setEmail(email);
		l.setPassword(pwd);
		l.ClickLogin();
		
		MyAccountPage a=new MyAccountPage(driver);
		Boolean targetPage=a.isAccountPageExits();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				Assert.assertTrue(true);
				a.clickLogOut();
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("InValid")) {
			if(targetPage==true) {
				a.clickLogOut();
				Assert.assertTrue(false);
				
			}
			else {
				Assert.assertTrue(true);
			}
			
		}

	
	}catch(Exception e) {
		Assert.fail();
	}
	}
}
