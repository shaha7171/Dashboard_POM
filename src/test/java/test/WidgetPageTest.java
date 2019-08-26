package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
import pages.ucDashboardPage;

public class WidgetPageTest extends BaseTest {
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

	public WidgetPageTest() {
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

	@AfterMethod
	public void close() {
		tearDown();
	}

	@Test(priority = 1)
	public void ValidateWidPageTestnTable() {
		homePage.ClickOnWidgets();
		String Title = widPage.validateWidgetPageTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "UC Dashboard Manager - Admin");
		Assert.assertTrue(isElementPresent("WPTable_CSS"), "Table is not present");
	}

	@Test(priority = 2)
	public void ValidateTopWidPageTestnTable() throws InterruptedException {
		TMBar.ClickOnWidgets();
		String Title = widPage.validateWidgetPageTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "UC Dashboard Manager - Admin");
		Assert.assertTrue(isElementPresent("WPTable_CSS"), "Table is not present");
	}

}
