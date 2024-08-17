package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Properties p;
	@BeforeClass(groups={"Regression","Sanity","Master"})
	 @Parameters({"os","browser"})
	   public void setUp(String os,String br) throws IOException {
		
		FileReader f=new FileReader("C:\\Users\\Dell\\Desktop\\Work Place\\OpenCartV\\src\\config.properties");
		p=new Properties();
		p.load(f);
		
		   if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			   DesiredCapabilities capabilities=new DesiredCapabilities();
			   //os
			   if(os.equalsIgnoreCase("windows")) {
				   capabilities.setPlatform(Platform.WIN10);
			   }
			   else if(os.equalsIgnoreCase("mac")) {
				   capabilities.setPlatform(Platform.MAC);
			   }else {
				   System.out.println("No matching os");
				   return;
			   }
			   //Browser
			   switch(br.toLowerCase()) {
			   case "chrome":capabilities.setBrowserName("chrome");break;
			   case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			   default:System.out.println("No browser matching"); 
			       }
			 
			   driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			  }
		   if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			   
			   switch(br.toLowerCase()){
			   case "chrome":
				   WebDriverManager.chromedriver().setup();
				   driver=new ChromeDriver();
				   break;
			   case "edge":
				   WebDriverManager.edgedriver().setup();
				   driver=new EdgeDriver();
				   break;
			   case "firefox":
				   WebDriverManager.firefoxdriver().setup();
				   driver=new FirefoxDriver();
				   break;
			   default:System.out.println("Invalid browser name	..");return;
			   }
			
		   }
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"Regression","Sanity","Master"})
	public void tearDown()
	{  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		driver.close();
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
}
