package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import factory.BaseClassFactory;

public class ZigWheelsHomePage extends BasePage{
	
//	WebDriver driver;
	
	//Constructor
	public ZigWheelsHomePage(WebDriver driver) {
		
		super(driver);
		
	}
	
	//WebElements
	@FindBy(xpath="//a[@href='/newbikes']")
	WebElement newBikes;
	
	@FindBy(xpath="//span[normalize-space()='Upcoming Bikes']")
	WebElement upcmglink;
	
	@FindBy(id="des_lIcon")
	WebElement login;
	
	@FindBy(xpath="//div[@class='newgf-login']//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement google;
	
	//Action Methods
	
	public void hoverNewBikes() {
		Actions act=new Actions(driver);
		act.moveToElement(newBikes).perform();
	}
	public void clickUpcmgBikes() {
		upcmglink.click();
	}
	public void clickLogin() {
		login.click();
	}
	public void clickGoogle() {
		google.click();
	}
}
