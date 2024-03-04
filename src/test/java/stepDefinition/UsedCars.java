package stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import factory.BaseClassFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.UpcmgBikesPage;
import pageObjects.UsedCarsPage;
import utilities.ExcelUtils;

public class UsedCars extends BaseClassFactory {
	
	UpcmgBikesPage upcmg=new UpcmgBikesPage(BaseClassFactory.getDriver());
	
	@Given("navigate to used cars in chennai")
	public void navigate_to_used_cars_in_chennai() {
	    // Write code here that turns the phrase above into concrete actions
		
		upcmg.hoverUsedCars();
		upcmg.clickChennai();
	
		System.out.println("Chennai Clicked -- Used Cars in Chennai");
		System.out.println("==============================================");
		
	}

	@Then("get the popular model cars")
	public void get_the_popular_model_cars() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		UsedCarsPage ucp=new UsedCarsPage(BaseClassFactory.getDriver());
		ExcelUtils excel=new ExcelUtils();
		
		List<WebElement> popularCarModels=ucp.popularModelsList();
		for(int i=0;i<popularCarModels.size();i++) {
			String carname=popularCarModels.get(i).getText();
			excel.writeData("Popular Model Cars", i, 0, carname);
			System.out.println(carname);
		}
		
		System.out.println("==============================================");
		
	}

}
