package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleLogin extends BasePage {
		
	//Constructor
	public GoogleLogin(WebDriver driver) {
		super(driver);
	}
	
	//WebElements
	@FindBy(id="identifierId")
	WebElement email;
	
	@FindBy(xpath="//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")
	WebElement nextButton;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement errorMsg;
	
	//Action Methods
	public void wrongMail() {
		email.sendKeys("abc@gmail.com");
	}
	public void clickNext() {
		nextButton.click();
	}
	public String errMsg(){
		return errorMsg.getText();
	}

}
