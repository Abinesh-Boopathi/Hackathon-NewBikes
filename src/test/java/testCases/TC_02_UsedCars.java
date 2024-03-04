package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.UpcmgBikesPage;
import pageObjects.UsedCarsPage;
import testBase.BaseClass;
import utilities.CaptureScreenshot;
import utilities.ExcelUtils;

public class TC_02_UsedCars extends BaseClass{
	
	CaptureScreenshot snip=new CaptureScreenshot();
	
	@Test(priority=3,groups= {"smoke","regerssion","master"})
	public void selectUsedCars() throws IOException{
		
		UpcmgBikesPage upcmg=new UpcmgBikesPage(driver);
		
		upcmg.hoverUsedCars();
		logger.info("Used cars is Hovered");
		upcmg.clickChennai();
		logger.info("Chennai Clicked...");
	
		snip.captureScreen();
		System.out.println("Chennai Clicked -- Used Cars in Chennai");
		System.out.println("==============================================");
	}
	
	@Test(priority=4, groups= {"regerssion","master"})
	public void popularModelCars() throws IOException {
		
		UsedCarsPage ucp=new UsedCarsPage(driver);
		ExcelUtils excel=new ExcelUtils();
		
		logger.info("Popular Used cars are printed on excel and console");
		List<WebElement> popularCarModels=ucp.popularModelsList();
		for(int i=0;i<popularCarModels.size();i++) {
			String carname=popularCarModels.get(i).getText();
			excel.writeData("Popular Model Cars", i, 0, carname);
			System.out.println(carname);
		}
		snip.captureScreen();
		System.out.println("==============================================");
		
		ucp.clickLogo();
	}
	

}
