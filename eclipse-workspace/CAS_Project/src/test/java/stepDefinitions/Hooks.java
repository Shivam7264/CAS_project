package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	 WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException, InterruptedException
    {
    	driver=BaseClass.initilizeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	driver.get(p.getProperty("appURL"));
    	
    	
    	// BaseClass.login1();//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>uncomment  when login required
    	driver.manage().window().maximize();
    	Thread.sleep(5000);
       
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
      
    }
   
}
