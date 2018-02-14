package demo.demo;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class C extends A{
	@Test(priority=5)
    public void test5(){
		extent.startTest("Test5");
		driver.getTitle();
		System.out.println("Test 5 completed ");
		logger.log(LogStatus.PASS,"test5 is pass");
	} 

}
