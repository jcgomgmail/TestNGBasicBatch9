package com.class4;

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

    public void onTestSkipped(ITestResult result){
        System.out.println("Finishing test case with the name: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test fail, I will report it");
    }

    public void onStart(ITestContext context){
    }

    public  void onFinish(ITestContext context){
    }
}
