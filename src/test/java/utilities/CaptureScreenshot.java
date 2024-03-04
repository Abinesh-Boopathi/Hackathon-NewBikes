package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testBase.BaseClass;



public class CaptureScreenshot extends BaseClass {
	
	public void captureScreen() throws IOException {
		
		TakesScreenshot snap=(TakesScreenshot) driver;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = dateFormat.format(new Date());

		// Create a unique filename using the timestamp
		String target = System.getProperty("user.dir") + "/Reports/Screenshots/";
		String filename = target + "screenshot_" + timestamp + ".png";
		File src=snap.getScreenshotAs(OutputType.FILE);
		File trg=new File(filename);
		
		FileUtils.copyFile(src, trg);

	}

}
