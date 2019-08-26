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

public class TopMenuBarTest extends BaseTest {
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

	public TopMenuBarTest() {
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
	public void ClickOnUCDashboardTest() {
		TMBar.ClickOnUCDashBoard();
		String title = ucdPage.ValidateUCDashboard();
		Assert.assertEquals(title, "UCDashboard");
	}

	@Test(priority = 2)
	public void ClickOnCalcColsTest() {
		TMBar.ClickOnCalc();
		String title = CCPage.ValidateCalcColPage();
		Assert.assertEquals(title, "Calculated Columns");
	}

	@Test(priority = 3)
	public void ClickOnCondStylesTest() {
		TMBar.ClickOnCondiStyles();
		String title = condStyles.ValidateCondStylesPage();

		Assert.assertEquals(title, "Conditional Styles");
	}

	@Test(priority = 4)
	public void ClickOnStylesTest() {
		TMBar.ClickOnStyles();
		String title_1 = Style.ValidateStylesPage();
		Assert.assertEquals(title_1, "Styles");
	}

	@Test(priority = 5)
	public void ClickOnThemesTest() {
		TMBar.ClickOnThemes();
		String title_2 = Themes.ValidateThemesPage();
		Assert.assertEquals(title_2, "Themes");
	}

}
