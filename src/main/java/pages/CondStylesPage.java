package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.BaseTest;

public class CondStylesPage extends BaseTest {
	@FindBy(css = "body > div > div > h2")
	WebElement CondStylesTxt;

	public CondStylesPage() {
		PageFactory.initElements(driver, this);
	}

	public String ValidateCondStylesPage() {
		return CondStylesTxt.getText();

	}

	public String validateCondPageTitle() {
		return driver.getTitle();
	}

}
