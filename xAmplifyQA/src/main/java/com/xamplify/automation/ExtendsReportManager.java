package com.xamplify.automation;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendsReportManager implements IReporter {

    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "xAmplifyqaAutomation.html", true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                ExtentTest test = extent.startTest(result.getMethod().getMethodName());

                String className = result.getTestClass().getName();
                className = className.substring(className.lastIndexOf('.') + 1);
                test.assignCategory(className);

                // Debugging: Print actual timestamps in console
                System.out.println("Test: " + result.getMethod().getMethodName());
                System.out.println("Raw Start Time (Millis): " + result.getStartMillis());
                System.out.println("Raw End Time (Millis): " + result.getEndMillis());

                // Using ZonedDateTime to properly convert time zones
                String formattedStartTime = formatTime(result.getStartMillis());
                String formattedEndTime = formatTime(result.getEndMillis());

                System.out.println("Formatted Start Time: " + formattedStartTime);
                System.out.println("Formatted End Time: " + formattedEndTime);

                // Manually setting the start and end times in Extent Reports
                test.setStartedTime(new java.util.Date(result.getStartMillis()));
                test.setEndedTime(new java.util.Date(result.getEndMillis()));

                // Logging to Extent Reports
                test.log(LogStatus.INFO, "Start Time: " + formattedStartTime);
                test.log(LogStatus.INFO, "End Time: " + formattedEndTime);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                extent.endTest(test);
            }
        }
    }

    // Proper time conversion with timezone handling
    private String formatTime(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault()); // Uses system time zone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS z");
        return zonedDateTime.format(formatter);
    }
}