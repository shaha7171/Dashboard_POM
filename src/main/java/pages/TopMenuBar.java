package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BaseTest;

public class TopMenuBar extends BaseTest {
	@FindBy(css="body > div > div > div:nth-child(1) > div > h4")
	WebElement welcome;
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public CalcColsPage ClickOnCalc() {
		click("CalColumn_CSS");
		return new CalcColsPage();
	}

	public CondStylesPage ClickOnCondiStyles() {
		click("CondStyles_CSS");
		return new CondStylesPage();
	}

	public StylesPage ClickOnStyles() {
		click("Styles_CSS");
		return new StylesPage();
	}

	public ThemesPage ClickOnThemes() {
		click("Themes_CSS");
		return new ThemesPage();
	}

	public WidgetsPage ClickOnWidgets() {
		click("Widgets_CSS");
		return new WidgetsPage();

	}

	public ModulesPage ClickOnModules() {
		click("Modules_CSS");
		return new ModulesPage();
	}

	public ConnectionsPage ClickOnConnections() {
		click("Connections_CSS");
		return new ConnectionsPage();
	}

	public ucDashboardPage ClickOnUCDashBoard() {
		click("ucDashboard_CSS");
		return new ucDashboardPage();
	}

}
