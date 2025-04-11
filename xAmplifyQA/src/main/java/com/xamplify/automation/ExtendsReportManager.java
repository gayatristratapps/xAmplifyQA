package com.xamplify.automation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.*;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendsReportManager implements IReporter {

    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        // Create date-based folder under ExtentReports
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dailyDirPath = outputDirectory + File.separator + "ExtentReports" + File.separator + currentDate;
        new File(dailyDirPath).mkdirs();  // Ensure the daily folder is created

        // Generate timestamped report filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportFileName = "xAmplifyqaAutomation_" + timestamp + ".html";
        String reportPath = dailyDirPath + File.separator + reportFileName;

        System.out.println("Extent Report will be saved at: " + reportPath); // Debug

        // Spark reporter setup
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("xAmplify Automation Report");
        spark.config().setReportName("xAmplify QA Execution");

        // Attach reporter to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Build test results
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();

            for (ISuiteResult result : results.values()) {
                ITestContext context = result.getTestContext();

                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        // Flush report
        extent.flush();
        System.out.println("✅ Extent report generated at: " + reportPath);
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                String testName = result.getMethod().getMethodName();

                ExtentTest test = extent.createTest(testName)
                        .assignCategory(result.getTestClass().getName());

                test.getModel().setStartTime(new Date(result.getStartMillis()));
                test.getModel().setEndTime(new Date(result.getEndMillis()));

                test.log(Status.INFO, "Start Time: " + formatTime(result.getStartMillis()));
                test.log(Status.INFO, "End Time: " + formatTime(result.getEndMillis()));

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
            }
        }
    }

    private String formatTime(long millis) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z").format(new Date(millis));
    }
}
