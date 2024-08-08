package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;


public class HomePage 
{

	WebDriver driver;
	private ElementUtils Eu;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Eu=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']" )
	private WebElement MyAccountDropMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement Loginoption;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	
	public void clickonMyaccount()
	{
		Eu.clickOnElement(MyAccountDropMenu, 20);
		
	}
	
	public LoginPage clickonlogin()
	{
		Eu.clickOnElement(Loginoption, 20);
		
		return new LoginPage(driver);
	}
	
	public RegisterPage clickonregister()
	{
		Eu.clickOnElement(RegisterOption, 15);
		
		return new RegisterPage(driver);
	}
	
	 public void enterProductIntoSearchBoxField(String productText) {
			
		    Eu.typeTextIntoElement(searchBoxField, productText, 15);
			
			
		}
		
	    public SearchPage clickOnSearchButton() {
			
	    	Eu.clickOnElement(searchButton, 20);
			
			return new SearchPage(driver);
			
			
			
		}
}
