package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
@FindBy(xpath="//img[@title=\"Create Product...\"]")
private WebElement createNewProductLogo;

public ProductPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public WebElement getcreateNewProductLogo()
{
	return createNewProductLogo;
}

//Business Library
/**
 * This method will go to Create New Product Page
 */
public void clickOnCreateNewProduct()
{
createNewProductLogo.click();	
}

}