package Practise01;

import java.awt.Robot;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtilities;





public class Ex02 {
	public static void main(String[] args) throws Throwable 
	{
	//
		SeleniumUtilities su = new SeleniumUtilities();
		PropertyFileUtilities pfu = new PropertyFileUtilities();
		ExcelFileUtilities efu = new ExcelFileUtilities();
	    WebDriver driver = new ChromeDriver();
	    su.implicitWait(driver);
	
	
	
	
	
	/*
	FileInputStream fis = new FileInputStream("D:\\JavaApp\\ADVSeleniumPractise\\src\\test\\resources\\Commondata.properties");
	Properties p = new Properties();
	p.load(fis);
	String URL = p.getProperty("url");
	String USERNAME = p.getProperty("un");
	String PASSWORD = p.getProperty("psw");
	*/
	
   //Step 1: Open document in java read Format
  FileInputStream tsdata = new FileInputStream(".\\src\\test\\resources\\TestDataEx01.xlsx");
  
  //Step 2: Create a Workbook
  Workbook wb = WorkbookFactory.create(tsdata);
  
  //Step 3: Navigate to sheet
   Sheet sheet = wb.getSheet("Sheet1");
  
  //Step 4: Navigate to Row 
   Row row = sheet.getRow(1);
   
  //Step 5: Navigate to Cell
   Cell cell = row.getCell(2);
   
  //Step 6:  Capture the data
   String cv = cell.getStringCellValue();
  
   String dd = wb.getSheet("Sheet1").getRow(4).getCell(3).getStringCellValue();
  
   String dpt = wb.getSheet("Sheet1").getRow(7).getCell(4).getStringCellValue();
   
   String email = wb.getSheet("Sheet1").getRow(7).getCell(5).getStringCellValue();
   
   String astnt = wb.getSheet("Sheet1").getRow(7).getCell(6).getStringCellValue();
   
   String astntphn = wb.getSheet("Sheet1").getRow(7).getCell(7).getStringCellValue();
   
  String bdate = wb.getSheet("Sheet1").getRow(10).getCell(8).getStringCellValue();
   
   //Step 7: Close The Workbook
    wb.close();
	//Step 1: Launch the Application
	driver.get(pfu.readDataFromPropertyFile("url"));
    
	su.maximizeWindow(driver);
	
	//Step 2: Login to Application
	driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(pfu.readDataFromPropertyFile("un"));
	driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(pfu.readDataFromPropertyFile("psw"));
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

	
	//Step 3: Click on Contact
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	
	//Step 4: Click on Create Contact 
	driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
	
	//Step 5: Provide the mandatory Details
	driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys(cv);
	//
	
    driver.findElement(By.cssSelector("[name=\"leadsource\"]")).sendKeys(dd);
    
    //
    driver.findElement(By.xpath("(//input[@class=\"detailedViewTextBox\"])[9]")).sendKeys(dpt);
	//
    driver.findElement(By.cssSelector("[id=\"email\"]")).sendKeys(email);
    //
    driver.findElement(By.cssSelector("[id=\"assistant\"]")).sendKeys(astnt);
    //
    driver.findElement(By.cssSelector("[id=\"assistantphone\"]")).sendKeys(astntphn);
    //
    driver.findElement(By.cssSelector("[name=\"emailoptout\"]")).click();
    //
    driver.findElement(By.xpath("//input[@name=\"reference\"]")).click();
    //
    driver.findElement(By.xpath("//input[@name=\"notify_owner\"]")).click();
    //
    driver.findElement(By.xpath("[id=\"jscal_trigger_birthday\"]")).sendKeys(bdate);
    
    
    
    
    
    /*WebElement ele = driver.findElement(By.xpath("(//img[@alt=\"Select\"])[1]"));
	ele.click();

    Thread.sleep(2000);
	Set<String> allids = driver.getWindowHandles();

	for(String id:allids)
	{
	driver.switchTo().window(id);
	String url = driver.getCurrentUrl();
	System.out.println("t ="+url);
	
	if(url.contains("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid="))
	{
		break;
	}
	}
	driver.findElement(By.xpath("(//input[@type=\"text\"])[1]")).sendKeys("qwe");
*/

	
     /*
	//Step 6: Click on save 
	driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();

	//Step 7 : Validate the Contact
	String vt = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	if(vt.contains(cv))
	{
	System.out.println("Passed");
	System.out.println(vt);
	}
	else
	{
	System.out.println("Failed");	
	}
	
	String ddv = driver.findElement(By.xpath("//span[@id=\"dtlview_Lead Source\"]/font")).getText();
   if(ddv.contains(dd))
   {
	   System.out.println("passed");
   }
   else {System.out.println("failed");
   }
   
   String dptv = driver.findElement(By.xpath("//span[.='Automation']")).getText();
   if(dptv.contains(dpt))
   {
	   System.out.println("deptname passed");
   }
   else
   {
	System.out.println("deptname failed");   
   }
   
   String emailv = driver.findElement(By.xpath("//a[.='spidy@fool.com']")).getText();
   if(emailv.contains(email))
     {
	   System.out.println("Email Passed");
     }
   else
   {
	   System.out.println("Email Failed");
   }
   
   String astv = driver.findElement(By.xpath("//span[.='Marry James']")).getText();
		 if(astv.contains(astnt))
		 {
			 System.out.println("Assistant Passed");
		 }
		 else
		 {
			System.out.println("Assistant Failed"); 
		 }
		 
String astphnv	= driver.findElement(By.xpath("//span[.='141-234-423-901']")).getText();
	if (astphnv.contains(astntphn))
	{
		System.out.println("Assistant PHNO Passed");
	}
	else 
	{
		System.out.println("Assistant PHNO Failed");
	}
    
	
	//Step 8: Click on SignOut
	Thread.sleep(2000);
	Actions a = new Actions(driver); 
	WebElement ele1 = driver.findElement(By.xpath("(//img[@style=\"padding: 0px;padding-left:5px\"])[1]"));
	a.moveToElement(ele1).perform();
	Thread.sleep(2000);
	WebElement e = driver.findElement(By.xpath("//a[.='Sign Out']"));
	a.click(e).perform();
     */
	//Step 9 : Close the browser
	//driver.quit();
	 
	

}

}