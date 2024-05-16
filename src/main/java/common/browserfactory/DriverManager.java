package common.browserfactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

import java.io.File;

public class DriverManager {
    public static final ThreadLocal<Driver> threadlocal = new ThreadLocal<Driver>();

    public static Driver getDriver() {
        return threadlocal.get();
    }

    public static void setDriver(Driver driver) {
        threadlocal.set(driver);
    }

    public static void removeDriver() {
        threadlocal.get().quit();
        threadlocal.remove();
    }
}
