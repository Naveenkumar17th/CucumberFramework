package Util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import PageObjects.DirectoryObjects;
import PageObjects.LogInObjects;
import ProperitiesConstants.ConstantClass;
import StepDefinitions.CommonStepDefiniton;

public class loadingProperites {
	
	
	public static loadingProperites loading;
	
	
	
	private loadingProperites() {}
	
	public static loadingProperites getInstance() {
		if(loading == null) {
			
			loading = new loadingProperites();
		}
		
		return loading;

	}





	public void loadingProperties() throws IOException {
		
		FileInputStream Fs = new FileInputStream("C:\\Users\\navve\\eclipse-workspace\\CucumberMiniProject\\Property.properties");
		
		Properties p = new Properties();
		
		p.load(Fs);
		
		CommonStepDefiniton.LG.info("VALUES ARE LOADED");
		
		ConstantClass.BrowserName = p.getProperty("BrowserName");
		ConstantClass.Url = p.getProperty("Url");
		ConstantClass.Username = p.getProperty("Username");
		ConstantClass.Password = p.getProperty("Password");

	}
	
	
	


	public void initializingDriver() {
		
		PageFactory.initElements(CommonStepDefiniton.driver, LogInObjects.getInstance());
		PageFactory.initElements(CommonStepDefiniton.driver, DirectoryObjects.getInstance());
		
	}
	
	public void takingScreenshot() {
		
		File ss = CommonStepDefiniton.driver.getScreenshotAs(OutputType.FILE);
		
		try {
			
			File fs = new File("C:\\Users\\navve\\eclipse-workspace\\CucumberMiniProject\\exce.png");
			
			FileHandler.copy(ss, fs);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
	public void highLightelement(WebElement ele) {
		
		JavascriptExecutor JS = (JavascriptExecutor) CommonStepDefiniton.driver;
		
		JS.executeScript("arguments[0].setAttribute('style','border: 2px solid red');", ele);

	}


	

}
