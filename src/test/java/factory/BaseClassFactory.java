package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClassFactory {

	 static WebDriver driver;
     static Properties p;
    
    public static WebDriver browserLaunch() throws IOException {
    	if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
    		DesiredCapabilities capabilities=new DesiredCapabilities();
    		
    		
    		//os setup
    		if(getProperties().getProperty("os").equalsIgnoreCase("windows")) {
    			capabilities.setPlatform(Platform.WIN11);
    		}
    		else if(getProperties().getProperty("os").equalsIgnoreCase("mac")) {
    			capabilities.setPlatform(Platform.MAC);
    		}
    		else {
    			System.out.println("No Matching OS...");
    		}
    		
    		//Browser setup
    		switch(getProperties().getProperty("browser").toLowerCase()) {
    		
    		case "chrome":
    			capabilities.setBrowserName("chrome");
    			break;
    		case "edge":
    			capabilities.setBrowserName("MicrosoftEdge");
    			break;
    		default:
    			System.out.println("No Matching Browser");
    		}
    		driver= new RemoteWebDriver(new URL(" http://10.66.136.55:4444/wd/hub"),capabilities);
    		
    	}
    	else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
    		
    		switch(getProperties().getProperty("browser").toLowerCase()) 
    		{
    		case "chrome":
    			ChromeOptions opt=new ChromeOptions();
    			opt.addArguments("--disable-notifications");
    	        driver=new ChromeDriver(opt);
    	        break;
    	    case "edge":
    	    	EdgeOptions opt1=new EdgeOptions();
    	    	opt1.addArguments("--disable-notifications");
    	    	driver=new EdgeDriver(opt1);
    	        break;
    	    default:
    	        System.out.println("No matching browser");
    	        driver=null;
    		}
    	}
    	 driver.manage().deleteAllCookies(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.manage().window().maximize();
		 
		 return driver;
    }
    
    public static WebDriver getDriver() {
		return driver;
	}
    
    public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
       		
        p=new Properties();
		p.load(file);
		return p;
	}
	
	

}
