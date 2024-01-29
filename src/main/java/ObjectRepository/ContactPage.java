package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
@FindBy(xpath="//img[@title=\"Create Contact...\"]")
private WebElement createContactButton;

public ContactPage(WebDriver driver)
{
PageFactory.initElements(driver,this);
}

public WebElement getCreateContactButton() 
{
	return createContactButton;
}

//Business Library

/**
 * This method will go to create Contact page
 */
public void clickOnCreateContact()
{
createContactButton.click();	
}

}
