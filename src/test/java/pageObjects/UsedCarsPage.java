package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCarsPage extends BasePage {
		
	//Constructor
	public UsedCarsPage(WebDriver driver) {
			
			super(driver);
	}
		
	//WebElements
	@FindBy(xpath="//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']//label")
	List<WebElement> popularModels;
	
	@FindBy(xpath="//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	WebElement logo;
	
	//Action Methods
	public List<WebElement> popularModelsList(){
		return popularModels;
	}
	public void clickLogo() {
		logo.click();
	}

}
