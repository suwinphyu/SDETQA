package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    private final By txtUserName = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTxtUserName() {
        return txtUserName;
    }

    public By getTxtPassword() {
        return txtPassword;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterUserName(String inputUserName) {
        driver.findElement(getTxtUserName()).sendKeys(inputUserName);
    }

    public void enterPassword(String inputPassword) {
        driver.findElement(getTxtPassword()).sendKeys(inputPassword);
    }

    public LoginPage gotoUrl(String url) {
        driver.get(url);
        Log.info("Sign in with your username and password");
        return this;
    }

    public ProductPage clickOnLogin() {
        driver.findElement(getBtnLogin()).click();
        Log.info("Clicked on Login button");
        return new ProductPage(driver);
    }
}
