package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementations implements ITestListener 
{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
	
		//Start of @Test - Test method
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Execution Started----------");
       
		//Provide the @Test for Extent reports
		test = report.createTest(methodName);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{  
		//@Test is passed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Pass----------");
		
		//Log the Status as Pass in Extent reports
		test.log(Status.PASS, methodName+"--------Test Pass----------");
	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{   
		//@Test is Failed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Fail----------");
		
		//Print the exception in console
		System.out.println(result.getThrowable());
		
		//Log the Status as FAIL in Extent Reports
		test.log(Status.FAIL, methodName+"--------Test Fail----------");
		test.log(Status.INFO, result.getThrowable());
		
		//Capture the screenshot
		SeleniumUtilities su = new SeleniumUtilities();
		JavaUtilities ju = new JavaUtilities();
		
		String screenShotName = methodName+"-"+ju.GetSystemDate();
		
		try 
		{
			String path = su.captureScreenShot(BaseClass.sDriver, screenShotName);
			
			//Attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
		}
		catch (Throwable e) 
		{
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{   
		//@Test is Skipped
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------Test Skipped----------");
		
		//Print the exception in console
		System.out.println(result.getThrowable());
	
		//Log the status as Skipped in Extent Reports
		test.log(Status.SKIP, methodName+"--------Test Skipped----------");
		test.log(Status.INFO, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
	System.out.println("Suite Execution Started");	
	ExtentSparkReporter esr = new ExtentSparkReporter(".\\Extent Reports\\report-"+ new JavaUtilities().GetSystemDate()+".html");
	esr.config().setDocumentTitle("Execution Report");
	esr.config().setTheme(Theme.DARK);
	esr.config().setReportName("Vtiger Execution Report");
	
	//Attach the configuration to actual extentReports class
	report = new ExtentReports();
	report.attachReporter(esr);
	
	//Set any system information
	report.setSystemInfo("Base platform", "Windows");
	report.setSystemInfo("Base Browser", "Edge");
	report.setSystemInfo("Base Environment", "Testing");
	report.setSystemInfo("Reporter Name", "Susis");
	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
	
	System.out.println("Suite Execution Finshed");	
		
	//Generate the report
	report.flush();
	
	}

	
	
}
