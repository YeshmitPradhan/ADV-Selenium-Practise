package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
/**
 * This class consist of basic configuration annotation of TestNG
 */
public class BaseClass 
{   
	public PropertyFileUtilities putil = new PropertyFileUtilities();
	public ExcelFileUtilities eutil = new ExcelFileUtilities();
	public JavaUtilities jutil = new JavaUtilities();
	public SeleniumUtilities sutil = new SeleniumUtilities();
	public WebDriver driver;
	
	//For listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = { "SmokeSuite","reggressionSuite","ProductContact"})
	public void bsConfig()
	{
		System.out.println("==== DB Connection Sucessfull");
		
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws Throwable
	{
		String URL = putil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		
		/*
		if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		*/
		
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver);
		
		driver.get(URL);
		
		System.out.println("Browser Launching Sucessfull");
		
		//For Listeners
		sDriver = driver;
	}
	
	
	@BeforeMethod(groups = { "SmokeSuite","reggressionSuite","ProductContact"})
	public void bmConfig() throws Throwable
	{
	
		String USERNAME = putil.readDataFromPropertyFile("un");
		String PASSWORD = putil.readDataFromPropertyFile("psw");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToAppl(USERNAME, PASSWORD);
		System.out.println("Login into App Sucessfull");
	}
	
	@AfterMethod(groups = { "SmokeSuite","reggressionSuite","ProductContact"})
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.signOutFromApp(driver);
		System.out.println("Logout from App Sucessfull");
	}
	
	//@AfterTest
	@AfterClass(groups = { "SmokeSuite","reggressionSuite","ProductContact"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser Clouser Sucessfull");
	}
	
	@AfterSuite(groups = { "SmokeSuite","reggressionSuite","ProductContact"})
	public void asConfig()
	{
		System.out.println("DB clouser Sucessfull ");
	}
	
	
}
