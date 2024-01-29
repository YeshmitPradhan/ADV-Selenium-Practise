package Practise01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractise 
{
@Test(priority = 0, invocationCount = 2)
public void createCustomer()
{
	Assert.fail();
	System.out.println("Create");
}
@Test(dependsOnMethods = "createCustomer")
public void modifyCustomer()
{
	System.out.println("Modify");
	
}
@Test(priority = 1)
public void deleteCustmoer()
{
	System.out.println("Delete");
}
}
