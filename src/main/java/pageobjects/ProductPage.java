package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProductPage {

    WebDriver driver;
    private final By lblHomeTitle = By.cssSelector("[data-test='title']");
    private final By dropdownSorting = By.xpath("//div[@id='header_container']/div[@class='header_secondary_container']//select[@class='product_sort_container']");
    private final By optionSorting = By.xpath("//div[@id='header_container']/div[@class='header_secondary_container']//select[@class='product_sort_container']/option[@value='hilo']");
    private final By lblHighPrice = By.cssSelector("[data-test] [data-test='inventory-item']:nth-of-type(1) [data-test='inventory-item-price']");
    private final By lblLowPrice = By.cssSelector("[data-test] [data-test='inventory-item']:nth-of-type(6) [data-test='inventory-item-price']");
    private final By addToCartItem_black = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addToCartItem_red = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By btnBurgerMenu = By.id("react-burger-menu-btn");
    private final By logoutSidebar = By.id("logout_sidebar_link");
    private final By errorMesg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLblHomeTitle() {
        return lblHomeTitle;
    }

    public By getDropdownSorting() {
        return dropdownSorting;
    }

    public By getOptionSorting() {
        return optionSorting;
    }

    public By getLblHighPrice() {
        return lblHighPrice;
    }

    public By getLblLowPrice() {
        return lblLowPrice;
    }

    public By getBtnBurgerMenu() {
        return btnBurgerMenu;
    }

    public By getLogoutSidebar() {
        return logoutSidebar;
    }

    public By getErrorMesg() {
        return errorMesg;
    }

    public By getAddToCartItem_black() {
        return addToCartItem_black;
    }

    public By getAddToCartItem_red() {
        return addToCartItem_red;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Product page.");
        return driver.findElement(getLblHomeTitle()).getText();
    }

    public void sortingPrice() {
        driver.findElement(getDropdownSorting()).click();
        driver.findElement(getOptionSorting()).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public String getHighPriceItem() {
        Log.info("Getting high price item in Product page.");
        return driver.findElement(getLblHighPrice()).getText();
    }

    public String getLowPriceItem() {
        Log.info("Getting low price item in Product page.");
        return driver.findElement(getLblLowPrice()).getText();
    }

    public void addBlackItemToCart() {
        driver.findElement(getAddToCartItem_black()).click();
    }

    public void addRedItemToCart() {
        driver.findElement(getAddToCartItem_red()).click();
    }

    public void clickNavigationMenu() {
        driver.findElement(getBtnBurgerMenu()).click();
    }

    public void clickLogoutSidebar() {
        driver.findElement(getLogoutSidebar()).click();
    }

    public String checkErrorMessage() {
        return driver.findElement(getErrorMesg()).getText().toString();
    }
}
