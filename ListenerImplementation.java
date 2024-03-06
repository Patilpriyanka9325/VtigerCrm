
package CommonUtils;

import org.testng.ITestContext;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		//System.out.println("Testscript Execution is started");//with the help printing line we can not pass a message in the form of string in html report
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is started",true);
		 test= report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript execution is passed",true);
		test.log(Status.PASS, "TestScript execution is passed");
		//test.log(Status.PASS, );
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript execution is failed"+message,true);
		test.log(Status.FAIL, "TestScript execution is failure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript execution is skipped",true);
		test.log(Status.SKIP, "TestScript execution is skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		//Reporter.log("execution is started",true);
		
		//use ExtentSparkReporter class just to configure extent report
	    JavaUtil jUtil = new JavaUtil();
		ExtentSparkReporter reporter =new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
	    reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Pune");
				
		//use ExtentReports to generate exetentreport
		 report = new ExtentReports();
		 report.attachReporter(reporter);
		 report.setSystemInfo("OS", "Window");
		 report.setSystemInfo("Browser", "Chrome");
		 report.setSystemInfo("chromeversion", "121");
		 report.setSystemInfo("Author", "pune");
		 
		 
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub
		//Reporter.log("execution is failed",true);
		
		report.flush();
		
				
		
		
	}
   
}
