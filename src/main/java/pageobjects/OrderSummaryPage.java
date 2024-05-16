package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage {

    WebDriver driver;

    private final By lblPageTitle = By.cssSelector("[data-test='title']");
    private final By item1_qty = By.xpath("//div[@id='cart_contents_container']//div[@class='cart_list']/div[3]/div[@class='cart_quantity']");
    private final By item2_qty = By.xpath("//div[@id='cart_contents_container']//div[@class='cart_list']/div[4]/div[@class='cart_quantity']");
    private final By item1_price = By.xpath("//div[@id='cart_contents_container']//div[@class='cart_list']/div[3]//div[@class='inventory_item_price']");
    private final By item2_price = By.xpath("//div[@id='cart_contents_container']//div[@class='cart_list']/div[4]//div[@class='inventory_item_price']");
    private final By btnCheckout = By.id("checkout");

    public OrderSummaryPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public By getLblPageTitle() {
        return lblPageTitle;
    }

    public By getItem1_qty() {
        return item1_qty;
    }

    public By getItem2_qty() {
        return item2_qty;
    }

    public By getItem1_price() {
        return item1_price;
    }

    public By getItem2_price() {
        return item2_price;
    }

    public By getBtnCheckout() {
        return btnCheckout;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Summary page.");
        return driver.findElement(getLblPageTitle()).getText();
    }

    public String checkItem1Qty() {
        return driver.findElement(getItem1_qty()).getText();
    }

    public String checkItem2Qty() {
        return driver.findElement(getItem2_qty()).getText();
    }

    public String checkItem1Price() {
        return driver.findElement(getItem1_price()).getText();
    }

    public String checkItem2Price() {
        return driver.findElement(getItem2_price()).getText();
    }

    public CheckoutPage clickOnCheckedOut() {
        driver.findElement(getBtnCheckout()).click();
        Log.info("Clicked on checkout button");
        return new CheckoutPage(driver);
    }
}