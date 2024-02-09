package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HeaderPage;

public class people {
	WebDriver driver;
    HeaderPage hp=new HeaderPage(BaseClass.getDriver());

@Given("the user checks header option  has icon")
public void the_user_checks_header_option_has_icon() {
   Assert.assertTrue(hp.checkIcon5());
}

@When("user clicks on People and print the list showing")
public void user_clicks_on_people_and_print_the_list_showing() throws IOException {
   hp.clickPeople();
   hp.printPeopleList();
}

@Then("If user finds icon on any list item it hovers on it and prints it")
public void if_user_finds_icon_on_any_list_item_it_hovers_on_it_and_prints_it() throws IOException {
    hp.hoverOnPeopleList();
    
}


}
