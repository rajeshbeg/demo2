package demo.demo;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


import junit.framework.Assert;


public class E {
	public ExtentHtmlReporter htmlReporter;
	public  ExtentReports extent;
	public  ExtentTest test;
	@BeforeTest
	public void startReport(){
	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
	extent= new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("HostName", "SoftWareTesting material");
	extent.setSystemInfo("Environment", "Automation Framework");
	extent.setSystemInfo("User Name", "Rajesh Beg");
	
	   htmlReporter.config().setDocumentTitle("TeaWeb Automation");
	   htmlReporter.config().setReportName("Tea Saler Automation Test cases Result");
	   htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	   htmlReporter.config().setTheme(Theme.STANDARD);
	}
	@Test
	public void PassTest(){
		test= extent.createTest("Start Execute Pass Test");
		Assert.assertTrue(true);
		test.log(Status.PASS,MarkupHelper.createLabel("Pass test is paased",ExtentColor.GREEN));
	}
	@Test
	public void  FailTest()
	{
		test=extent.createTest("Fail Test");
				Assert.assertTrue(false);
		test.log(Status.PASS, MarkupHelper.createLabel("Fail Test is Failed", ExtentColor.RED));
	}
	@Test
	public void SkipTest()
	{
		test= extent.createTest("Skip Test");
		throw new SkipException("Skiip-This is not ready for Testing");
	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"-Test is Failed", ExtentColor.RED));
		    test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- tset is failed", ExtentColor.RED));
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Tes case is skipped", ExtentColor.ORANGE));
		}
	}
	@AfterTest
	public void endReport(){
		extent.flush();
	}

}
