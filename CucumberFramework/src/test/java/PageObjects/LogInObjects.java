package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInObjects {
	
	public static LogInObjects logi;
	
	
	
	
	
	private LogInObjects() {}
	
	public static LogInObjects getInstance() {
		if (logi==null) {
			
			logi = new LogInObjects();
		}
		
		return logi;
	}
		
	

	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement button;





	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getButton() {
		return button;
	}

	

}
