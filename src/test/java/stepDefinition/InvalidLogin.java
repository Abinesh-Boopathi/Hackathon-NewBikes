package stepDefinition;

import java.util.Set;

import factory.BaseClassFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GoogleLogin;
import pageObjects.UsedCarsPage;
import pageObjects.ZigWheelsHomePage;

public class InvalidLogin extends BaseClassFactory{
	
	GoogleLogin gl=new GoogleLogin(BaseClassFactory.getDriver());
	
	@Given("navigate to home page")
	public void navigate_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		UsedCarsPage ucp=new UsedCarsPage(BaseClassFactory.getDriver());
		
		ucp.clickLogo();
		
	}

	@When("click login")
	public void click_login() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
        ZigWheelsHomePage zigwheels=new ZigWheelsHomePage(BaseClassFactory.getDriver());
		
		zigwheels.clickLogin();
		zigwheels.clickGoogle();
		Thread.sleep(5000);
		
		Set<String> windowIds=BaseClassFactory.getDriver().getWindowHandles();
		String[] window=windowIds.toArray(new String[windowIds.size()]);
		BaseClassFactory.getDriver().switchTo().window(window[1]);
		
		System.out.println("----Control Switched-----");
		
	}

	@Then("enter invalid credentials")
	public void enter_invalid_credentials() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		gl.wrongMail();
		gl.clickNext();
		System.out.println();
		Thread.sleep(10000);
		
	}

	@Then("validate the error message")
	public void validate_the_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		
		String error=gl.errMsg();
        System.out.println(error);
		
		
		System.out.println("---Process Finished---");
	}

}
