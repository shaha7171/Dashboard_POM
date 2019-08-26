package test;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CalcColsPage;
import pages.CondStylesPage;
import pages.ConnectionsPage;
import pages.HomePage;
import pages.ModulesPage;
import pages.StylesPage;
import pages.ThemesPage;
import pages.TopMenuBar;
import pages.WidgetsPage;
import pages.calcColPageNewBtn;
import pages.ucDashboardPage;
import utilities.TestUtil;

public class calcColPageNewBtnTest extends BaseTest{
	
	HomePage homePage;
	ConnectionsPage connPage;
	ModulesPage modPage;
	WidgetsPage widPage;
	TopMenuBar TMBar;
	CalcColsPage CCPage;
	ucDashboardPage ucdPage;
	CondStylesPage condStyles;
	StylesPage Style;
	ThemesPage Themes;
	calcColPageNewBtn CCPNBtn;

	public calcColPageNewBtnTest() {
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
		CCPage = new CalcColsPage();
		CCPNBtn = new calcColPageNewBtn();
		ucdPage = new ucDashboardPage();
		condStyles = new CondStylesPage();
		Style = new StylesPage();
		Themes = new ThemesPage();

	}
	
	
	
	@AfterMethod
	public void close() {
		tearDown();
	}

	@Test(priority = 1)
	public void validateDisplayMessagesTest() {
		TMBar.ClickOnCalc();
		CCPage.clickOnNewBtn();
		CCPNBtn.validateDisplayMessages();
	}
	
	@Test(priority = 2)
	public void validateCancelNoBtnTest() {
		TMBar.ClickOnCalc();
		CCPage.clickOnNewBtn();
		String title = CCPNBtn.validateCancelBtnNo();
		System.out.println(title);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		Assert.assertEquals(title, "Name & Description");	
	}
	
	@Test(priority = 3)
	public void validateCancelYesBtnTest() {
		TMBar.ClickOnCalc();
		CCPage.clickOnNewBtn();
		String title = CCPNBtn.validateCancelBtnYes();
		System.out.println(title);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		Assert.assertEquals(title, "Calculated Columns");	
	}	
	
	
	
	
	
	
/*	@Test(dataProvider = "getData")
	public void validateNameandDescriptionTest(String Name) throws AddressException, InterruptedException, IOException, MessagingException{
		TMBar.ClickOnCalc();
		CCPage.clickOnNewBtn();
		CCPNBtn.validateNameandDescription(Name);
		
	}
	
	@DataProvider()
	public Object[][] getData() {
		return TestUtil.getData("Name&Desc");
	}*/
	
	
	
}

