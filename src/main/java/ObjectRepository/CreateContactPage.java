package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtilities;

public class CreateContactPage extends SeleniumUtilities
{

	@FindBy(xpath="//input[@name=\"lastname\"]")
	private WebElement lastNameTxtField;
	
	@FindBy(xpath="//select[@name=\"leadsource\"]")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@name=\"department\"]")
	private WebElement departmentTxtField;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement emailTxtField;
	
	@FindBy(xpath="//input[@name=\"assistant\"]")
	private WebElement assistantTxtField;
	
	@FindBy(xpath="//input[@name=\"assistantphone\"]")
	private WebElement assistantPhoneTxtField;
	
	@FindBy(xpath="//input[@name=\"emailoptout\"]")
	private WebElement emailCheckBox;
	
	@FindBy(xpath="//input[@name=\"reference\"]")
	private WebElement referenceCheckBox;
	
	@FindBy(xpath="//input[@name=\"notify_owner\"]")
	private WebElement notifyOwnerCheckBox;
	
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement clickOnSaveButton;
	//
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //
	
	public WebElement getLastNameTxtField() 
	{
		return lastNameTxtField;
	}
	
	public WebElement getleadSourceDropDown()
	{
		return leadSourceDropDown;
	}

	public WebElement getDepartmentTxtField() 
	{
		return departmentTxtField;
	}

	public WebElement getEmailTxtField() 
	{
		return emailTxtField;
	}

	public WebElement getAssistantTxtField()
	{
		return assistantTxtField;
	}

	public WebElement getAssistantPhoneTxtField() 
	{
		return assistantPhoneTxtField;
	}

	public WebElement getEmailCheckBox() 
	{
		return emailCheckBox;
	}

	public WebElement getReferenceCheckBox() 
	{
		return referenceCheckBox;
	}

	public WebElement getNotifyOwnerCheckBox()
	{
		return notifyOwnerCheckBox;
	}
	
	public WebElement getclickOnSaveButton()
	{
		return clickOnSaveButton;
	}
	
	/**
	 * This method will create new contact with only mandatory details 
	 * @param ln
	 * @return 
	 */
	//Business Library
	public void createNewContact(String ln)
	{
		lastNameTxtField.sendKeys(ln);
		clickOnSaveButton.click();
	}
	
	
	/**
	 * This method will create new contact with all details and save it
	 * @param ln
	 * @param lsdd
	 * @param deptname
	 * @param email
	 * @param asstname
	 * @param asstphno
	 */
	
	
	//Business Library
	public void createNewContact(String ln,String lsdd,String deptname,String email,String asstname,String asstphno)
	{
		lastNameTxtField.sendKeys(ln);
		dropDownHandle(lsdd, leadSourceDropDown);
		leadSourceDropDown.sendKeys(lsdd);
		departmentTxtField.sendKeys(deptname);
		emailTxtField.sendKeys(email);
		assistantTxtField.sendKeys(asstname);
		assistantPhoneTxtField.sendKeys(asstphno);
		emailCheckBox.click();
		referenceCheckBox.click();
		notifyOwnerCheckBox.click();
		clickOnSaveButton.click();
	}
}
