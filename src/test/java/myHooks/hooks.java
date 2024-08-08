package myHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.configReader;

public class hooks
{
	WebDriver driver;
    @Before
	public void setup()
	{
    	Properties proper=configReader.initializeProperties();
    	driver=DriverFactory.intializeBrowser(proper.getProperty("browser"));
    	driver.get(proper.getProperty("url"));
    	
	}
	
    @After
	public void teardown(Scenario scenario)
	{
    	String ScreenshotName=scenario.getName().replace(" ", "_");
    	
    	if(scenario.isFailed())
    	{
    		byte[] srcImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(srcImage, "image/png", ScreenshotName);
    	}
    	
    	
		driver.quit();
	}
}
