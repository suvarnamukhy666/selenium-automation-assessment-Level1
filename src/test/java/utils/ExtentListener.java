package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListener implements ITestListener {

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("reports/ExtentReport_" + timestamp + ".html");

        reporter.config().setReportName("AutomationExercise Test Report");
        reporter.config().setDocumentTitle("QA Automation Assessment");

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Framework", "Selenium + TestNG");
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver =
                ((BaseTest) result.getInstance()).driver;

        String screenshotPath =
                captureScreenshot(driver, result.getMethod().getMethodName());

        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        // ✅ MOST IMPORTANT FIX
        extent.flush();
    }

    private String captureScreenshot(WebDriver driver, String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path =
                "reports/screenshots/" + testName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File dest = new File(path);

        dest.getParentFile().mkdirs();

        try {
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}