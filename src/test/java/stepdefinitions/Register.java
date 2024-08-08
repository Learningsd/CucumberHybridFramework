package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilities.commonUtils;

public class Register 
{
	WebDriver driver;
	private RegisterPage Rp;
	private AccountSuccessPage As;
	
	@Given("User Navigates to Register Account Page")
	public void user_navigates_to_register_account_page() 
	{
		driver=DriverFactory.getDriver();
		HomePage Hp=new HomePage(driver);
		Hp.clickonMyaccount();
		Rp=Hp.clickonregister();
		
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) 
	{
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		Rp.enterFirstName(dataMap.get("firstname"));
		Rp.enterLastName(dataMap.get("Lastname"));
		Rp.enterEmailAddress(commonUtils.getGmailWithTimestamp());
		Rp.enterTelephoneNumber(dataMap.get("telephone"));
		Rp.enterPassword(dataMap.get("password"));
		Rp.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	@When("User enters the details into below fields with SameEmail")
	public void user_enters_the_details_into_below_fields_with_SameEmail(DataTable dataTable) 
	{
	   
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		Rp.enterFirstName(dataMap.get("firstname"));
		Rp.enterLastName(dataMap.get("Lastname"));
		Rp.enterEmailAddress(dataMap.get("email"));
		Rp.enterTelephoneNumber(dataMap.get("telephone"));
		Rp.enterPassword(dataMap.get("password"));
		Rp.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	

	@When("User select privacy policy")
	public void user_select_privacy_policy() 
	{
		Rp.selectPrivacyPolicy();
		
	    
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() 
	{
	    As= Rp.clickOnContinueButton();
		
	}

	@Then("User Account should get created successfully")
	public void user_account_should_get_created_successfully() 
	{
		
		Assert.assertEquals(As.retrieveAccountSuccessPageHeading(), "Your Account Has Been Created!");
	   
	}

	@When("User select Yes for Newsletter")
	public void user_select_yes_for_newsletter() 
	{
		Rp.selectYesNewsletterOption();
	    
	}

	@Then("User should get proper Warning message About Duplicate email")
	public void user_should_get_proper_warning_message_about_duplicate_email() 
	{
		
		Assert.assertTrue(Rp.retrieveDuplicateEmailAddressWarning().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	@When("User  dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() 
	{
		
	   //intentionally kept blank
	}

	@Then("User should get proper Warning message for Every Mandetory Fields")
	public void user_should_get_proper_warning_message_for_every_mandetory_fields() 
	{
		
		Assert.assertTrue(Rp.retrievePrivacyPolicyWarning().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(Rp.retrieveFirstNameWarning().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(Rp.retrieveLastNameWarning().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(Rp.retrieveEmailWarning().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(Rp.retrieveTelephoneWarning().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(Rp.retrievePasswordWarning().contains("Password must be between 4 and 20 characters!"));
		
	}


}

