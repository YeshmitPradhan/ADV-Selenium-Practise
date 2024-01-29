package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyserImplementation implements IRetryAnalyzer

{
    int count = 0;
    int retrycount = 3;//Manually Analysis
	@Override
	public boolean retry(ITestResult result) 
	{
	
		while(count<retrycount)
		{   
			count++ ;
			return true ;//retry , retry , retry
		}
		
		return false;//stop retry
	}

	
	
}
