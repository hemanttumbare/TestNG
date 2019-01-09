package com.hemant.annotations;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.hemant.base.Main;
import com.hemant.util.ReportHelper;

public class SecondAnnotationTest extends Main{
	
//	ExtentTest logger;
	
	
	@BeforeMethod
	public void before() {
		logger = extent.createTest("Second Annotation Test");
		logger.assignAuthor("Hemant");
		logger.assignCategory("Functional");
		logger.info("Inside Before Method FireFox");
		System.out.println("Inside Before Method");
	}
	
	@Test(description="Simple Test2", groups= {"Dolphin"})
	public void test2() {
		driver.get("https://www.google.com");
		System.out.println("Inside test2 ");
		logger.info("Inside Test FireFox");
		//Assert.assertEquals(false, true);
		
	}

	@AfterMethod
	public void after() {
		System.out.println("Inside After Method Firefox");
		logger.info("Inside After Method FireFox");
		extent.flush();
	//	driver.close();
	}
}
