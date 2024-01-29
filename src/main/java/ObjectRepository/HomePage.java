package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities
{
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactButton;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productButton;
	
	@FindBy(xpath="(//img[@style=\"padding: 0px;padding-left:5px\"])[1]")
	private WebElement adminlogo;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactButton() 
	{
		return contactButton;
	}
	
	public WebElement getproductButton()
	{
		return productButton;
	}
	
	public WebElement getadminlogo()
	{
		return adminlogo;
	}
	
	public WebElement getsignoutButton()
	{
		return signoutButton;
	}
	
	/**
	 * This method will go to Contact Page
	 */
	//Business Library
	public void clickOnContact()
	{
		contactButton.click();
	}
	
	
	/**
	 * This method will go to Product Page 
	 */
	public void clickOnProduct()
	{
		productButton.click();
	}
	
	
	/**
	 * This method will Logout from Application
	 * @param driver
	 * @throws Throwable
	 */
	public void signOutFromApp(WebDriver driver) throws Throwable
	{
		mouseOverActions(driver, adminlogo);
		Thread.sleep(3000);
		signoutButton.click();
	}
}
