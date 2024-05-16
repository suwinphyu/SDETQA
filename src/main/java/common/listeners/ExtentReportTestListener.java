package common.listeners;

import com.aventstack.extentreports.ExtentReports;
import common.constants.PathConfig;
import common.logs.Log;
import common.reports.ExtentReportConfig;
import common.utils.ScreenshotReader;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentReportTestListener implements ITestListener, ISuiteListener {
    ExtentReports report;
    public static String screenShotDestinationPath;

    @Override
    public void onStart(ISuite suite) {
        report = ExtentReportConfig.initReport();
        Log.info(suite.getName() + " - test suite execution started.");
    }

    @Override
    public void onFinish(ISuite suite) {
        report.flush();
        Log.info(suite.getName() + " - test suite execution ended.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportConfig.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testDescription = result.getMethod().getDescription();
        ExtentReportConfig.getTest().pass(testDescription);
        Log.info(testDescription + " - PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testDescription = result.getMethod().getDescription();
        ExtentReportConfig.getTest().fail(result.getThrowable());
        try {
            String folderPath = PathConfig.SCREENSHOT_FOLDER + timestamp() + ".png";
            screenShotDestinationPath = folderPath;
            FileHandler.copy(ScreenshotReader.getScreenshot(), new File(folderPath));
            ExtentReportConfig.attachImage(screenShotDestinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.error(result.getName() + " - FAILED.", result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
