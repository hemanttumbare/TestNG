package com.hemant.annotations;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.hemant.base.Main;
import com.hemant.util.ReportHelper;

public class AnnotationsTest extends Main{
	
	//ExtentTest logger;
	
	@BeforeMethod
	public void before() {
		logger = extent.createTest("Firs Annotations Tests");
		logger.assignAuthor("Hemant");
		logger.assignCategory("Smoke");
		logger.info("Executing Before Method Chrome ");
		System.out.println("Inside Before Method Chrome");
	}
	
	@Test(description="Simple Test1",groups= {"Dolphin"})
	public void test() {
		driver.get("https://www.google.com");
		logger.info("Executing Test Chrome");
		System.out.println("Inside Test Chrome");
		//Assert.fail();
	}
	
	@AfterMethod
	public void after() {
		logger.info("Executing After Method Chrome");
		logger.pass("CHeck this");
		extent.flush();
		//driver.close();
		System.out.println("Inside After Method Chrome");
	}
	
	
}
