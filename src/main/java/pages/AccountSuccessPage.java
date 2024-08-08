package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtils;

public class AccountSuccessPage 
{
	
	  WebDriver driver;
	  private ElementUtils Eu;
	  
		@FindBy(xpath="//div[@id='content']/h1")
		private WebElement accountSuccessPageHeading;
		
		public AccountSuccessPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver,this);
			Eu=new ElementUtils(driver);
			
		}
		
		public String retrieveAccountSuccessPageHeading() {
			
			return Eu.getTextFromElement(accountSuccessPageHeading, 20);
//			String accountSuccessPageHeadingText = accountSuccessPageHeading.getText();
//			return accountSuccessPageHeadingText;
		}


	}



