package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WriteData;

public class BaseClass {

		 static WebDriver driver;
	     static Properties p;
	     static Logger logger;
	  	     
	

	public static WebDriver initilizeBrowser() throws IOException
	{
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		 
		 return driver;
		 
	}
	
	public static WebDriver getDriver() {
			return driver;
		}
	public static void login1() throws InterruptedException, IOException {
		 WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(30))
		            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0118")));
		   p=BaseClass.getProperties();
		  String pwd= p.getProperty("password");
		    passwordInput.sendKeys(pwd);

		    Thread.sleep(5000);
		    WebElement bt2=driver.findElement(By.id("idSIButton9"));
	    	JavascriptExecutor js1=(JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", bt2);
		    

		    Thread.sleep(5000);

		    // Check if the "Back" button is present before clicking
		    WebElement backButton = null;
		    try {
		        backButton = new WebDriverWait(driver, Duration.ofSeconds(10))
		                .until(ExpectedConditions.presenceOfElementLocated(By.id("idBtn_Back")));
		    } catch (Exception e) {
		        System.out.println("Back button not found. Skipping the click.");
		    }

		    if (backButton != null) {
		        backButton.click();
		    }
		    Thread.sleep(10000);
	}
	public static void login() throws InterruptedException, IOException {
	    WebElement usernameInput = new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0116")));
	    p=BaseClass.getProperties();
		  String mail= p.getProperty("email");
		usernameInput.sendKeys(mail);
	    WebElement bt1=driver.findElement(By.id("idSIButton9"));
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", bt1);
	    

	    WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0118")));
	   p=BaseClass.getProperties();
	  String pwd= p.getProperty("password");
	    passwordInput.sendKeys(pwd);

	    Thread.sleep(5000);
	    WebElement bt2=driver.findElement(By.id("idSIButton9"));
    	JavascriptExecutor js1=(JavascriptExecutor)driver;
    	js1.executeScript("arguments[0].click();", bt2);
	    

	    Thread.sleep(5000);

	    // Check if the "Back" button is present before clicking
	    WebElement backButton = null;
	    try {
	        backButton = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.presenceOfElementLocated(By.id("idBtn_Back")));
	    } catch (Exception e) {
	        System.out.println("Back button not found. Skipping the click.");
	    }

	    if (backButton != null) {
	        backButton.click();
	    }
	}

	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       		
        p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	
	public Boolean checkIcon(WebElement ele) {
	    try {
	        return ele.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
	        // Handle the exception, log it, or perform any necessary actions
	        return false;
	    }
	}
	
	public  void printList(List<WebElement> list) throws IOException {
		List<String> ls=new ArrayList<>();
		int i=0;
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			ls.add(ele.getText());
		i++;
		}
//		WriteData data =new WriteData();
//		data.writeData(ls);
		//uncomment to store in excel sheet>>>>>>>>>>>>>>>>>>>>>
	}
	
}
