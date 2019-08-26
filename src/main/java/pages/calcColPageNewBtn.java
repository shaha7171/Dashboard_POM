package pages;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;


public class calcColPageNewBtn extends BaseTest{

	@FindBy(css = "#calculated-column-form > section.medium-6.large-4.columns > div:nth-child(6) > span.error.message.validation")
	WebElement NameMessage;
	
	@FindBy(css = "#calculated-column-form > section.medium-6.large-4.columns > div:nth-child(9) > span.error.message.validation")
	WebElement SelectItemMessage;
	
	@FindBy(css = "#calculated-column-description")
	WebElement Desc;
	
	@FindBy(css = "#calculated-column-form > section.medium-6.large-4.columns > h2:nth-child(4)")
	WebElement NameNDesc;
	
	@FindBy(css = "body > div > div > h2")
	WebElement CalColHead;
	

	
	


	public calcColPageNewBtn() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateDisplayMessages(){
		click("NCCSave_CSS");
		softAssert.assertTrue(NameMessage.isDisplayed(), "Error message for name is not displayed");
		softAssert.assertTrue(SelectItemMessage.isDisplayed(), "Dropdown error is not displayed");
	}
		
	
	public void validateNameandDescription(String Name) throws InterruptedException, AddressException, IOException, MessagingException{
		type("NCCName_CSS",Name);
		Thread.sleep(1000);
		String Descp = Desc.getText();
		softAssert.assertEquals(Name, Descp);
		softAssert.assertAll();
	}

	public String validateCancelBtnNo(){
		click("NCCCancel_CSS");
		click("NCCNo_CSS");
		return NameNDesc.getText();	
	}
	
	public String validateCancelBtnYes(){
		click("NCCCancel_CSS");
		click("NCCYes_CSS");
		return CalColHead.getText();
	}

}
	


