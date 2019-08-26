package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class ModulesPage extends BaseTest{
	
	@FindBy(css="body > div > div > h2")
	WebElement moduleTxt;
	
	
	//Initializing the page objects
	public ModulesPage(){
	PageFactory.initElements(driver, this);
	}
	

	public String validateModulePageTitle(){	
		return driver.getTitle();	 
	}
	
	public String validateModulePage(){
		return moduleTxt.getText();
	}
	
	
	

	
	
	

}
