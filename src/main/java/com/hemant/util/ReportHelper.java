package com.hemant.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.hemant.base.Main;

public class ReportHelper extends Main{
	
	public static String takeScreenShot(String methodName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		String fileName = "C:\\Users\\Hemant\\UploadToGIT\\TestNGConcepts\\ScreenShots\\"+methodName+".jpg";
		//System.out.println("fileName : "+ fileName);
		
		try {
			FileUtils.copyFile(file, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
	}

}
