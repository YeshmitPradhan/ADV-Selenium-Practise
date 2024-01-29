package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**This class consist of generic method related to selenium
 * 
 */
public class SeleniumUtilities 
{

	/**This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	
	/**This method will add 10s of implicit wait
	 * 
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	/**This method will wait 10s for an element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**Handling Drop down by Index 
	 * 
	 * @param element
	 * @param index
	 */
	public void dropDownHandle(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	
	
	/**Handling Drop down by Value
	 * 
	 * @param element
	 * @param indexvalue
	 */
	public void dropDownHandle(WebElement element,String indexvalue)
	{
		Select s = new Select(element);
        s.selectByValue(indexvalue);	
	}
	
	
	
	/**Handling drop down by Visible text
	 * 
	 * @param txt
	 * @param element
	 */
	public void dropDownHandle(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	
	
	/**
	 * This method will perform mouse over action on a web element 
	 * @param driver
	 * @param element
	 */
	public void mouseOverActions(WebDriver driver, WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform single Click action
	 * @param driver
	 * @param element
	 */
	public void clickAction(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.click(element).perform();
	}
	
	
	/**
	 * This method will perform right click action on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	
	
	
	/**
	 * This method will perform double click on a web element 
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	
	
	
	/**
	 * This method will perform drag and drop on a web element
	 * @param driver
	 * @param element1
	 * @param element2
	 */
	public void dragAndDrop(WebDriver driver,WebElement element1,WebElement element2)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(element1, element2);
	}
	
	
	
	/**
	 * This method will perform click and hold operation on a web element 
	 * @param driver
	 * @param element1
	 * @param element2
	 */
	public void holdAndRelease(WebDriver driver,WebElement element1,WebElement element2)
	{
		Actions a = new Actions(driver);
		a.clickAndHold(element1).perform();
		a.release(element2).perform();
		
	}
	
	
	/**
	 * This method will scroll down the page for 500 units 
	 * @param driver
	 */
	public void scrollDwonAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver ;
		jse.executeScript("Window.scrollBy(0,500);", "");
	}
	
	
	
	/**
	 * This method will scroll up the page for 500 units 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) 
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver ;
		jse.executeScript("Window.scrollBy(0,-500);", "");
	}
	
	
	
	/**
	 * This method will handle frame using Frame Index
	 * @param driver
	 * @param frameindex
	 */
	public void handleFrame(WebDriver driver, int frameindex)
	{
		driver.switchTo().frame(frameindex);
		
	}
	
	
	
	/**
	 * This method will handle Frame using Name or Id Locator
	 * @param driver
	 * @param frameNameOrId
	 */
	public void handleFrame(WebDriver driver,String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
		
	}
	
	
	
	/**
	 * This method will handle Frame using frame web Element 
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
		
	}
	
	/**
	 * This method will accept the Alert Popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	
	
	/**
	 * This method will dismiss the Alert Popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method will capture the Alert text and return it to Caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
		
	}
	
	
	
	/**
	 * This method will capture the ScreenShot and return the Path to Caller 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String captureScreenShot(WebDriver driver ,String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShots\\"+screenShotName+".png");
		
		Files.copy(src, dest);
		return dest.getAbsolutePath();  //Extent Reports
		
	}
}
