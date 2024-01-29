package Practise01;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ex01 
{
public static void main(String[] args) throws Throwable 
{
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Step2: Launch the Application
driver.get("http://localhost:8888/index.php?action=Login&module=Users");
driver.manage().window().maximize();

//Step3: Login to Application
driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin");
driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

//Step 4: Click on Contact
driver.findElement(By.xpath("//a[.='Contacts']")).click();
//Step 5: Click on Create Contact 
driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
//Step 6: Provide the mandatory Details
driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("Monty");
//

//
WebElement ele = driver.findElement(By.xpath("(//img[@alt=\"Select\"])[1]"));
ele.click();


Set<String> allids = driver.getWindowHandles();

for(String id:allids)
{
driver.switchTo().window(id);
String title = driver.getTitle();
System.out.println(title);
}


/*

//Step 7: Click on save 
driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();

//Step 8 : Validate the Contact
String vt = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
if(vt.contains("Monty"))
{
System.out.println("Passed");
System.out.println(vt);
}
else
{
System.out.println("Failed");	
}

//Step 9: Click on SignOut
Thread.sleep(2000);
Actions a = new Actions(driver); 
WebElement ele = driver.findElement(By.xpath("(//img[@style=\"padding: 0px;padding-left:5px\"])[1]"));
a.moveToElement(ele).perform();
Thread.sleep(2000);
WebElement e = driver.findElement(By.xpath("//a[.='Sign Out']"));
a.click(e).perform();

//Step 10 : Close the browser
//driver.quit();
 
 */
}
}
