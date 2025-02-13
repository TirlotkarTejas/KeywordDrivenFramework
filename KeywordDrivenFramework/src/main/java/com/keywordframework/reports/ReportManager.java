package com.keywordframework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
	
	private static ExtentReports extent;
    private static ExtentTest test;

    public static void initializeReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.log(Status.INFO, message);
    }

    public static void logPass(String message) {
        test.log(Status.PASS, message);
        extent.flush();
    }

    public static void logFail(String message) {
        test.log(Status.FAIL, message);
    }

    public static void finalizeReport() {
        extent.flush();
    }

}
