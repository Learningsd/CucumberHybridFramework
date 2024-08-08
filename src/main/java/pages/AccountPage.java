package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;

public class AccountPage 
{

    WebDriver driver;
    private ElementUtils Eu;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Eu=new ElementUtils(driver);
	}
	
	@FindBy(linkText = "Edit your account information")
	private WebElement EdityourAccountInfo;
	
	public boolean displaystatusofyouraccount()
	{
		return Eu.displayStatusOfElement(EdityourAccountInfo, 15);
		//return EdityourAccountInfo.isDisplayed();
	}
}
