package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WriteData;

public class HeaderPage  extends BasePage {
	
	public HeaderPage (WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(xpath = "//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
		WebElement btnUsername;
		
		@FindBy(xpath = "//*[@id=\"mectrl_currentAccount_secondary\"]")
		WebElement txtUsername;
		
		//*[@id="spTopPlaceholder"]/div/div[2]//div[2]/button
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]//div[2]/button")
		WebElement btnCompany;
		
		@FindBy(xpath = "//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[2]/button//i")
		WebElement dropCompany;
		
		@FindBy(xpath = "//*[@id=\"id__7-menu\"]/div/ul/li/div/a/div/span")
		List<WebElement> listCompany;
		
		@FindBy(xpath = "//*[@id=\"id__7-menu\"]/div/ul/li//i")
		List<WebElement> listCompany2;
		
		@FindBy(xpath ="//*[@id=\"spTopPlaceholder\"]/div/div[2]//div[1]/a")
		WebElement beCognizant;
		//methods
		public void clickBtn() {
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnUsername);
		}
		
		
		public Boolean verifyUser() throws InterruptedException {
			WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mectrl_currentAccount_secondary']")));
			String text=txtUsername.getText();
			if(text.contains("@cognizant.com")) 
				return true;
			return false;
		}
		
		
		public Boolean verifyPage() {
			if(beCognizant.getText().equals("be.cognizant")) {
				return true;
			}
			return false;
		}
		
		
		public void clickCompany() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btnCompany);
		}
		
		
		public Boolean checkIcon() {
		    try {
		        return dropCompany.isDisplayed();
		    } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
		        // Handle the exception, log it, or perform any necessary actions
		        return false;
		    }
		}
		
		public  void printList() throws IOException {
			List<String> ls=new ArrayList<>();
			
			for(WebElement ele:listCompany) {
				ls.add(ele.getText());
			
			}
			WriteData data =new WriteData();
			data.writeData(ls);
		}
		
		public void checkIconPresent(List<WebElement> ele) {
		    for (WebElement element : ele) {
		        try {
		            if (element.isDisplayed()) {
		               Actions act=new Actions(driver); // Return true as soon as one element is displayed
		            act.moveToElement(element).perform();
		            
		            
		            }
		        } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
		            // Handle the exception, log it, or perform any necessary actions
		        }
		    }
		     // Return false if no elements are displayed
		}

		public void hover() {
			checkIconPresent(listCompany2);
		}
		

}
