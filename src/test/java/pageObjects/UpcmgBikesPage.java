package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpcmgBikesPage extends BasePage{
	
	
	//Constructor
	public UpcmgBikesPage(WebDriver driver) {
		
		super(driver);
	}
	
	//WebElements
	@FindBy(xpath="//select[@id='makeId']")
	WebElement manufacture;
	
	@FindBy(xpath="//a[@data-track-label='model-name']")
	List<WebElement> bikesName;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> bikesPrice;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> bikesDate;
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement loadMore;
	
	@FindBy(xpath="//a[@href='/used-car']")
	WebElement usedCars;
	
	@FindBy(xpath="//li/span[normalize-space()='Chennai']")
	WebElement location;
	
	
	
	//Action Methods
	public void selectHonda() {
		Select manufacturer=new Select(manufacture);
		manufacturer.selectByVisibleText("Honda");
		System.out.println("Selected Honda");
	}
	
	public List<WebElement> bikesNamelist(){
		return bikesName;
	}
	public List<WebElement> bikesPriceList(){
		return bikesPrice;
	}
	public List<WebElement> bikesDateList(){
		return bikesDate;
	}
	public void clickLoadMore() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", " ");
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", loadMore);
	}
	public void scrollUp() throws InterruptedException {
		JavascriptExecutor js2=(JavascriptExecutor) driver;
		js2.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		
		Thread.sleep(5000);
	}
	public void hoverUsedCars() {
		Actions act=new Actions(driver);
		act.moveToElement(usedCars).perform();
	}
	public void clickChennai() {
		location.click();
	}
	

}
