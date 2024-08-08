package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.commonUtils;

public class DriverFactory 
{
	static WebDriver driver=null;

	public static WebDriver intializeBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("edge"))
		{
			driver =new EdgeDriver();
		}else if(BrowserName.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(commonUtils.IMPLICITY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(commonUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	
}
