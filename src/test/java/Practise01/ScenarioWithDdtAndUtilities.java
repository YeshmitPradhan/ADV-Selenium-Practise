package Practise01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtilities;
import ObjectRepository.ContactPage;
import ObjectRepository.ContactinfoPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class ScenarioWithDdtAndUtilities 
{
public static void main(String[] args) throws Throwable 
{

	SeleniumUtilities su = new SeleniumUtilities();
	PropertyFileUtilities pfu = new PropertyFileUtilities();
	ExcelFileUtilities efu = new ExcelFileUtilities();
	
   
	WebDriver driver = new ChromeDriver();
    su.implicitWait(driver);
   
String URL = pfu.readDataFromPropertyFile("url");
String USERNAME = pfu.readDataFromPropertyFile("un");
String PASSWORD = pfu.readDataFromPropertyFile("psw");



//Step 6:  Capture the data
String cv = efu.readDataFromExcelFile("Sheet1", 1, 2);

String dd = efu.readDataFromExcelFile("Sheet1", 4, 3);

String dpt = efu.readDataFromExcelFile("Sheet1", 7, 4);

String email = efu.readDataFromExcelFile("Sheet1", 7, 5);

String astnt = efu.readDataFromExcelFile("Sheet1", 7, 6);

String astntphn = efu.readDataFromExcelFile("Sheet1", 7, 7);


//Step 1: Launch the Application

driver.get(URL);
su.maximizeWindow(driver);

//Step 2 : Login to Application

LoginPage lp = new LoginPage(driver);
/*
lp.getUsernametxtfield().sendKeys(USERNAME);
lp.getPasswordtxtfield().sendKeys(PASSWORD);
lp.getLoginbutton().click();
*/
lp.loginToAppl(USERNAME, PASSWORD);

//Step 3: Click on Contact

HomePage hp = new HomePage(driver);

/*hp.getContactButton().click();*/

hp.clickOnContact();

//Step 4: Click on Create Contact 

ContactPage cp = new ContactPage(driver);

/*cp.getCreateContactButton().click();*/
cp.clickOnCreateContact();

//
//Step 5: Provide the mandatory Details and save the contact

CreateContactPage ccnp = new CreateContactPage(driver);

/*ccnp.getLastNameTxtField().sendKeys(cv);
ccnp.getleadSourceDropDown().sendKeys(dd);
ccnp.getDepartmentTxtField().sendKeys(dpt);
ccnp.getEmailTxtField().sendKeys(email);
ccnp.getAssistantTxtField().sendKeys(astnt);
ccnp.getAssistantPhoneTxtField().sendKeys(astntphn);
ccnp.getEmailCheckBox().click();
ccnp.getReferenceCheckBox().click();
ccnp.getNotifyOwnerCheckBox().click();*/



ccnp.createNewContact(cv, dd, dpt, email, astnt, astntphn);
//



//Step 7 : Validate the Contact
ContactinfoPage cip = new ContactinfoPage(driver);

System.out.println(cip.getcontactHeadertext());

// or 

String vt = cip.getValLastname().getText();
if(vt.contains(cv))
{
System.out.print("Last Name Passed : ");
System.out.println(vt);
}
else
{
System.out.println("Failed");	
}
//

String ddv = cip.getValLeadSource().getText();
if(ddv.contains(dd))
{
   System.out.println("Lead Source passed");
}
else {System.out.println("failed");
}
//

String dptv = cip.getValdeptname().getText();
if(dptv.contains(dpt))
{
   System.out.println("deptname passed");
}
else
{
System.out.println("deptname failed");   
}


String emailv = cip.getValEmail().getText();
if(emailv.contains(email))
 {
   System.out.println("Email Passed");
 }
else
{
   System.out.println("Email Failed");
}

String astv = cip.getValAsstname().getText();
	 if(astv.contains(astnt))
	 {
		 System.out.println("Assistantname Passed");
	 }
	 else
	 {
		System.out.println("Assistantname Failed"); 
	 }
	 
String astphnv	= cip.getValAsstPhno().getText();
if (astphnv.contains(astntphn))
{
	System.out.println("Assistant PHNO Passed");
}
else 
{
	System.out.println("Assistant PHNO Failed");
}


//Step 8: Click on SignOut
hp.signOutFromApp(driver);


 
//Step 9 : Close the browser
//driver.quit();
 


	
}
}
