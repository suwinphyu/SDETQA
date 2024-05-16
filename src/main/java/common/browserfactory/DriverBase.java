package common.browserfactory;

import org.openqa.selenium.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class DriverBase implements Driver {

    private WebDriver webDriver;
    public static WebDriver staticWebDriver;

    public static WebDriver getWebDriver() {
        return staticWebDriver;
    }

    @Override
    public File takeScreenshot() {
        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        return screenshot;
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void start(String browser) {
        webDriver = BrowserFactory.getDriverManager(browser).initDriver();
        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        staticWebDriver = webDriver;
    }
}
