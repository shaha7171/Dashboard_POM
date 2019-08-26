package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class ConnectionsPage extends BaseTest {
	@FindBy(css="body > div > div > h2")
	WebElement connTxt;
	
	
	//Initializing the page objects
	public ConnectionsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateConnPageTitle(){	
		return driver.getTitle();	 
	}
	
	public String validateConnPage(){
		return connTxt.getText();
	}
	
	public void validateTableCols(){
		//*[@id="calculatedColumnTable"]/table/thead/tr/th[1]
		//*[@id="calculatedColumnTable"]/table/thead/tr/th[2]
		String locatorKey = "";
		String beforeXpath = "//*[@id='calculatedColumnTable']/table/thead/tr/th[";
		String afterXpath = "]";
		List<WebElement>  cols =driver.findElements(By.xpath(OR.getProperty(locatorKey)));
	
		
	}
	

}
