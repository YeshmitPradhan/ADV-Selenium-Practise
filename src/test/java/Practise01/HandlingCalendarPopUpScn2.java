package Practise01;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import bsh.ParseException;

public class HandlingCalendarPopUpScn2 
{
@Test
public void sample1() throws Throwable
{
	// Calendar Pop up 1st Scenario
	
	WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	driver.get("https://www.makemytrip.com/");
	 Thread.sleep(1000);
	 Actions act = new Actions(driver); 
	act.moveByOffset(10, 10).click().perform(); 
	// driver.findElement(By.xpath("//a[@class='close']")).click();
	 Thread.sleep(1000); 
	
	 //
	 //driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
	 //
	 
	 // Navigate to From and To Elements 
	WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
	 WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']")); src.sendKeys("mumbai"); 
	driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click(); 
	Thread.sleep(2000);
	 dst.sendKeys("Del"); 
	driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click(); 
	Thread.sleep(2000); 
	// navigate to departure //
	driver.findElement(By.xpath("//label[@for=\"departure\"]")).click();
	 // navigate to desired date in calender 
	Thread.sleep(1000);
	 driver.findElement(By.xpath("//div[@aria-label=\"Tue Jan 30 2024\"]")).click();

}
}
