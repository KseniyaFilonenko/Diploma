package com.itacademy.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("====================================");
        LOGGER.info("TEST " + result.getMethod().getMethodName() + " IS STARTED");
        LOGGER.info("====================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("====================================");
        LOGGER.info("TEST " + result.getMethod().getMethodName() + " IS SUCCESSFULLY PASSED");
        LOGGER.info("====================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("====================================");
        LOGGER.info("TEST " + result.getMethod().getMethodName() +  " IS FAILED");
        LOGGER.info("====================================");
    }
}
