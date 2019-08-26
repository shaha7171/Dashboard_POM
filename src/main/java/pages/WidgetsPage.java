package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class WidgetsPage extends BaseTest {

	@FindBy(css="body > div > div > h2")
	WebElement widTxt;
	
	//Initializing the page objects
	public WidgetsPage(){
	PageFactory.initElements(driver, this);
	}
	
	public String validateWidgetPageTitle(){	
		return driver.getTitle();	 
	}
	
	public String validateWidgetPage(){
		return widTxt.getText();
	}
	
	
	
	


}
