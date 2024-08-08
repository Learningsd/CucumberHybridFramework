package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.commonUtils;

public class Login 
{
	WebDriver driver;
	private LoginPage Lp;
	private AccountPage Ap;
		
	
	@Given("User has Navigated to Login Page")
	public  void User_has_Navigated_to_Login_Page()
	{
		driver=DriverFactory.getDriver();
		HomePage Hp=new HomePage(driver);
		Hp.clickonMyaccount();
		Lp=Hp.clickonlogin();
	
		
	}
	
	@When("^User has entered Valid email address (.+) into email field$")
	public void user_has_entered_valid_email_address_into_email_field_using_datadrivern(String Emailtext) {
		
	 
		Lp.enterEmailAddress(Emailtext);
	}

	@When("^User has entered Valid Password (.+) into password filed$")
	public void user_has_entered_valid_password_into_password_filed_using_datadrivern(String Passwordtext) 
	{
		Lp.enterPassword(Passwordtext);
	}
	
	@When("User has entered valid email address {string} into email field")
	public void user_has_entered_valid_email_address_into_email_field(String Emailtext) {
		
	 
	  Lp.enterEmailAddress(Emailtext);
	}

	@When("User has entered valid Password {string} into password filed")
	public void user_has_entered_valid_password_into_password_filed(String Passwordtext) 
	{
	 Lp.enterPassword(Passwordtext);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() 
	{
	
		Ap=Lp.ClickOnLoginButton();
	}

	@Then("user Should got successfully login in")
	public void user_should_got_successfully_login_in() 
	{
		
	   Assert.assertTrue(Ap.displaystatusofyouraccount());
		
	}

	@When("User has entered InValid email address into email field")
	public void user_has_entered_in_valid_email_address_into_email_field() 
	{
		
		Lp.enterEmailAddress(commonUtils.getGmailWithTimestamp());
	
	   
	}

	@When("User has entered InValid Password {string} into password filed")
	public void user_has_entered_in_valid_password_into_password_filed(String InvalidPasswordText) 
	{
		Lp.enterPassword(InvalidPasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() 
	{
	    
		Assert.assertTrue(Lp.GetWarningMess().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter  email address into email field")
	public void user_dont_enter_email_address_into_email_field() 
	{
	    
	    Lp.enterEmailAddress("");
		
	}
	
	

	@When("User dont enter Password into password filed")
	public void user_dont_enter_password_into_password_filed() 
	{
		Lp.enterPassword("");
		
	}
	
	
	

}
