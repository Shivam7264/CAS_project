package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;

public class ServiceLines {
	WebDriver driver;
    HeaderPage hp=new HeaderPage(BaseClass.getDriver());
	@Given("the user checks header option Service Lines has icon")
	public void the_user_checks_header_option_service_lines_has_icon() {
		 BaseClass.getLogger().info("opened cognizant page checking icon.. ");
	    	
	    	if(hp.checkIcon2()) {
	    		Assert.assertTrue(true);
		    	
		    	}
		    	else {
		    		Assert.assertTrue(false);
		    	}
	}

	@When("user clicks on Service Lines and print the list showing")
	public void user_clicks_on_service_lines_and_print_the_list_showing() throws IOException {
		BaseClass.getLogger().info("printing 1st list in service lines.. ");
    	
    	hp.clickService();
    	hp.printServiceList();
	}

	@Then("if user finds icon on any list item it hovers on it and prints it")
	public void if_user_finds_icon_on_any_list_item_it_hovers_on_it_and_prints_it() throws IOException, InterruptedException {
		BaseClass.getLogger().info("printing 2nd list of icon elements. ");
    	
    	hp.hoverOnServiceListItems();
	}

}
