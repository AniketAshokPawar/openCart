package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import TestBase.BaseClass;

public class ExtentTestNGListener extends BaseClass implements ITestListener{
	 @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, "Reason: " + result.getThrowable());
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Before suite/test
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}
