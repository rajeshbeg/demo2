package demo.demo;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class F extends E {
	@Test(priority=1)
	public void Test1()
	{
		test=extent.createTest("Test1");
		System.out.println("Test 1 completed");
		test.log(Status.PASS, MarkupHelper.createLabel("Test1 is pass", ExtentColor.GREEN));
	}
	@Test(priority=2)
	public void Test2()
	{
		test=extent.createTest("Test2");
		System.out.println("Test2 completed");
	    test.log(Status.FAIL, MarkupHelper.createLabel("Test2 is failed", ExtentColor.RED));
	}
	@Test(priority=3)
	public void Test3()
	{
		test=extent.createTest("Test3");
		System.out.println("Test3 completed");
	test.log(Status.PASS, MarkupHelper.createLabel("Test 3 is passed", ExtentColor.GREEN));
	}
	


}
