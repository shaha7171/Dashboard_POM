package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import pages.ucDashboardPage;

public class CalcColPageTest extends BaseTest{
	
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

	public CalcColPageTest() {
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
		ucdPage = new ucDashboardPage();
		condStyles = new CondStylesPage();
		Style = new StylesPage();
		Themes = new ThemesPage();

	}
	
	//SoftAssert softAssert = new SoftAssert();
	
	@AfterMethod
	public void close() {
		
		tearDown();
	}

	@Test(priority = 1)
	public void ValidateConnPageTestnTableTest() {
		TMBar.ClickOnCalc();
		String Title = CCPage.validateCalcColPageTitle();
		softAssert.assertEquals(Title, "UC Dashboard Manager - Admin");
		softAssert.assertTrue(isElementPresent("CCTable_CSS"), "Table is not present");
		CCPage.clickOnNewBtn();
		softAssert.assertAll();
	}
	
	@Test(priority = 2)
	public void validateCalcColTableColumnsTest(){
	TMBar.ClickOnCalc();
	CCPage.validateCalcColTableColumns();
	}
	
	@Test(priority = 3)
	public void NewCalColsBtn(){
		
	TMBar.ClickOnCalc();
	softAssert.assertTrue(CCPage.validateNewCalcColBtn(), "New btn is not displayed");
	softAssert.assertTrue(CCPage.validateEditBtn(), "Edit Btn is not displayed");
	softAssert.assertTrue(CCPage.validateCloneBtn(), "CLone btn is not displayed");
	softAssert.assertAll();
	}
	


}
