package stepDefinitions;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;
public class HeaderCompany {//header.feature implementation (Company header)
	
	WebDriver driver;
    HeaderPage hp=new HeaderPage(BaseClass.getDriver());
	

	@When("the user checks header option company has icon")
	public void the_user_checks_header_option_company_has_icon() throws InterruptedException {
		 BaseClass.getLogger().info("clicked on company header.. ");
	    	
	    	
	    	if(hp.checkIcon1()) {
	    	hp.clickCompany();
	    	}
	    	else {
	    		Assert.assertTrue(false);
	    	}
	}

	@When("user clicks on company and print the list showing")
	public void user_clicks_on_company_and_print_the_list_showing() throws IOException {
		 BaseClass.getLogger().info("opened be cognizant page.. ");
	    	
	    	hp.printCompanyList();  //this will be uncomment when you run for final 
	    	
	}

	@Then("user can hover if any list item has Triangle icon")
	public void user_can_hover_if_any_list_item_has_triangle_icon() {
		 BaseClass.getLogger().info("opened be cognizant page.. ");
	    	
	    	hp.hover();
	}
}
