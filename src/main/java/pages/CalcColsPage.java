package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.BaseTest;

public class CalcColsPage extends BaseTest {
	@FindBy(css = "body > div > div > h2")
	WebElement CalcColTxt;
	
	@FindBy(css = "body > div > div > div.text-right > a")
	WebElement NewCalColBtn;
	
	@FindBy(css = "#calculatedColumnTable > table > tbody > tr > td:nth-child(5) > a")
	WebElement EditBtn;
	
	@FindBy(css = "#calculatedColumnTable > table > tbody > tr > td:nth-child(6) > a")
	WebElement CloneBtn;

	public CalcColsPage() {
		PageFactory.initElements(driver, this);
	}

	public String ValidateCalcColPage() {
		return CalcColTxt.getText();
	}

	public String validateCalcColPageTitle() {
		return driver.getTitle();
	}
	public void validateCalcColTableColumns(){
		String beforeXpath = "//*[@id='calculatedColumnTable']/table/thead/tr/th[";
		String afterXpath = "]";
		List<WebElement>  cols =driver.findElements(By.xpath(OR.getProperty("Rough_XPATH")));
		log.info("Finding Table Columns count");
		int colCount = cols.size();
		System.out.println("Column Count is:  ");
		System.out.println(colCount);
		
		log.info("Creating arrayList");
		ArrayList<String> ar = new ArrayList<String>();
		
		for(int i=1; i<= colCount; i++){
		String actualXpath = beforeXpath + i + afterXpath;
		WebElement element = driver.findElement(By.xpath(actualXpath));
		ar.add(element.getText());
		log.info("Adding Text in the array List");
		}
		System.out.println(ar);
		
		ArrayList<String> br = new ArrayList<String>();
		br.add("Name");
		br.add("Description");
		br.add("Modified By");
		br.add("Modified Date");
		br.add("");
		br.add("");
		br.add("");
		System.out.println(br);		
		
		Assert.assertEquals(ar, br);
	}
	
	public boolean validateNewCalcColBtn(){
		return NewCalColBtn.isDisplayed();
	}
	
	public boolean validateEditBtn(){
		return EditBtn.isDisplayed();
	}
	
	public boolean validateCloneBtn(){
		return CloneBtn.isDisplayed();
	}
	
	public calcColPageNewBtn clickOnNewBtn(){
		NewCalColBtn.click();
		return new calcColPageNewBtn();
	}
	
	
}
