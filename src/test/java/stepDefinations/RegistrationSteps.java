package stepDefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountRegistration regpage;
	
	
	@Given("the User navigates to Register Account Page")
	public void the_user_navigates_to_register_account_page() {
	    
		hp=new HomePage(BaseClass.getDriver());
		hp.ClickMyaccount();
		hp.ClickRegister();
		
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {
	     
		 Map<String,String>datamap=dataTable.asMap(String.class,String.class);
		 
		 regpage=new AccountRegistration(BaseClass.getDriver());
		
		 regpage.SetFirstname(datamap.get("firstName"));
		 regpage.SetLastname(datamap.get("lastName"));
		 regpage.Setemail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		 regpage.SetTelePhone(BaseClass.randomNumber());
		 regpage.Setpassword(datamap.get("password"));
		 regpage.SetCnfPassword(datamap.get("cnfPassword"));
		
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() {
	    
		regpage.Setprivacypolicy();
		
	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
	     
		regpage.Clickcontinue();
		
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
	     
		String text=regpage.getConfirmationmsg();
		Assert.assertEquals(text, "Your Account Has Been Created!");
		
	}


}
