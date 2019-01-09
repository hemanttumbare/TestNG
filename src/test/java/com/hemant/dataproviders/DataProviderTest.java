package com.hemant.dataproviders;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hemant.base.Main;
import com.hemant.testdata.DataProviders;

public class DataProviderTest extends Main{
	
	@BeforeMethod
	public void before(Method m) {
	
		logger = extent.createTest(m.getName().toString(),"Test Working of Data Providers");
		logger.assignAuthor("Hemant");
		logger.assignCategory("Regression");
		logger.info("Calling  DataProvider");
		
		
	}
	
	@DataProvider(name = "SingleObject")
	public Object[] getData() {
		Object[] obj = new Object[2];
		obj[0] = "Hemant";
		obj[1] = "Tumbare";
		
		return obj;
	}
	
	@Test(dataProvider="SingleObject", groups= {"HT"})
	public void dataProviderOne(String name) {
		driver.get("https://www.google.com");
		System.out.println("Name Provided : "+ name);
		logger.info("Parameter Provided : "+name);
	}
	
	@Test(dataProvider="ExternalDataProvider",dataProviderClass=DataProviders.class, groups= {"HAT"})
	public void dataProviderTwo(String one, String two) {
		driver.get("https://www.google.com");
		System.out.println(one + " : "+two);
		logger.info(one + " : "+two);
	}
	
	@AfterMethod
	public void after() {
		logger.info("Ending  DataProvider");
		extent.flush();
	}

}
