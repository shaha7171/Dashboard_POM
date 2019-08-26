package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DbManager;
import utilities.ExcelReader;
import utilities.MonitoringMail;
import utilities.TestConfig;
import listeners.WebEventListener;

public class BaseTest {

	/*
	 * Excel - done Logs - done Properties - done TestNG - done JavaMail - done
	 * ReportNG Database WebDriver - done Explicit and ImplicitWait - done
	 * Keywords - done Screenshots Maven - Build tool Jenkins
	 * 
	 */

	public static WebDriver driver;
	public SoftAssert softAssert = new SoftAssert();
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(BaseTest.class);
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;
	public static WebElement dropdown;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	@BeforeSuite
	public void setUp() {

		// Properties File

		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
			log.info("Config file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.info("OR file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/* _____________________________________________________________________________________________________________________________ */
// Database initialization
		try {
			DbManager.setMysqlDbConnection();
			log.info("DB Connection established !!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void startup() {

		log.info("Initiallaizing browser and other settings");
/* _____________________________________________________________________________________________________________________________ */
// Browser's Configuration

		if (Config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox Launched");

		} else if (Config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Launched");

		} else if (Config.getProperty("browser").equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			log.info("IE Launched");
		}

/* ___________________________________________________________________________________________________________________________________________________ */
//Initializing object of EventFiringWebDriver

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
/* ___________________________________________________________________________________________________________________________________________________ */
// URL initialization, Implicit Wait & Explicit Wait

		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : " + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

	}

/* ________________________________________________________________________________________________________________________________ */
// Click

	public static void click(String locatorKey) {

		if (locatorKey.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

		}

		else if (locatorKey.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();

		} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

			driver.findElement(By.id(locatorKey)).click();

		}

		log.info("Clicking on an Element : " + locatorKey);

	}

/* __________________________________________________________________________________________________________________________________ */
// Type

	public static void type(String locatorKey, String value) throws IOException, AddressException, MessagingException {

		if (locatorKey.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

		}

		else if (locatorKey.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);

		} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

			driver.findElement(By.id(locatorKey)).sendKeys(value);

		}

		log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);

	}

/* ____________________________________________________________________________________________________________________________________ */
// Select

	public static void select(String locatorKey, String value)
			throws IOException, AddressException, MessagingException {

		if (locatorKey.endsWith("_XPATH")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));

		}

		else if (locatorKey.endsWith("_CSS")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

		} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

			dropdown = driver.findElement(By.id(locatorKey));

		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.info("Typing in an Element : " + locatorKey + " entered the value as : " + value);

	}

/* _________________________________________________________________________________________________________________________________________ */
// isElementPresent

	public static boolean isElementPresent(String locatorKey) {

		try {

			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey)));

			}

			else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

				driver.findElement(By.id(locatorKey));

			}

			log.info("Finding the Element : " + locatorKey);
			return true;
		} catch (Throwable t) {

			log.info("Error while finding an element : " + locatorKey + " exception message is : " + t.getMessage());
			return false;

		}

	}

/* ________________________________________________________________________________________________________________________________________ */	
// Quit

	public void tearDown() {

		driver.quit();
		log.info("Test Execution Completed !!!");

	}
	
/*__________________________________________________________________________________________________________________________________________*/
// Email	
	
	@AfterSuite
	public static void sendMail() throws AddressException, MessagingException {

		log.info("Sending Mail...");
		/*MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
				TestConfig.attachmentPath, TestConfig.attachmentName);
*/		log.info("Test Report has emailed!!!");

	}

}
