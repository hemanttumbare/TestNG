package com.hemant.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.hemant.base.Main;

public class RetryAnalyzer extends Main implements IRetryAnalyzer {

	int count = 3;
	int retry = 0;

	@Override
	public boolean retry(ITestResult arg0) {

		if (retry < count) {
			retry++;
			logger.fail(arg0.getThrowable());
			extent.flush();
			return true;
		}
		return false;
	}

}
