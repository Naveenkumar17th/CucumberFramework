package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageObjects.DirectoryObjects;
import PageObjects.LogInObjects;
import ProperitiesConstants.ConstantClass;
import Util.Properties.loadingProperites;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verify_CEO_NameClass {
	
	public static Logger LG = LogManager.getLogger(Verify_CEO_NameClass.class);
	
	public static Actions ac;
	
	
	
	
	
	@Given("the user is logged in successfully and is on Home Page")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
		
		CommonStepDefiniton.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		CommonStepDefiniton.driver.get(ConstantClass.Url);
		loadingProperites.getInstance().getInstance().highLightelement(LogInObjects.getInstance().getUsername());
		LogInObjects.getInstance().getUsername().sendKeys(ConstantClass.Username);
		LogInObjects.getInstance().getPassword().sendKeys(ConstantClass.Password);
		LogInObjects.getInstance().getButton().click();
	   
	}

	@When("the user clicks on the directory option from the menu bar")
	public void the_user_clicks_on_the_directory_option_from_the_menu_bar() {
		DirectoryObjects.getInstance().getDirectory().click();
		
		
	   
	}

	@When("the user selects the job title as {string} from the drop down")
	public void the_user_selects_the_job_title_as_from_the_drop_down(String string) throws Exception {
		
      DirectoryObjects.getInstance().getDropdown().click();
		
		 ac = new Actions(CommonStepDefiniton.driver);
		
		ac.sendKeys(string).perform();
		
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		LG.info("Dropdown selection is done");
		
	    
	}

	@When("clicks the search button")
	public void clicks_the_search_button() {
		
		try {
			
			DirectoryObjects.getInstance().getSearch().click();
			
		} catch (Exception e) {
			LG.error(e);
			
			loadingProperites.getInstance().takingScreenshot();
		}
		
		
	    
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String string) {
		
		
		
		try {
			
			WebElement fi = CommonStepDefiniton.driver.findElement(By.xpath("(//p[text()='John  Smith '])[1]"));
			
			if(fi.getText().equalsIgnoreCase(string)) {
				LG.info("it's Matched");
				
			}else {
				
				LG.info("it's not Matched");
			}
			
		} catch (Exception e) {
			LG.info(e.getMessage());
		}
		
		
		
	
		
		
	   
	}


}
