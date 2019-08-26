package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConnectionsPage;
import pages.HomePage;
import pages.ModulesPage;
import pages.WidgetsPage;

public class HomePageTest extends BaseTest{
	
	

	HomePage homePage;
	ConnectionsPage connPage;
	ModulesPage modPage;
	WidgetsPage widPage;
	
	 
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void init(){
		startup();
		homePage =new HomePage();
		connPage =new ConnectionsPage();
		modPage =new ModulesPage();
		widPage =new WidgetsPage();
	}
	
	@AfterMethod
	public void close(){	
		tearDown();	
	}
	
	
	
	//Test Cases
	@Test(priority=1)
	public void HomePageTitleTest(){
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "UC Dashboard Manager - Admin");
		
	}
	
	@Test(priority=2)
	public void verifyWelcomeMessage() {	
		log.info("Verifying Welcome message on the home screen");
		Assert.assertTrue(homePage.ClickOnCheckox(), "Welcome message is not present.");		
	}
	
	@Test(priority=3)
	public void clickOnConnTest(){
		homePage.ClickOnConnections();
		String title = connPage.validateConnPage();
		Assert.assertEquals(title, "Connections");
	}
	
	@Test(priority=4)
	public void clickOnModuleTest(){
		homePage.ClickOnModules();
		String title = modPage.validateModulePage();
		Assert.assertEquals(title, "Modules");
	}
	
	@Test(priority=5)
	public void clickOnWidgetsTest(){
		homePage.ClickOnWidgets();
		String title = widPage.validateWidgetPage();
		Assert.assertEquals(title, "Widgets");
	}
	
	@Test(priority=6)
	public void clickOnCGITest(){
		String clickCGI= homePage.clickOnCGI();
		Assert.assertEquals(clickCGI, "IT and business consulting services | CGI.com");	
	}
	
	



}
