package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    private final By lblPageTitle = By.cssSelector("[data-test='title']");
    private final By lblFirstName = By.id("first-name");
    private final By lblLastName = By.id("last-name");
    private final By lblPostalCode = By.id("postal-code");
    private final By btnContinue = By.id("continue");
    private final By lblError = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLblPageTitle() {
        return lblPageTitle;
    }

    public By getLblFirstName() {
        return lblFirstName;
    }

    public By getLblLastName() {
        return lblLastName;
    }

    public By getLblPostalCode() {
        return lblPostalCode;
    }

    public By getBtnContinue() {
        return btnContinue;
    }

    public By getLblError() {
        return lblError;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Checkout page.");
        return driver.findElement(getLblPageTitle()).getText();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(getLblFirstName()).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(getLblLastName()).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(getLblPostalCode()).sendKeys(postalCode);
    }

    public PaymentInfoPage clickOnContinue() {
        driver.findElement(getBtnContinue()).click();
        Log.info("Clicked on Continue button");
        return new PaymentInfoPage(driver);
    }
}
