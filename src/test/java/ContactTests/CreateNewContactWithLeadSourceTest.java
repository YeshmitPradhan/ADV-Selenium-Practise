package ContactTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactPage;
import ObjectRepository.ContactinfoPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateNewContactWithLeadSourceTest extends BaseClass
{
@Test(groups = { "SmokeSuite","reggressionSuite"})
public void createNewContactWithLeadSource() throws Throwable
{





//Step 6:  Capture the data
String cv = eutil.readDataFromExcelFile("Sheet1", 1, 2);

String dd = eutil.readDataFromExcelFile("Sheet1", 4, 3);

String dpt = eutil.readDataFromExcelFile("Sheet1", 7, 4);

String email = eutil.readDataFromExcelFile("Sheet1", 7, 5);

String astnt = eutil.readDataFromExcelFile("Sheet1", 7, 6);

String astntphn = eutil.readDataFromExcelFile("Sheet1", 7, 7);


//Step 3: Click on Contact

HomePage hp = new HomePage(driver);

hp.clickOnContact();

//Step 4: Click on Create Contact 

ContactPage cp = new ContactPage(driver);

cp.clickOnCreateContact();

//
//Step 5: Provide the mandatory Details and save the contact

CreateContactPage ccnp = new CreateContactPage(driver);

ccnp.createNewContact(cv, dd, dpt, email, astnt, astntphn);

//



//Step 7 : Validate the Contact
ContactinfoPage cip = new ContactinfoPage(driver);

String conHeaderTxt = cip.captureHeaderText();

Assert.assertTrue(conHeaderTxt.contains(cv));
System.out.println(conHeaderTxt);

// or 

String vt = cip.getValLastname().getText();
Assert.assertEquals(vt, cv);


//

String ddv = cip.getValLeadSource().getText();
Assert.assertEquals(ddv, dd);

//

String dptv = cip.getValdeptname().getText();
Assert.assertEquals(dptv, dpt);

//

String emailv = cip.getValEmail().getText();
Assert.assertEquals(emailv, email);

//

String astv = cip.getValAsstname().getText();
Assert.assertEquals(astv, astnt);

//
	 
String astphnv	= cip.getValAsstPhno().getText();
Assert.assertEquals(astphnv, astntphn);




 


}
}
