package Practise01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerEx 
{
@Test(retryAnalyzer = GenericUtilities.IRetryAnalyserImplementation.class)
public void sample()
{
Assert.fail();
System.out.println("Hi");	
}
}
