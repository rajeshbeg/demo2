package demo.demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class B extends A {
	@Test(priority=1)
      public void test2() throws IOException, InterruptedException{
       driver=setBrowser();
       Thread.sleep(2000);
		driver.get("http://www.practiceselenium.com/");
		Thread.sleep(4000);
		driver.getTitle();
		extent.startTest("Test2xx");
		System.out.println("Test 2 completedxxxxxxx ");
//		logger.log(LogStatus.PASS,"test2 is pass");	
	} 
	@Test(priority=2)
    public void test3(){
		extent.startTest("Test3");
		driver.getTitle();
		System.out.println("Test 3 completed ");
		logger.log(LogStatus.PASS,"test3 is pass");
		
	} 
	@Test(priority=3)
    public void test4(){
		extent.startTest("Test4");
		driver.getTitle();
		System.out.println("Test 4 completed ");
		logger.log(LogStatus.PASS,"test4 is pass");
		
	} 
	@AfterMethod()
	public void aftermethod()
	{
		System.out.println("After method run this");
//		extent.endTest(logger);
//		extent.flush();
	  
	}

}
