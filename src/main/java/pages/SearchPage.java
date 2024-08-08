package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;

public class SearchPage 
{

	WebDriver driver;
	private ElementUtils Eu;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		Eu=new ElementUtils(driver);
		
	}
	
	public String retrieveNoProductMessageText() {
		
		return Eu.getTextFromElement(noProductMessage, 20);
//		String noProductMessageText = noProductMessage.getText();
//		return noProductMessageText;
	}
	
	public boolean displayStatusOfHPValidProduct() {
		
		return Eu.displayStatusOfElement(validHPProduct, 20);
//		boolean displayStatus = validHPProduct.isDisplayed();
//		return displayStatus;
	}


}
