package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import factory.BaseClassFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.UpcmgBikesPage;
import pageObjects.ZigWheelsHomePage;
import utilities.ExcelUtils;

public class NewBikes_Honda extends BaseClassFactory{
	
	ZigWheelsHomePage zigwheels;
	UpcmgBikesPage upcmg;
	
	@Given("navigate to the new bikes in zigwheels")
	public void navigate_to_the_new_bikes_in_zigwheels() {
	    
		// Write code here that turns the phrase above into concrete actions
		zigwheels=new ZigWheelsHomePage(BaseClassFactory.getDriver());
		zigwheels.hoverNewBikes();
		
	}

	@When("navigate to upcoming bikes")
	public void navigate_to_upcoming_bikes() {
	    // Write code here that turns the phrase above into concrete actions
		ZigWheelsHomePage zigwheels=new ZigWheelsHomePage(BaseClassFactory.getDriver());
		zigwheels.clickUpcmgBikes();
		System.out.println("Navigated to Upcoming bikes");
		
	}

	@When("select Honda in manufacturers")
	public void select_honda_in_manufacturers() {
	    // Write code here that turns the phrase above into concrete actions
		upcmg=new UpcmgBikesPage(BaseClassFactory.getDriver());
		upcmg.selectHonda();
		upcmg.clickLoadMore();
		
	}

	@Then("get the bikes under 4L")
	public void get_the_bikes_under_4l() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		List<WebElement> bikeNames=upcmg.bikesNamelist();
		List<WebElement> bikePrices=upcmg.bikesPriceList();
		List<WebElement> bikeLaunch=upcmg.bikesDateList();
		System.out.println("======================================================================");
		System.out.println("New Honda Bikes Under 4.0 lakh");
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
		
        System.out.println("======================================================================");
		
		upcmg.scrollUp();
	}

}
