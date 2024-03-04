package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.UpcmgBikesPage;
import pageObjects.ZigWheelsHomePage;
import testBase.BaseClass;
import utilities.ExcelUtils;
import utilities.CaptureScreenshot;

public class TC_01_NewBikes extends BaseClass{
	
	CaptureScreenshot snip=new CaptureScreenshot();
	
	@Test(priority=1, groups= {"smoke", "regression","master"})
	public void upcomingNewBikes() throws IOException{
		
		ZigWheelsHomePage zigwheels=new ZigWheelsHomePage(driver);
		
		zigwheels.hoverNewBikes();
		zigwheels.clickUpcmgBikes();
		logger.info("Navigated to Upcoming bikes");
		System.out.println("Navigated to Upcoming bikes");
		snip.captureScreen();
		
	}
	
	@Test(priority=2, groups= {"smoke","regeression","master"})
	public void newHondaBikes() throws InterruptedException, IOException {
		
		UpcmgBikesPage upcmg=new UpcmgBikesPage(driver);
		
		upcmg.selectHonda();
		logger.info("Honda manufacturer selected");
		upcmg.clickLoadMore();
		logger.info("Clicked on LoadMore");
		List<WebElement> bikeNames=upcmg.bikesNamelist();
		List<WebElement> bikePrices=upcmg.bikesPriceList();
		List<WebElement> bikeLaunch=upcmg.bikesDateList();
		System.out.println("======================================================================");
		System.out.println("New Honda Bikes Under 4.0 lakh");
		logger.info("Bikes under 4L are printed on console and excel");
		System.out.println();
		
		ExcelUtils excel=new ExcelUtils();
		excel.createSheets();
		int j=1;
		for(int i=0;i<bikeNames.size();i++) {
			String bkname=bikeNames.get(i).getText();
			String bkprice=bikePrices.get(i).getText();
			String bklaunch=bikeLaunch.get(i).getText();
			
			if(bkprice.contains("Lakh")) {
				String[] price=bkprice.split(" ");
				float value=Float.parseFloat(price[1]);
				if(value<=4.0) {
					System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
					excel.writeData("Honda Bikes <4L", j, 0, bkname);
					excel.writeData("Honda Bikes <4L", j, 1, bkprice);
					excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
					j=j+1;
				}
			}
			else {
				System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
				excel.writeData("Honda Bikes <4L", j, 0, bkname);
				excel.writeData("Honda Bikes <4L", j, 1, bkprice);
				excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
				j=j+1;
			}
			
		}
		snip.captureScreen();
		System.out.println("======================================================================");
		
		upcmg.scrollUp();
	}

}
