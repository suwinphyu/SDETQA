package testcases;

import based.TestBase;
import common.reports.ExtentReportConfig;
import common.utils.JsonFileReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

public class TestScenario extends TestBase {


    String actualPageTitle;
    String expectedPageTitle;
    Robot robot = new Robot();

    public TestScenario() throws AWTException {
    }

    public void pageScrollDown() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(1000);
    }

    public void pageScrollUp() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        Thread.sleep(1000);
    }

    @DataProvider(name = "credentials")
    public Object[] getData() {
        String dataFilePath = System.getProperty("user.dir") + "/src/test/resources/TestData.json";
        return JsonFileReader.readFile(dataFilePath);
    }


    @Test(priority = 1)
    public void Launch_URL_Success() {
        expectedPageTitle = "Swag Labs";

        ExtentReportConfig.pass("Navigate to Test URL");
        actualPageTitle = loginPage.getPageTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        ExtentReportConfig.pass("Check page title is correct");
    }


    @Test(dataProvider = "credentials", priority = 2)
    public void Login_ValidCredentials_Success(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "Products";

        loginPage.enterUserName(map.get("username").toString());
        ExtentReportConfig.pass("Login with username as " + map.get("username").toString());

        loginPage.enterPassword(map.get("password").toString());
        ExtentReportConfig.pass("Login with password as " + map.get("password").toString());

        ExtentReportConfig.pass("Login with valid credentials by clicking on LOGIN button");
        productPage = loginPage.clickOnLogin();
        Thread.sleep(1000);

        actualPageTitle = productPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        ExtentReportConfig.pass("Login success and redirect to Product page ");
    }


    @Test(dataProvider = "credentials", priority = 3)
    public void Sorting_Price_HighToLow_Success(Map<String, Object> map) {

        ExtentReportConfig.pass("Select sorting dropdown by choosing - Price(High to Low)");
        productPage.sortingPrice();

        String actualHighPrice = productPage.getHighPriceItem();
        Assert.assertEquals(map.get("high_price_item_sorting").toString(), actualHighPrice);
        ExtentReportConfig.pass("Checked High price item after sorting");

        String actualLowPrice = productPage.getLowPriceItem();
        Assert.assertEquals(map.get("low_price_item_sorting").toString(), actualLowPrice);
        ExtentReportConfig.pass("Checked Low price item after sorting");
    }


    @Test(dataProvider = "credentials", priority = 4)
    public void AddToCart_PriceWith1599_Success(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "Your Cart";
        pageScrollDown();

        ExtentReportConfig.pass("Add 2 items which has $15.99 price to cart");
        productPage.addBlackItemToCart();
        Thread.sleep(1000);

        productPage.addRedItemToCart();
        Thread.sleep(1000);

        ExtentReportConfig.pass("Check \"Add To Cart\" button");
        Assert.assertTrue(itemCartPage.existRemoveBtn());
        ExtentReportConfig.pass(" \"Add To Cart\" button is changed to \"Remove\" button after adding item to shopping cart");

        int itemCount = 2; // black and red which has $15.99 price
        int actualAddToCart = Integer.parseInt(itemCartPage.getBadgeCount());
        Assert.assertEquals(itemCount, actualAddToCart);
        ExtentReportConfig.pass("2 items badgeCount is shown in shopping card");

        ExtentReportConfig.pass("Click on shopping cart");
        orderSummaryPage = itemCartPage.clickOnAddToCard();
        Thread.sleep(1000);
        actualPageTitle = orderSummaryPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        ExtentReportConfig.pass("Items are added and redirect to Order Summary Page");

    }

    @Test(dataProvider = "credentials", priority = 5)
    public void Verify_OrderSummary_Success(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "Checkout: Your Information";
        int expectedQty = 1;
        String expectedPrice = "$15.99";

        ExtentReportConfig.pass("Check quantity(QTY) in order summary");
        //Item 1
        int actualQty = Integer.parseInt(orderSummaryPage.checkItem1Qty());
        Assert.assertEquals(expectedQty, actualQty);
        ExtentReportConfig.pass("Item1 QTY count is correct as " + actualQty);
        String actualPrice = orderSummaryPage.checkItem1Price();
        Assert.assertEquals(expectedPrice, actualPrice);
        ExtentReportConfig.pass("Item 1 Price is correct as " + actualPrice);

        //Item 2
        actualQty = Integer.parseInt(orderSummaryPage.checkItem2Qty());
        Assert.assertEquals(expectedQty, actualQty);
        ExtentReportConfig.pass("Item2 QTY count is correct as " + actualQty);
        actualPrice = orderSummaryPage.checkItem2Price();
        Assert.assertEquals(expectedPrice, actualPrice);
        ExtentReportConfig.pass("Item 2 Price is correct as " + actualPrice);

        pageScrollDown();
        checkoutPage = orderSummaryPage.clickOnCheckedOut();
        ExtentReportConfig.pass("Click on CHECKOUT button");
        Thread.sleep(1000);
        actualPageTitle = orderSummaryPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        ExtentReportConfig.pass("Order summary info is correct and redirect to Checkout Page");

    }

    @Test(dataProvider = "credentials", priority = 6)
    public void Checkout_With_ValidPaymentInfo_Success(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "Checkout: Overview";

        pageScrollUp();
        ExtentReportConfig.pass("Enter valid payment information");
        checkoutPage.enterFirstName(map.get("firstname").toString());
        ExtentReportConfig.pass("Enter first name as " + map.get("firstname").toString());

        checkoutPage.enterLastName(map.get("lastname").toString());
        ExtentReportConfig.pass("Enter last name as " + map.get("lastname").toString());

        checkoutPage.enterPostalCode(map.get("postal_code").toString());
        ExtentReportConfig.pass("Enter postal code as " + map.get("postal_code").toString());

        pageScrollDown();
        paymentInfoPage = checkoutPage.clickOnContinue();
        ExtentReportConfig.pass("Click on CONTINUE button");
        Thread.sleep(1000);

        actualPageTitle = paymentInfoPage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        ExtentReportConfig.pass("Payment information is entered successfully and redirect to paymentInfo page");
    }

    @Test(dataProvider = "credentials", priority = 7)
    public void Verify_PaymentInfo_in_CheckOutOverviewPage_Success(Map<String, Object> map) throws InterruptedException {
        expectedPageTitle = "Checkout: Complete!";
        String expectedPaymentInfo = "SauceCard #31337";
        String expectedShippingInfo = "Free Pony Express Delivery!";
        String expectedOrderMesg = "Thank you for your order!";

        ExtentReportConfig.pass("Check Payment Information");
        Assert.assertEquals(expectedPaymentInfo, paymentInfoPage.getPaymentInfo());
        ExtentReportConfig.pass("Payment Information as - " + paymentInfoPage.getPaymentInfo());

        ExtentReportConfig.pass("Check Shipping Information");
        Assert.assertEquals(expectedShippingInfo, paymentInfoPage.getShippingInfo());
        ExtentReportConfig.pass("Shipping Information as -" + paymentInfoPage.getShippingInfo());

        ExtentReportConfig.pass("Check SubTotal amount");
        Assert.assertEquals((map.get("subtotal").toString()), paymentInfoPage.getItemSubTotal());
        ExtentReportConfig.pass("SubTotal as - " + paymentInfoPage.getItemSubTotal());

        ExtentReportConfig.pass("Check Tax");
        Assert.assertEquals((map.get("tax").toString()), paymentInfoPage.getTax());
        ExtentReportConfig.pass("Tax as -" + paymentInfoPage.getTax());

        ExtentReportConfig.pass("Check Total Amount");
        Assert.assertEquals((map.get("total_amount").toString()), paymentInfoPage.getTotalAmt());
        ExtentReportConfig.pass("Total Amount - " + paymentInfoPage.getTotalAmt());

        orderSuccessPage = paymentInfoPage.clickOnFinish();
        Assert.assertEquals(expectedPageTitle, orderSuccessPage.getPageTitle());
        ExtentReportConfig.pass("Click on FINISH button and redirect to Order Success Page");

        Assert.assertEquals(expectedOrderMesg, orderSuccessPage.checkStatus());
        ExtentReportConfig.pass("Check order completed message is correct");

        productPage = orderSuccessPage.goBackToHomePage();
        ExtentReportConfig.pass("Product page is redirected by clicking on \"Back To Home\" button ");
    }

    @Test(dataProvider = "credentials", priority = 8)
    public void Verify_Logout_Success(Map<String, Object> map) throws InterruptedException {
        productPage.clickNavigationMenu();
        productPage.clickLogoutSidebar();
        ExtentReportConfig.pass("Click on Logout from navigation menu");
    }

    @Test(dataProvider = "credentials", priority = 9)
    public void Login_With_LockedUserCredentials_Error(Map<String, Object> map) throws InterruptedException {
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";

        loginPage.enterUserName(map.get("locked_username").toString());
        ExtentReportConfig.pass("Login with username as " + map.get("locked_username").toString());

        loginPage.enterPassword(map.get("locked_password").toString());
        ExtentReportConfig.pass("Login with password as " + map.get("locked_password").toString());

        ExtentReportConfig.pass("Login with invalid credentials");
        productPage = loginPage.clickOnLogin();
        Thread.sleep(1000);
        ExtentReportConfig.pass("Click on LOGIN button");

        String actualError = productPage.checkErrorMessage();
        Assert.assertEquals(expectedError, actualError);
        ExtentReportConfig.pass("Error message is alerted by doing login with locked_out_user");
    }


}
