package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;

public class LoginPage {

WebDriver driver;
private ElementUtils Eu;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Eu=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement Emailfield;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement Passfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMess;
	
	public void enterEmailAddress(String emailid)
	{
		Eu.typeTextIntoElement(Emailfield, emailid, 20);
		//Emailfield.sendKeys(emailid);
	}
	
	public void enterPassword(String pwordtext)
	{
		Eu.typeTextIntoElement(Passfield, pwordtext, 20);
		//Passfield.sendKeys(pwordtext);
	}
	
	public AccountPage ClickOnLoginButton()
	{
		Eu.clickOnElement(LoginButton, 15);
		//LoginButton.click();
		return new AccountPage(driver);
	}
	
	public String GetWarningMess()
	{
		return Eu.getTextFromElement(WarningMess, 20);
		//return WarningMess.getText();
	}
}
