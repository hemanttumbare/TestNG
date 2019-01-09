package com.hemant.attributes;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hemant.base.Main;

public class AttributesTest extends Main{
	

	@BeforeMethod
	public void before(Method m) {
		logger = extent.createTest(m.getName().toString(),"Test Working of Different Annotations");
		logger.assignAuthor("Hemant");
		logger.assignCategory("Annotations");
		logger.info("Calling  Annotations");	
	}
	
	@Test(expectedExceptions=IndexOutOfBoundsException.class)
	public void exceptionTest() {
		throw new IndexOutOfBoundsException();
	}
	
	@Test(invocationCount=3)
	public void invocationCount() {
		logger.info("Inside InvocationCOunt");
	}
	
	@Test(enabled=false)
	public void enabledTest() {
		logger.info("Inside Enabled Test");
	}
	
	@Test(priority=0)
	public void priorityTest() {
		logger.info("Inside Priority Test");
	}

	@Test(timeOut=2000)
	public void timeOutTest(){
		try {
			logger.info("Inside TimeOut");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void after() {
		logger.info("Ending  Annotations");
		extent.flush();
	}

}
