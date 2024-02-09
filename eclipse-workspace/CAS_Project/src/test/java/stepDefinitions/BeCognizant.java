package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;

public class BeCognizant {//login.feature implementation

	WebDriver driver;
    HeaderPage hp=new HeaderPage(BaseClass.getDriver());
	

	@Given("the user navigated to the cognizant page")
	public void the_user_navigated_to_the_cognizant_page() throws InterruptedException {
		 BaseClass.getLogger().info("opened be cognizant page.. ");
	    	
	    	
	    		Assert.assertTrue(hp.verifyPage());
	}

	
	@When("the user clicks on user icon")
	public void the_user_clicks_on_user_icon() throws InterruptedException {
		 BaseClass.getLogger().info("clicking the user icon.. ");
	    	
	    	hp.clickBtn();
	}

	@Then("user can validate the mail contains @cognizant.com")
	public void user_can_validate_the_mail_contains_cognizant_com() throws InterruptedException {
		 BaseClass.getLogger().info("verifyimg the user details.. ");
	    	
	   Assert.assertTrue(hp.verifyUser());
	   
	}

	
}
