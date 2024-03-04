package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import factory.BaseClassFactory;

public class BaseClass {
	
	public static WebDriver driver;
	static Properties p;
	public Logger logger;
	
	@Parameters({"browser"})
	@BeforeTest(groups={"smoke","regression","master"})
	public void driverSetup(String browser) throws InterruptedException, IOException {
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(browser) {
		case "chrome":
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver=new ChromeDriver(opt);
			System.out.println("Chrome Launched");
			break;
			
		case "edge":
			EdgeOptions opt1=new EdgeOptions();
			opt1.addArguments("--disable-notifications");
			driver=new EdgeDriver(opt1);
			System.out.println("Edge Launched");
			break;
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		logger.info("--Driver Launched--");
		p=BaseClassFactory.getProperties();
		driver.get(p.getProperty("appURL"));
		Thread.sleep(10000);
		logger.info("--ZigWheels Opened--");
		String act_title=driver.getTitle();
		if(act_title.equalsIgnoreCase("New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com"))
			System.out.println("Correct Website ZigWheels Launched");
		else
			System.out.println("Wrong Website Launched");
	}
	
	//capture screenshots on failure
	public String captureScreenonFailure(String testname) {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot scrnshot=(TakesScreenshot) driver;
		File srcFile=scrnshot.getScreenshotAs(OutputType.FILE);
		
		String trg=System.getProperty("user.dir")+"\\Reports\\Screenshots\\screenshotfails\\"+testname+"_"+timeStamp+".png";
		
		File trgFile=new File(trg);
		srcFile.renameTo(trgFile);
		return trg;
		
	}
	
	
	
	@AfterTest(groups={"smoke","regression","master"})
	public void teardown() {
		driver.quit();
		logger.info("--Browser Launched--");
	}

}
