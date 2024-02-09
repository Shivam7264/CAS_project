package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;



import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;

public class Sales {
	WebDriver driver;
	HeaderPage hp=new HeaderPage(BaseClass.getDriver());
	
	
	@Given("the user checks header option sales has icon")
	public void the_user_checks_header_option_sales_has_icon() {
		BaseClass.getLogger().info("checks  sales header has icon.. ");
			Assert.assertTrue(hp.checkIcon3());
		}

	@When("user clicks on sales and print the list showing")
	public void user_clicks_on_sales_and_print_the_list_showing() throws IOException {
		BaseClass.getLogger().info("clicked on sales header and prints.. ");
	hp.clickSales();
	hp.printSalesList();
	
	}

	@Then("user can hover if any list item has icon")
	public void user_can_hover_if_any_list_item_has_icon() {
		BaseClass.getLogger().info("checks if icon present then hover.. ");
	    hp.hoverSalesList();
	}
	
}
