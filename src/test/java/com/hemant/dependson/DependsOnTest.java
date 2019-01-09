package com.hemant.dependson;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hemant.base.Main;

public class DependsOnTest extends Main{
	

	@BeforeMethod
	public void before(Method m) {
		logger = extent.createTest(m.getName().toString(),"Test Working of DependsOn");
		logger.assignAuthor("Hemant");
		logger.assignCategory("DependsOn");
		logger.info("Calling  DependsOn");	
	}
	
	@Test
	public void test1() {
		logger.info("Executing  Test1");	
	}
	
	@Test(dependsOnMethods= {"test1"})
	public void test2() {
		logger.info("Executing  Test2");	
	}
	
	@Test(groups= {"TestDependsOn"})
	public void test3() {
		logger.info("Executing  Test2");	
	}
	
	@Test(dependsOnGroups="TestDependsOn")
	public void test4() {
		logger.info("Executing  Test4");	
	}
	
	@AfterMethod
	public void after() {
		logger.info("Ending  DependsOn");
		extent.flush();
	}

}
