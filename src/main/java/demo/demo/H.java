package demo.demo;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class H extends G{
	@Test(priority=2)
	public void Test2()
	{
		logger= extent.createTest("Test2");
		System.out.println("Test2 completed");
	    logger.log(Status.FAIL, MarkupHelper.createLabel("Test2 is failed", ExtentColor.RED));
	}
	@Test(priority=3)
	public void Test3()
	{
		childTest = logger.createNode("MyFirstChildTest");
		System.out.println("Test3 completed");
	    childTest.log(Status.FAIL,MarkupHelper.createLabel("Test3 is failed", ExtentColor.RED));
	}
	

}
