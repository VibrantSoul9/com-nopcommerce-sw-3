package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUSerShouldNavigateToCellPhonePageSuccessFully() {
        // mouse hover on "Electronics" tab
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]\"))).perform();\n"))).perform();
        // mouse hover on "Cell Phones" and click
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
        // Verify the text "Cell Phones"
        String expectedCellPhone = "Cell phones";
        String actualCellPhone = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text Matched", expectedCellPhone, actualCellPhone);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        String email = "yogmaya@gmail.com";
        // mouse hover on "Electronics"
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"))).perform();

        // mouse hover on "Cell phones" and click"
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]\")).click();\n"));

        // Verify the text "Cell Phones"
        String expectedcellphone = "Cell phones";
        String actualcellphone = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]\"));\n"));
        Assert.assertEquals("Text Mathced", expectedcellphone, actualcellphone);

        // click on list view Tab
        driver.findElement(By.xpath("//a[contains9text(),'List')]")).click();
        Thread.sleep(2000);

        // click on product name = "Nokia Lumia 1020" link
        WebElement nokiaLink = driver.findElement(By.linkText("Nokia Lumia 1020"));
        nokiaLink.click();

        // Verify the text "Nokia Lumia 1020"
        String expectednokialumia = "Nokia Lumia 1020";
        String actualnokialumia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Text Matched", expectednokialumia, actualnokialumia);

        // Verify the price "$349.00";
        String exptectednokialumiaprice = "$349.00";
        String actualnokialumiaprice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Text Matched", expectednokialumia, actualnokialumiaprice);

        // Change quantity to 2
        sendTextToElement(By.name("addtocart_20.EnterQuantity"), "2");

        // Click on "Add to cart" tab
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-20\"]")).click();

        // Verigy the message "The product has been added to your shopping cart" on top green bar
        String expectedProAdded = "The product has been added to your shopping cart";
        String actualProAdded = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Text Matched", expectedProAdded, actualProAdded);
        Thread.sleep(2000);

        // After that close the bar clicking on the cross button
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();

        // Then mousehover on "Shopping cart" and click on "Go to Cart" button
        Actions builder2 = new Actions(driver);
        builder2.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"flyout-cart\"]/div/div[4]/button")).click();
        Thread.sleep(2000);

        // Verify the message "Shopping cart"
        String expextedShoppingCart = "Shopping cart";
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text Matched", expextedShoppingCart, actualShoppingCart);

        // Verify the quatity is 2
        verifyElements("error","(2)",By.xpath("//span[contains(text(),'(2)')]"));
        Thread.sleep(2000);

        // verify the total $698.00
        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span"));
        Assert.assertEquals("Text Matched", expectedTotalPrice, actualTotalPrice);

        //Click on checkbox "I agree with the terms of service"
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[3]/label")).click();

        // click on "Checkout"
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // Verify the text "Welcome, Please Sign in!",
        String expectedSignInMessage1 = "Welcome, Please Sign In!";
        String actualSignInMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text Matched", expectedSignInMessage1, actualSignInMessage1);

        // Click on "Register" tab
        driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
        // Verifty the text "Register"
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Text Matched", expectedRegister, actualRegister);
        // Fill the mandatory fields
        // Add first name
        sendTextToElement(By.id("FirstName"), "Yogmaya");
        // Add Last name
        sendTextToElement(By.id("LastName"), "Om");
        // Add email address
        sendTextToElement(By.id("Email"), email);
        // Add Password
        sendTextToElement(By.id("Password"), "Ishwar123");
        // Confirm Password
        sendTextToElement(By.id("ConfirmPassword"), "Ishwar123");

        //Click on "Register" Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();

        // Verify the message "Your Registration completed"
        String expectedRegisterText = "Your registration completed";
        String actualRegisterText = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Text Matched", expectedRegisterText, actualRegisterText);

        // Click on "Continue" tab
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        // Verify the text "Shopping card"
        String expextedShoppingCard = "Shopping cart";
        String actualShoppingCard = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text Matched", expextedShoppingCard, actualShoppingCard);

        // click on checkbox "I agree with the terms of service"
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        // Click on "Checkout"
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //Fill the mandatory fields
        selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryID"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"999 Humanity Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "AA999ZZ");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "0987654321");

        // click on "Continue"
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        // Click on Radio button "2nd Day Air ($0.00)"
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));
        //Click on Continue
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        // Select Radio Button "Credit Card"
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        // Select "Visa" From select credit card dropdown
        selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Visa");

        // Fill all the details
        sendTextToElement(By.id("CardholderName"), "Y Om");
        sendTextToElement(By.id("CardNumber"), "1122334455667788");
        selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "12");
        selectByVisibleTextFromDropdown(By.id("ExpiryYear"), "2000");
        sendTextToElement(By.id("CardCode"), "777");

        // Click on "Continue"
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        // Verify "Payment Method" is "Credit Card"
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[2]/ul/li/span[2]"));
        Assert.assertEquals("Text Matched", expectedPaymentMethod, actualPaymentMethod);

        // Verify "Shipping Method" is "2nd Day Air"
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[2]/ul/li/span[2]"));
        Assert.assertEquals("Text Matched", expectedShippingMethod, actualShippingMethod);

        // Verify total is $698.00
        String expectedPayment1 = "$698.00";
        String actualPayment1 = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
        Assert.assertEquals(expectedPayment1, actualPayment1);

        //Click on confiem
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        // Verify the text "Thank you"
        String expectedThankYou = "Thank You";
        String actualThankYou = driver.findElement(By.xpath("//h1[contains(text(),'Thank you')]")).getText();
        Assert.assertEquals(expectedThankYou, actualThankYou);

        // Verify the message "Your order has been successfully processed!"
        String expectedMessage1 = "Your order has been successfully processed!";
        String actualMessage1 = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();
        Assert.assertEquals(expectedMessage1, actualMessage1);

        // Click on "Continue"
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        // Verify the text "Welcome to our store"
        String expectedWelcomeText1 = "Welcome to our store";
        String actualWelcomeText1 = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText();
        Assert.assertEquals(expectedWelcomeText1, actualWelcomeText1);

        // click on "Logout link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        // Verify the URL is "https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/");
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}

