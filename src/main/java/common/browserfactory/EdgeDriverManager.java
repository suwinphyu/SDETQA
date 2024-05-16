package common.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager implements BrowserManager {
    @Override
    public WebDriver initDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
