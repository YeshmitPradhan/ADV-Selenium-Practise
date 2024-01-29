package Practise01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelFileUtilities;
import GenericUtilities.PropertyFileUtilities;
import GenericUtilities.SeleniumUtilities;

public class Ex04 
{
 public static void main(String[] args) throws Throwable 
 {   
	 SeleniumUtilities su = new SeleniumUtilities();
	 
	 
	 PropertyFileUtilities pfu = new PropertyFileUtilities();
	 
	 ExcelFileUtilities efu = new ExcelFileUtilities();
    
	 //Launching the browser
	 WebDriver driver = new ChromeDriver();
	 su.maximizeWindow(driver);
	 su.implicitWait(driver);
	
	 
	//Open the application 
	 driver.get(pfu.readDataFromPropertyFile("url"));
	
   // Login into Application
	 driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(pfu.readDataFromPropertyFile("un"));
	 
	 driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(pfu.readDataFromPropertyFile("psw"));
	 
	 driver.findElement(By.id("submitButton")).click();
	 
   //Click on Contact	 
	 driver.findElement(By.xpath("//a[.='Contacts']")).click();
	 
   //Click on Create Contact 
	 driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	
   //Providing the Mandatory Details
	 driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 1, 2));
	 
    driver.findElement(By.xpath("//select[@name=\"leadsource\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 4, 3));
    
    driver.findElement(By.xpath("//input[@id=\"department\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 7, 4));
    
    driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 7, 5));
    
    driver.findElement(By.xpath("//input[@id=\"assistant\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 7, 6));
    
    driver.findElement(By.xpath("//input[@id=\"assistantphone\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 7, 7));
    
    driver.findElement(By.cssSelector("[name=\"emailoptout\"]")).click();
    
    driver.findElement(By.cssSelector("[name=\"reference\"]")).click();
    
    driver.findElement(By.cssSelector("[name=\"notify_owner\"]")).click();
    
    driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 10, 8));
   
    
    
    // System.out.println(efu.readDataFromExcelFile("Sheet1", 10, 9));
    
   // driver.findElement(By.cssSelector("[id=\"mobile\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 10, 9));
    
    //driver.findElement(By.cssSelector("[id=\"homephone\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 10, 10));
    
    //driver.findElement(By.cssSelector("[id=\"otherphone\"]")).sendKeys(efu.readDataFromExcelFile("Sheet1", 10, 11));
	 
	 
	 
    
    
	 
}
}
