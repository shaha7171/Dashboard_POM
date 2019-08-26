package Rough;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CalcColsPage;
import pages.ConnectionsPage;
import pages.HomePage;
import pages.ModulesPage;
import pages.TopMenuBar;
import pages.WidgetsPage;
import pages.calcColPageNewBtn;
import pages.ucDashboardPage;
import utilities.TestUtil;

public class Scratch extends BaseTest {

	HomePage homePage;
	ConnectionsPage connPage;
	ModulesPage modPage;
	WidgetsPage widPage;
	TopMenuBar TMBar;
	CalcColsPage CCPage;
	calcColPageNewBtn CCPNBtn;
	ucDashboardPage ucdPage;

	public Scratch() {
		super();
	}

	@BeforeMethod
	public void init() {
		startup();
		homePage = new HomePage();
		connPage = new ConnectionsPage();
		modPage = new ModulesPage();
		widPage = new WidgetsPage();
		TMBar = new TopMenuBar();
		CCPNBtn = new calcColPageNewBtn();
		 CCPage = new CalcColsPage();
	}

	@AfterMethod
	public void close() {
		// tearDown();
	}

	@Test
	public void validateNameandDescriptionTest() throws InterruptedException{
		TMBar.ClickOnCalc();
		
		CCPage.clickOnNewBtn();
		click("NCCCancel_CSS");
		//wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > button")).click();
		//driver.findElement(By.xpath("/html/body/div[3]/div[7]/button")).click();
		//click("NCCNo");
		
	
	}
	
		
	}
	
	