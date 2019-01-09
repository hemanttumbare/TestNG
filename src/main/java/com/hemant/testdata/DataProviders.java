package com.hemant.testdata;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="ExternalDataProvider")
	public Object[][] getObject(){
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="My";
		obj[0][1]="Name";
		obj[1][0]="is";
		obj[1][1]="Dolphin";

		return obj;
	}
}
