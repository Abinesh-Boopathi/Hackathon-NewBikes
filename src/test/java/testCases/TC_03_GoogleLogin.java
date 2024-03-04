package testCases;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import pageObjects.GoogleLogin;
import pageObjects.ZigWheelsHomePage;
import testBase.BaseClass;
import utilities.CaptureScreenshot;

public class TC_03_GoogleLogin extends BaseClass {
	
	CaptureScreenshot snip=new CaptureScreenshot();
	
	@Test(priority=5,groups= {"smoke","regerssion","master"})
	public void googleclick() throws InterruptedException, IOException {
		
		ZigWheelsHomePage zigwheels=new ZigWheelsHomePage(driver);
		
		zigwheels.clickLogin();
		logger.info("Login Clicked");
		zigwheels.clickGoogle();
		logger.info("Google Clicked");
		Thread.sleep(5000);
		
		Set<String> windowIds=driver.getWindowHandles();
		String[] window=windowIds.toArray(new String[windowIds.size()]);
		driver.switchTo().window(window[1]);
		
		snip.captureScreen();
		
		System.out.println("----Control Switched-----");
	}
	
	@Test(priority=6,groups= {"regerssion","master"})
	public void wrongLogin() throws InterruptedException, IOException {
		
		GoogleLogin gl=new GoogleLogin(driver);
		
		gl.wrongMail();
		logger.info("Wrong mail given");
		gl.clickNext();
		logger.info("Next Clicked");
		System.out.println();
		Thread.sleep(10000);
		String error=gl.errMsg();
		
		snip.captureScreen();
		logger.info("Error Message captured"+error);
		System.out.println(error);
		
		
		System.out.println("---Process Finished---");
	}

}
