package org.utility.qa;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtility {
    private static ExtentReports extent;
    public static ExtentTest test;

    public static void initReport() {
    	String reportDir = System.getProperty("user.dir") + File.separator + "ExtentReport";
    	File dir = new File(reportDir);
    	if (!dir.exists()) {
    		dir.mkdirs();
    	}
    	String reportPath = reportDir + File.separator + "extent.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.config().setDocumentTitle("DevOps Pipeline Test Report");
        htmlReporter.config().setReportName("DevOps Pipeline Automation Suite");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        if (extent == null) {
            initReport();
        }
        test = extent.createTest(testName);
    }

    public static void logPass(String message) {
        if (test == null) {
            createTest("DefaultTest");
        }
        test.pass(message);
    }

    public static void logFail(String message, String screenshotPath) {
        if (test == null) {
            createTest("DefaultTest");
        }
            test.fail(message);
        
    }
    

    public static void logInfo(String message) {
        if (test == null) {
            createTest("DefaultTest");
        }
        test.info(message);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
