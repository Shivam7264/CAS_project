package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EthicsPage;
import pageObjects.HeaderPage;

public class Corporate {//corporate.feature implementation

WebDriver driver;
HeaderPage hp=new HeaderPage(BaseClass.getDriver());
EthicsPage ep=new EthicsPage(BaseClass.getDriver());


@Given("The user checks header option Corporate Functions has icon")
public void the_user_checks_header_option_corporate_functions_has_icon() {
   Assert.assertTrue(hp.checkIcon4());
}

@When("User clicks on Corporate Functions and print the list showing")
public void user_clicks_on_corporate_functions_and_print_the_list_showing() throws IOException {
   hp.clickCorporate();
   hp.printCorporateList();
}

@Then("If user finds icon on any list item it hovers on it and prints it recursiverly")
public void if_user_finds_icon_on_any_list_item_it_hovers_on_it_and_prints_it_recursiverly() throws IOException, InterruptedException {
   hp.hoverOnCorporateListItems();
}
	//now implementing the 2nd scenario of corporate.feature>>>>>>>>>>>>>>
@Given("The user clicks on corporate functions header")
public void the_user_clicks_on_corporate_functions_header() {
	 hp.clickCorporate();
}

@When("user finds Legal and corporate affairs and hover over it and clicks on Ethics & Compliance")
public void user_finds_legal_and_corporate_affairs_and_hover_over_it_and_clicks_on_ethics_compliance() throws InterruptedException {
    ep.hoverLegalAndCorporateAffairs();
   
}

@When("verify the page legal and corporate affairs")
public void verify_the_page_legal_and_corporate_affairs() {
	
   Assert.assertTrue(ep.verifyPageEthics());
}

@Then("prints the list of Resources  available")
public void prints_the_list_of_resources_available() throws InterruptedException {
	
   ep.printResources();
}
	
	
	
}
