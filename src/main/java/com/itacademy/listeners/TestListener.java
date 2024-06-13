package com.itacademy.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("========================================================");
        System.out.println("TEST " + result.getMethod().getMethodName() + " STARTED");
        System.out.println("========================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("========================================================");
        System.out.println("TEST " + result.getMethod().getMethodName() + " SUCCESS");
        System.out.println("========================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("========================================================");
        System.out.println("TEST " + result.getMethod().getMethodName() + " FAILED");
        System.out.println("========================================================");
    }
}
