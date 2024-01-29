package ContactTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactPage;
import ObjectRepository.ContactinfoPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
@Listeners(GenericUtilities.ListenersImplementations.class)
public class CreateNewContactTest extends BaseClass
{

@Test(groups = {"SmokeSuite","ProductContact"})
public void createNewContactWithMandatoryDetails() throws Throwable
{


//  Capture the data
String cv = eutil.readDataFromExcelFile("Sheet1", 1, 2);


// Click on Contact

HomePage hp = new HomePage(driver);


hp.clickOnContact();

// Click on Create Contact 

ContactPage cp = new ContactPage(driver);

cp.clickOnCreateContact();


// Provide the mandatory Details and save the contact

CreateContactPage ccnp = new CreateContactPage(driver);

ccnp.createNewContact(cv);


//



// Validate the Contact
ContactinfoPage cip = new ContactinfoPage(driver);

String conHeaderTxt = cip.captureHeaderText();
Assert.assertTrue(conHeaderTxt.contains(cv));

// or 

String vt = cip.getValLastname().getText();

Assert.assertEquals(vt, cv);



}

@Test
public void sample()
{
//Assert.fail();
	System.out.println("Hi");
}



}
