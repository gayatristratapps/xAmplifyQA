package com.xamplify.automation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.*;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.xamplify.util.XamplifyUtil;

public class ExtentReportManager implements ITestListener, IReporter {


	    private ExtentReports extent;
	    private String reportPath;

	    @Override
	    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	        String dailyDirPath = outputDirectory + File.separator + "ExtentReports" + File.separator + currentDate;
	        new File(dailyDirPath).mkdirs();

	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String reportFileName = "xAmplifyqaAutomation_" + timestamp + ".html";
	        this.reportPath = dailyDirPath + File.separator + reportFileName;

	        System.out.println("Extent Report will be saved at: " + reportPath);

	        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
	        spark.config().setDocumentTitle("xAmplify Automation Report");
	        spark.config().setReportName("xAmplify QA Execution");
	        spark.config().setJs(
	            "document.addEventListener(\"DOMContentLoaded\", function () {" +
	                "const dashboardCards = document.querySelectorAll(\".dashboard-view .card\");" +
	                "dashboardCards.forEach(card => {" +
	                    "const header = card.querySelector(\".card-header\");" +
	                    "if (!header) return;" +

	                    "const title = header.textContent.trim().toLowerCase();" +
	                    "console.log('Section:', title);" +

	                    // Rename 'Tags' header to 'Groups'
	                    "if (title === \"tags\") {" +
	                        "header.textContent = \"Groups\";" +
	                    "}" +

	                    "let gradient = \"\";" +

	                    "if (title.includes(\"tests\")) {" +
	                        "gradient = \"linear-gradient(to right, #4caf50, #81c784)\";" +
	                    "} else if (title.includes(\"log events\")) {" +
	                        "gradient = \"linear-gradient(to right, #2196f3, #64b5f6)\";" +
	                    "} else if (title.includes(\"timeline\")) {" +
	                        "gradient = \"linear-gradient(to right, #ab47bc, #ce93d8)\";" +
	                    "} else if (title.includes(\"tags\")) {" +
	                        "gradient = \"linear-gradient(to right, #ff9800, #ffb74d)\";" +
	                    "} else if (title.includes(\"system/environment\")) {" +
	                        "gradient = \"linear-gradient(to right, #2196f3, #64b5f6)\";" +
	                    "} else {" +
	                        "gradient = \"linear-gradient(to right, #eceff1, #f5f5f5)\";" +
	                    "}" +

	                    "header.style.background = gradient;" +
	                    "header.style.color = \"#fff\";" +
	                    "header.style.fontWeight = \"600\";" +
	                    "header.style.padding = \"10px 16px\";" +
	                    "header.style.borderRadius = \"12px 12px 0 0\";" +
	                    "header.style.fontSize = \"15px\";" +
	                    "card.style.border = \"1px solid #ddd\";" +
	                    "card.style.borderRadius = \"12px\";" +
	                    "card.style.boxShadow = \"0 1px 4px rgba(0, 0, 0, 0.1)\";" +
	                "});" +
	            "});"
	        );

	        extent = new ExtentReports();
	        extent.setReportUsesManualConfiguration(true);

	        extent.attachReporter(spark);

	        Date suiteStart = null;
	        Date suiteEnd = null;

	        int passed = 0, failed = 0, skipped = 0;

	        for (ISuite suite : suites) {
	            Map<String, ISuiteResult> results = suite.getResults();
	            for (ISuiteResult result : results.values()) {
	                ITestContext context = result.getTestContext();

	                passed += context.getPassedTests().size();
	                failed += context.getFailedTests().size();
	                skipped += context.getSkippedTests().size();

	                if (suiteStart == null || context.getStartDate().before(suiteStart)) {
	                    suiteStart = context.getStartDate();
	                }
	                if (suiteEnd == null || context.getEndDate().after(suiteEnd)) {
	                    suiteEnd = context.getEndDate();
	                }

	                buildTestNodes(context.getPassedTests(), Status.PASS);
	                buildTestNodes(context.getFailedTests(), Status.FAIL);
	                buildTestNodes(context.getSkippedTests(), Status.SKIP);
	            }
	        }

	        String duration = "";
	        if (suiteStart != null && suiteEnd != null) {
	            extent.setSystemInfo("Execution Start Time", formatTime(suiteStart.getTime()));
	            extent.setSystemInfo("Execution End Time", formatTime(suiteEnd.getTime()));

	            long durationMillis = suiteEnd.getTime() - suiteStart.getTime();
	            long seconds = (durationMillis / 1000) % 60;
	            long minutes = (durationMillis / (1000 * 60)) % 60;
	            long hours = (durationMillis / (1000 * 60 * 60));

	            duration = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	            extent.setSystemInfo("Execution Duration", duration);
	        }

	        extent.flush();
	        System.out.println("✅ Extent report generated at: " + reportPath);

	        File reportFile = new File(reportPath);
	        if (reportFile.exists()) {
	            String executionDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

	            String body = String.format(
	                "Hello Team,\n\n" +
	                "Please find attached the automation test execution report for the latest run.\n\n" +
	                "📊 Summary:\n" +
	                "- ✅ Tests Passed: %d\n" +
	                "- ❌ Tests Failed: %d\n" +
	                "- ⚠️ Tests Skipped: %d\n\n" +
	                "📝 Execution Type: %s\n" +
	                "📅 Execution Date: %s\n" +
	                "⏱️ Duration: %s\n\n" +
	                "You can open the attached HTML report in your browser to view detailed test steps, logs, and screenshots (if any).\n\n" +
	                "Regards,\n" +
	                "QA Automation\n" +
	                "xAmplify QA Team",
	                passed, failed, skipped, "Manual Execution", executionDate, duration
	            );

	            XamplifyUtil.sendReport(
	                "agayatri@stratapps.com, gayatri@xamplify.com",
	                "📋 xAmplify Automation Test Report - Manual Execution",
	                body,
	                reportFile,
	                "Manual Execution",
	                passed,
	                failed,
	                skipped
	            );

	            System.out.println("✅ Report emailed successfully.");
	        } else {
	            System.err.println("❌ Report file not found. Email not sent.");
	        }
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println("onFinish executed. Report will be sent from generateReport().");
	    }

	    @Override public void onTestStart(ITestResult result) {}
	    @Override public void onTestSuccess(ITestResult result) {}
	    @Override public void onTestFailure(ITestResult result) {}
	    @Override public void onTestSkipped(ITestResult result) {}
	    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
	    @Override public void onTestFailedWithTimeout(ITestResult result) {}
	    @Override public void onStart(ITestContext context) {}

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
	                    Throwable throwable = result.getThrowable();
	                    test.log(status, throwable);

	                    String message = throwable.getMessage();
	                    if (message != null && message.contains("expected") && message.contains("but found")) {
	                        test.log(Status.INFO, MarkupHelper.createLabel("🔎 Assertion Difference", ExtentColor.YELLOW));
	                        test.log(Status.INFO, MarkupHelper.createCodeBlock(message));
	                    } else if (message != null) {
	                        test.log(Status.INFO, "🔎 Error: " + message);
	                    }
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
