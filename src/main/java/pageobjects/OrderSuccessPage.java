package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPage {

    WebDriver driver;

    private final By lblPageTitle = By.cssSelector("[data-test='title']");
    private final By lblCompleteOrder = By.cssSelector("[data-test='complete-header']");
    private final By btnBackToHome = By.cssSelector("[name='back-to-products']");

    public OrderSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLblPageTitle() {
        return lblPageTitle;
    }

    public By getLblCompleteOrder() {
        return lblCompleteOrder;
    }

    public By getBtnBackToHome() {
        return btnBackToHome;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Order Success page.");
        return driver.findElement(getLblPageTitle()).getText();
    }

    public String checkStatus() {
        Log.info("Getting status in Order Success page.");
        return driver.findElement(getLblCompleteOrder()).getText();
    }

    public ProductPage goBackToHomePage() {
        driver.findElement(getBtnBackToHome()).click();
        Log.info("Clicked on Back button");
        return new ProductPage(driver);
    }
}
