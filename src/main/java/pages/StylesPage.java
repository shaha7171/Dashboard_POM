package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.BaseTest;

public class StylesPage extends BaseTest {
	
	@FindBy(css="body > div > div > h2")
	WebElement StylesTxt;
	 
	
	public StylesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateStylesPage(){
		return StylesTxt.getText();
	}
	
	public String validateStylesPageTitle(){	
		return driver.getTitle();	 
	}
	
	
}
