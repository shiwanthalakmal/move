package com.vendesilk.ui.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestNgListener.class);

    private static String currentTest;
    private static ITestResult failedReult;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        failedReult = null;
        //System.out.println("[Starting] : " + getMethodName(iTestResult));
        log.info("[Starting] : " + getMethodName(iTestResult));
        currentTest = getMethodName(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("[Passed] : " + getMethodName(iTestResult));
        log.info("[Passed] : " + getMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        failedReult = iTestResult;
        //System.out.println("--- Test Failed : " + getMethodName(iTestResult));
        log.info("[Failed] : " + getMethodName(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //System.out.println("--- Test Skipped : " + getMethodName(iTestResult));
        log.info("[Skipped] : " + getMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //System.out.println("--- All Test Execution Started ---");
        log.info("----------------------------------------------");
        log.info("--------All Test Execution Started------------");
        log.info("----------------------------------------------");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //System.out.println("--- All Test Finished ---");
        log.info("----------------------------------------------");
        log.info("--------All Test Execution Finished-----------");
        log.info("----------------------------------------------");
    }

    private static String getMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public static String getCurrentTest(){
        return currentTest;
    }

    public static ITestResult getFailedReult(){
        return failedReult;
    }
}
