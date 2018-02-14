package demo.demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class I extends G{
	@Test(priority=4)
	public void Test4()
	{
		childTest = logger.createNode("MySecondChildTest");
		System.out.println("Test4 completed");
	childTest.log(Status.PASS, MarkupHelper.createLabel("Test 4 is passed", ExtentColor.GREEN));
	}

}
