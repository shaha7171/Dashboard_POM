package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.BaseTest;

public class ThemesPage extends BaseTest {
	
	@FindBy(css="body > div > div > h2")
	WebElement ThemesTxt;
	 
	
	public ThemesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateThemesPage(){
		return ThemesTxt.getText();
	}
	
	public String validateThemesPageTitle(){	
		return driver.getTitle();	 
	}
}
