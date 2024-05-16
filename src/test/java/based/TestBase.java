package based;

import common.browserfactory.BrowserFactory;
import common.browserfactory.Driver;
import common.browserfactory.DriverBase;
import common.browserfactory.DriverManager;
import common.constants.PathConfig;
import common.utils.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageobjects.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver webDriver;
    Driver driver;
    String url = PropertyFileReader.readFile(PathConfig.URL_CONFIG).get("rootUrl").toString();
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected ItemCartPage itemCartPage;
    protected OrderSummaryPage orderSummaryPage;
    protected CheckoutPage checkoutPage;
    protected PaymentInfoPage paymentInfoPage;
    protected OrderSuccessPage orderSuccessPage;

    @Parameters({"browser"})
    @BeforeClass
    public void testSetup(String browserParam) {
        driver = new DriverBase();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().start(browserParam);
        webDriver = DriverBase.getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageObjectSetup();
    }


    @AfterClass
    public void testCleanup() {
        if (DriverManager.getDriver() != null) {
            DriverManager.removeDriver();
        }
    }

    void pageObjectSetup() {
        loginPage = new LoginPage(webDriver);
        productPage = new ProductPage(webDriver);
        itemCartPage = new ItemCartPage(webDriver);
        orderSummaryPage = new OrderSummaryPage(webDriver);
        checkoutPage = new CheckoutPage(webDriver);
        paymentInfoPage = new PaymentInfoPage(webDriver);
        orderSuccessPage = new OrderSuccessPage(webDriver);
    }
}
