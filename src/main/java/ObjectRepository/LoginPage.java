package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Rule 1
public class LoginPage 
{

	//Rule 2: Declaration
	
	@FindBy(name="user_name")
	private WebElement usernametxtfield;
	
	@FindBy(name="user_password")
	private WebElement passwordtxtfield;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	
	//Rule 3: Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	
	//Rule 4: Utilization
	public WebElement getUsernametxtfield()
	{
		return usernametxtfield;
	}

	public WebElement getPasswordtxtfield() 
	{
		return passwordtxtfield;
	}

	public WebElement getLoginbutton() 
	{
		return loginbutton;
	}
	
	
	//Business Library
	public void loginToAppl(String USERNAME,String PASSWORD)
	{
		usernametxtfield.sendKeys(USERNAME);
		passwordtxtfield.sendKeys(PASSWORD);
		loginbutton.click();
	}
}
