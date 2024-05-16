package pageobjects;

import common.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentInfoPage {

    WebDriver driver;

    private final By lblPageTitle = By.cssSelector("[data-test='title']");
    private final By lblPaymentInfo = By.xpath("/html//div[@id='checkout_summary_container']//div[@class='summary_info']/div[2]");
    private final By lblShoppingInfo = By.xpath("/html//div[@id='checkout_summary_container']//div[@class='summary_info']/div[4]");
    private final By lblSubtotal = By.xpath("/html//div[@id='checkout_summary_container']//div[@class='summary_subtotal_label']");
    private final By lblTax = By.xpath("/html//div[@id='checkout_summary_container']//div[@class='summary_tax_label']");
    private final By lblTotalAmt = By.xpath("/html//div[@id='checkout_summary_container']//div[@class='summary_total_label']");
    private final By btnFinish = By.id("finish");


    public PaymentInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLblPageTitle() {
        return lblPageTitle;
    }

    public By getLblPaymentInfo() {
        return lblPaymentInfo;
    }

    public By getLblShoppingInfo() {
        return lblShoppingInfo;
    }

    public By getLblSubtotal() {
        return lblSubtotal;
    }

    public By getLblTax() {
        return lblTax;
    }

    public By getLblTotalAmt() {
        return lblTotalAmt;
    }

    public By getBtnFinish() {
        return btnFinish;
    }

    public String getPageTitle() {
        Log.info("Getting page title in Checkout page.");
        return driver.findElement(getLblPageTitle()).getText();
    }

    public String getPaymentInfo() {
        Log.info("Getting payment information in PaymentInfo page.");
        return driver.findElement(getLblPaymentInfo()).getText();
    }

    public String getShippingInfo() {
        Log.info("Getting shipping information in PaymentInfo page.");
        return driver.findElement(getLblShoppingInfo()).getText().toString();
    }

    public String getItemSubTotal() {
        Log.info("Getting item total in PaymentInfo page.");
        return driver.findElement(getLblSubtotal()).getText().toString();
    }

    public String getTax() {
        Log.info("Getting tax in PaymentInfo page.");
        return driver.findElement(getLblTax()).getText().toString();
    }

    public String getTotalAmt() {
        Log.info("Getting total amount in PaymentInfo page.");
        return driver.findElement(getLblTotalAmt()).getText().toString();
    }

    public OrderSuccessPage clickOnFinish() {
        driver.findElement(getBtnFinish()).click();
        Log.info("Clicked on Finish button");
        return new OrderSuccessPage(driver);
    }
}
