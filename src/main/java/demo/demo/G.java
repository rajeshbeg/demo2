package demo.demo;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class G {
	// Declear the Extent report variable 
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest childTest;
	
	
	
@BeforeTest
	public void setupReport()
	{
	// Initialize the Report and set the system info and set the Result info 

	htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport2.html");
	extent= new ExtentReports();
	extent.attachReporter(htmlreporter);
	extent.setSystemInfo("HostName", "Automation Framework");
	extent.setSystemInfo("Environment", "Automation Test");
	extent.setSystemInfo("Tester Name", "Rajesh Beg");
	
	htmlreporter.config().setDocumentTitle("TEA WEb Automation");
	htmlreporter.config().setReportName("TEA WEB Automation Test Result");
	htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	htmlreporter.config().setTheme(Theme.STANDARD);
	
	}

//@Test
//public void Test1()
//{
//	logger=extent.createTest("Test1");
//	System.out.println("Test 1 completed");
//	logger.log(Status.PASS, MarkupHelper.createLabel("Test1 is pass", ExtentColor.GREEN));
//
//}
@AfterMethod
public void getResult(ITestResult result)
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"-Test is Failed", ExtentColor.RED));
	    logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- tset is failed", ExtentColor.RED));
	}
	else if (result.getStatus()==ITestResult.SKIP)
	{
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Tes case is skipped", ExtentColor.ORANGE));
	}
}
@AfterTest
public void endReport()
{
extent.flush();	
}
}