package com.hemant.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hemant.base.Main;
import com.hemant.util.ReportHelper;

public class TestListener extends Main implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
	
		System.out.println("Inside Listener : ");
		logger.fail(arg0.getThrowable());
		String filePath  = ReportHelper.takeScreenShot(arg0.getMethod().getMethodName().toString()+System.currentTimeMillis(), driver);
		try {
			logger.addScreenCaptureFromPath(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
