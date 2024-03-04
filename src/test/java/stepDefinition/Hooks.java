package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClassFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	 public static WebDriver driver;
	 static Properties p;
	 
	 
	 @BeforeAll
	 public static void setup() throws IOException
	    {
	    	driver=BaseClassFactory.browserLaunch();
	    	    	
	    	p=BaseClassFactory.getProperties();
	    	driver.get(p.getProperty("appURL"));
	    
	    			
		}
	 
	 
	 @AfterAll
	 public static void tearDown() {
 		
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
