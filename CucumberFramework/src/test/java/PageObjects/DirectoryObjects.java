package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryObjects {
	
	public static DirectoryObjects obje;
	
	
	
	private DirectoryObjects() {}
	
	public static DirectoryObjects getInstance() {
		
		if(obje == null) {
			
			obje = new DirectoryObjects();
		}
		
		return obje;
		
		
	}
		
	
		


	@FindBy(xpath = "//span[text()='Directory']")
	
	private WebElement directory;
	
	@FindBy(xpath = "(//form[@class='oxd-form']//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	
	private WebElement dropdown;
	
	@FindBy(xpath = "//button[@type='submit']")
    
	private WebElement search;
	
	@FindBy(xpath = "(//p[.='John  Smith '])[1]")
	
	private WebElement namechecking;

	public  WebElement getDirectory() {
		return directory;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getNamechecking() {
		return namechecking;
	}
}
