package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
@FindBy(xpath="//input[@name=\"productname\"]")
private WebElement productNameTxtField;

@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
private WebElement savebut;

public CreateProductPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public WebElement getproductNameTxtField()
{
return productNameTxtField;	
}


public WebElement getsavebut()
{
return savebut;	
}



/**
 * This method will create New Product with only Mandatory Details and perform save action
 * @param PRODUCTNAME
 */
//Business Logic
public void createNewProduct(String PRODUCTNAME)
{
productNameTxtField.sendKeys(PRODUCTNAME);	
savebut.click();
}



}
