package com.xamplify.automation;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
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
                // Create test entry in the report
                ExtentTest test = extent.startTest(result.getMethod().getMethodName());

                // Get the simple class name (without package name)
                String className = result.getTestClass().getName();
                className = className.substring(className.lastIndexOf('.') + 1); // Removes package prefix

                // Assign category only with class name
                test.assignCategory(className);

                // Add execution timestamps
                test.log(LogStatus.INFO, "Start Time: " + getTime(result.getStartMillis()));
                test.log(LogStatus.INFO, "End Time: " + getTime(result.getEndMillis()));

                // Log test status with exception details if any
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
