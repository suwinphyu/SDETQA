package common.browserfactory;

import org.openqa.selenium.By;

import java.io.File;
import java.util.List;

public interface Driver {
    public File takeScreenshot();

    public void quit();

    public void start(String browser);
}
