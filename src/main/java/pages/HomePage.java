package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest {
	
	@FindBy(css="body > div > div > div:nth-child(1) > div > h4")
	WebElement welcome;
	
	
	
	
	
	//Initializing the page objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Methods
	public String validateHomePageTitle(){	
		return driver.getTitle();	 
	}
	
	public ConnectionsPage ClickOnConnections(){
		click("connBtn_CSS");
		return new ConnectionsPage();
	}
	
	public ModulesPage ClickOnModules(){
		click("moduleBtn_CSS");
		return new ModulesPage();
	}
	
	public WidgetsPage ClickOnWidgets(){
		click("widgetsBtn_CSS");
		return new WidgetsPage();
		
	}
	

	public boolean ClickOnCheckox() {
		click("checkBox_CSS");
		click("connBtn_CSS");
		driver.navigate().back();
		return welcome.isDisplayed();
	}
	
	public String clickOnCGI(){
		click("CGI_CSS");
		return driver.getTitle();
		
		
	}
	
	public ucDashboardPage ClickOnUCDashBoard() {
		click("ucDashboard_CSS");
		return new ucDashboardPage();
	}




}
