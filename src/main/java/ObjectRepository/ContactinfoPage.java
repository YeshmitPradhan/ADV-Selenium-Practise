package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinfoPage 
{
	
@FindBy(xpath="//span[.='Spiderman']")
private WebElement valLastname;

@FindBy(xpath="//span[@id=\"dtlview_Lead Source\"]/font")
private WebElement valLeadSource;

@FindBy(xpath="//span[.='Automation']")
private WebElement valdeptname;

@FindBy(xpath="//span[@id=\"dtlview_Email\"]/a")
private WebElement valEmail;

@FindBy(xpath="//td[@id=\"mouseArea_Assistant\"]/span")
private WebElement valAsstname;

@FindBy(xpath="//td[@id=\"mouseArea_Assistant Phone\"]/span")
private WebElement valAsstPhno;

@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
private WebElement contactHeadertext;

//
public ContactinfoPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}


//Utilization
public WebElement getValLastname() 
{
	return valLastname;
}

public WebElement getValLeadSource() 
{
	return valLeadSource;
}

public WebElement getValdeptname() 
{
	return valdeptname;
}

public WebElement getValEmail() 
{
	return valEmail;
}

public WebElement getValAsstname() 
{
	return valAsstname;
}

public WebElement getValAsstPhno()
{
	return valAsstPhno;
}

public WebElement getcontactHeadertext()
{
return contactHeadertext;	
}

/**
 * This method will capture the header text and return it to caller
 * @return
 */
//Business Library
public String captureHeaderText()
{
return contactHeadertext.getText(); 	
}



}
