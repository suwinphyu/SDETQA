package common.utils;

import common.browserfactory.BrowserManager;
import common.browserfactory.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;

public class ScreenshotReader{

    public static File getScreenshot(){
        return DriverManager.getDriver().takeScreenshot();
    }
}
