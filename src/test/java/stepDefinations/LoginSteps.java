

package stepDefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import utilities.DataReader;

public class LoginSteps {
	
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountpage  macc;
	
	List<HashMap<String,String>> datamap;
	
	@Given("the User navigates to login Page")
	public void the_user_navigates_to_login_page() {
	     
		
		BaseClass.getLogger().info("Go to My Account--->Click on Login..");
		hp=new HomePage(BaseClass.getDriver());
		hp.ClickMyaccount();
		hp.Clicklogin();
		
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
	     
		BaseClass.getLogger().info("Entering email and Password..");
		
		lp=new LoginPage(BaseClass.getDriver());
		lp.SetEmail(email);
		lp.SetPassword(pwd);
		
	}

	@When("the User clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	     
		lp.Clicklogin();
		BaseClass.getLogger().info(" Clicked on Login button ..");
	}

	@Then("the User should redirected to the MyAccount Page")
	public void the_user_should_redirected_to_the_my_account_page() {
	    
		
		macc=new MyAccountpage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountpageExists();
		
		Assert.assertEquals(targetpage,true);
		
	}


	@Then("the User should redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {
	     
		try
		{
		datamap=DataReader.data(System.getProperty("user.dir")+"\\testdata\\logindata.xlsx", "Sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		int index=Integer.parseInt(rows)-1;
		String email=datamap.get(index).get("username");
		String pwd=datamap.get(index).get("password");
		String exp_res=datamap.get(index).get("res");
		
		lp=new LoginPage(BaseClass.getDriver());
		lp.SetEmail(email);
		lp.SetPassword(pwd);
		
		lp.Clicklogin();
		
		
		macc=new MyAccountpage(BaseClass.getDriver());
		
		try
		{
		boolean targetpage=macc.isMyAccountpageExists();
		
		
		if(exp_res.equals("valid"))
		{
			if(targetpage==true)
			{
				macc.Clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp_res.equals("invalid"))
		{
			if(targetpage==true)
			{
				macc.Clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		 }
		
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		
	}


}
