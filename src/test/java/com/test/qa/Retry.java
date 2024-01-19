package com.test.qa;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int maxRetries = 3; // Maximum number of times to retry a failed test
	private int retryCount = 0; // Current retry count

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < maxRetries) {
			retryCount++;
			return true; // Retry the test
		}
		return false; // Do not retry the test

	}
	
	private String getResultStatusName(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "SUCCESS";
            case ITestResult.FAILURE:
                return "FAILURE";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "UNKNOWN";
        }
    }
	
	public class LoginTest {

//	    @Test(retryAnalyzer = RetryAnalyzer.class)
//	    public void loginTest() {
//	        // Your login test logic goes here
	        // If the test fails, the RetryAnalyzer will decide whether to retry based on the configured MAX_RETRY_COUNT
	    }
}