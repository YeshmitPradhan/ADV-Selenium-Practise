package scenarioPractise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 
{
public static void main(String[] args) throws Throwable 
{

WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.get("http://localhost:8888/index.php?action=Login&module=Users");

driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
Thread.sleep(2000);
driver.findElement(By.cssSelector("[id=\"submitButton\"]")).click();

driver.findElement(By.xpath("//a[.='Contacts']")).click();

List<WebElement> allcheck = driver.findElements(By.xpath("//table[@class=\"lvt small\"]//tr[@bgcolor=\"white\"]//td[4]"));

for(WebElement one : allcheck)
{
System.out.println(one.getText());	
}
}
}