package StepDefinitions;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import ProperitiesConstants.ConstantClass;
import Util.Properties.loadingProperites;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class CommonStepDefiniton {
	
	public static RemoteWebDriver driver;
	
	public static org.apache.logging.log4j.Logger LG;
	
	@Before
	
	public void beforeScenario() {
		try {
			
		    LG = LogManager.getLogger(CommonStepDefiniton.class);
			
			
			loadingProperites.getInstance().loadingProperties();
			
			LG.info("Properties Loaded");
			
			if(driver==null) {
		    LG.info("Checking the browser is Null or not");
		    
				launchingBrowser();
				driver.manage().window().maximize();
				loadingProperites.getInstance().initializingDriver();
				
			LG.info("Launching the browser");
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
    

	}
	
	public static void launchingBrowser() {
		
		
		switch (ConstantClass.BrowserName) {
		
		case "chrome":
			
			driver = new ChromeDriver();
			
			break;

		default:
			break;
		}
		
	 

	}
	
	@AfterStep

	public void takingScreen( Scenario sc) {
		
		try {
			
			final byte[] screen = driver.getScreenshotAs(OutputType.BYTES);
			
			sc.attach(screen, "image/png", "image");
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		

	}
    
	
	

}
