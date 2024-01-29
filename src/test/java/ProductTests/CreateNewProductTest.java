package ProductTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ProductInfoPage;
import ObjectRepository.ProductPage;

public class CreateNewProductTest extends BaseClass


{
@Test(groups = "ProductContact")
public void createNewProductWithMandatoryDetails() throws Throwable
{

	
	HomePage hp = new HomePage(driver);
	hp.clickOnProduct();
	
	ProductPage pp = new ProductPage(driver);
	pp.clickOnCreateNewProduct();
	
	
	String pn = eutil.readDataFromExcelFile("Sheet2", 1, 2);
	CreateProductPage cpp = new CreateProductPage(driver);
	cpp.createNewProduct(pn);
	
	ProductInfoPage pip = new ProductInfoPage(driver);
	String vpn= pip.getproductHeader().getText();
	System.out.println(vpn);
	Assert.assertTrue(vpn.contains(pn));
	
}
	
}
