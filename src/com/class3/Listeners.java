package com.class3;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public void onTestStart(ITestResult result){
        System.out.println("Starting test with the name: " + result.getName());
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Test pass, we take screenshots");
    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test fail, we take screenshots");
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Finishing test with the name: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
