package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class ucDashboardPage extends BaseTest	 {

	@FindBy(css="#navbarDropdownDashboard")
	WebElement UCDashboardTxt;
	 
	
	public ucDashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateUCDashboard(){
		return UCDashboardTxt.getText();
	}

}
