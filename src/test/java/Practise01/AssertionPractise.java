package Practise01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractise 
{
@Test
public void sample() 
{

System.out.println("Step 1");
System.out.println("Step 2");

//Hard Assert
Assert.assertEquals(true, true); //Passed

System.out.println("Step 3");
System.out.println("Step 4");

Assert.assertEquals(1, 0); //Fails


String b = "hi";
Assert.assertTrue(b.contains("n")); //Fails

System.out.println("Step 5");
}




@Test
public void sample1()
{
  SoftAssert sa = new SoftAssert();// SoftAssert 
  
System.out.println("Step 1");
System.out.println("Step 2");

//
sa.assertEquals(false, false);

System.out.println("Step 3");
System.out.println("Step 4");

String b = "hi";
sa.assertTrue(b.contains("7"));//Fails

System.out.println("Step 5");

sa.assertAll();//It will Log all the assertion failure	

}

}
