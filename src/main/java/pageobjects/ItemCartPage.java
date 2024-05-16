package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemCartPage {

    WebDriver driver;
    private final By shoppingCart = By.cssSelector("[data-test='shopping-cart-link']");
    private final By lblPageTitle = By.cssSelector("[data-test='title']");
    private final By badgeCartItem = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By btnRemove_item_black = By.cssSelector("[name='remove-sauce-labs-bolt-t-shirt']");
    private final By btnRemove_item_red = By.cssSelector("[name='remove-test\\.allthethings\\(\\)-t-shirt-\\(red\\)']");

    public ItemCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getShoppingCart() {
        return shoppingCart;
    }

    public By getLblPageTitle() {
        return lblPageTitle;
    }

    public By getBadgeCartItem() {
        return badgeCartItem;
    }

    public By getBtnRemove_item_black() {
        return btnRemove_item_black;
    }

    public By getBtnRemove_item_red() {
        return btnRemove_item_red;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Shopping Cart page.");
        return driver.findElement(getLblPageTitle()).getText();
    }

    public String getBadgeCount() {
        return driver.findElement(getBadgeCartItem()).getText().toString();
    }

    public boolean existRemoveBtn() {
        return driver.findElement(getBtnRemove_item_black()).isDisplayed()
                && driver.findElement(getBtnRemove_item_red()).isDisplayed();
    }

    public OrderSummaryPage clickOnAddToCard() {
        driver.findElement(getShoppingCart()).click();
        Log.info("Clicked on shopping cart icon");
        return new OrderSummaryPage(driver);

    }


}
