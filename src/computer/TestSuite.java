package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {
    /*
    Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Click on Computer Menu.
1.2 Click on Desktop
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
     */

    static String baseUrl = "https://demo.nopcommerce.com/";

@Before
    public void setUp() {
    openBrowser(baseUrl);
}

@Test
public void verigyProductArrangedInAlphabeticalOrder() {
    // click on computer menu
    clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

    // Click on Desktop
    clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

    // Select sort by position "Name: "Z to A"
    selectByVisibleTextFromDropdown(By.name("products-orderby"),"Name: Z to A");

    // Verify the product will arrange in Descending order
    verifyElements("error", "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));
}

@Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

    // click on computer Menu
    clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

    // click on Desktop
    clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

    // click on a to z
    clickOnElement(By.xpath(" //option[contains(text(),'Name: A to Z')]"));
    Thread.sleep(1000);

    // click on "Add to cart"
    clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

    // Verify the text "Build your own computer"
    verifyElements("error","Build your own computer",By.xpath("//h1[contains(text(),'Build your own computer')]"));

    // select "2.2 GHz Intel Pentium Dual-Core E2200 using Select class
    selectByVisibleTextFromDropdown(By.id("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");

    // Select "8GB [+$60.00]" using Select class
    selectByVisibleTextFromDropdown(By.id("product_attribute_2"),"8GB [+$60.00]");

    //Select HDD radio "400 GB [_$100.00]"
    driver.findElement(By.xpath("//*[@id=\"product_attribute_input_3\"]/ul/li[2]/label")).click();

    // Select OS radio "Vista Premium[+$60.00]"
    driver.findElement(By.xpath("//*[@id=\"product_attribute_input_4\"]/ul/li[2]/label")).click();

    // check two check boxed "Microsoft Office [+$50.00]" and "Total Commander
    driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();
    Thread.sleep(3000);

    // Verify the price "$1,475.00"
    String expectedPrice = "$1475.00";
    String actualPrice = getTextFromElement(By.xpath("//*[@id=\"price-value-1\"]"));
    Assert.assertEquals("Text Matched", expectedPrice, actualPrice);

    // click on "Add to Card Button
    driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-1\"]")).click();

    // Verify the message "The product has been added to your shopping cart" on top green bar
    String expectedText = "The product has been added to your shopping cart";
    String actualText = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
    Assert.assertEquals("Text Matched", expectedText, actualText);

    // After that close the bar clicking on the cross button
    driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();

    // Then mouseHover on "Shopping Cart" and Click on "Go To Cart" Button
    Actions builder = new Actions(driver);
    builder.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).perform();
    driver.findElement(By.xpath("//*[@id=\"flyout-cart\"]/div/div[4]/button")).click();
    Thread.sleep(2000);

    // Verify the message "Shopping Cart"
    String expectedShoppingCart = "Shopping cart";
    String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
    Assert.assertEquals("Text Matched", expectedShoppingCart, actualShoppingCart);

    // Change the qty to "2"
    WebElement quantity= driver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
    quantity.clear();
    quantity.sendKeys("2");
    Thread.sleep(2000);

    // Click on "Update shopping cart"
    driver.findElement(By.xpath("//*[@id=\"updatecart\"]")).click();
    Thread.sleep(2000);

    // Verify the Total"$2950.00"
    String expectedTotal = "$2950.00";
    String actualTotal = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong"));
    Assert.assertEquals("Text Matched", expectedTotal, actualTotal);

    // click on checkbox "I agree with the terms of service"
    driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();

    // click on "Checkout"
    clickOnElement(By.id("checkout"));

    // verify the text "Welcome,Please Sign In!"
    verifyElements("error","Welcome, Please Sign In!",By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

    // Click on "CHECKOUT AS GUEST2 Tab
    clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

    //Fill all the mandatory field
    // Add First name
    sendTextToElement(By.id("BillingNewAddress_FirstName"), "Yogmaya");
    // Add Last name
    sendTextToElement(By.id("BillingNewAddress_LastName"), "Om");
    // Add Email address
    sendTextToElement(By.id("BillingNewAddress_Email"), "Yogmaya1@gmail.com");
    // Add Company
    sendTextToElement(By.id("BillingNewAddress_Company"),"SC Limited");
    // Select country
    selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"),"United Kingdom");
    // Add city
    sendTextToElement(By.id("BillingNewAddress_City"), "London");
    // Add Address1
    sendTextToElement(By.id("BillingNewAddress_Address1"), "Harrow");
    // Add zipcode
    sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "123456");
    // Add Phonenumber
    sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/input[1]\n"),
            "1234567890");

    // Click on Continue
    driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]")).click();

    // click on radio button "Next Day Air($0.00)"
    driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]")).click();

    // Click on "Continue"
    driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")).click();

    // click on "Confirm"
    driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();

    // Verify the Text "Thank you"
    String expectedThanks = "Thank You";
    String actualThanks = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
    Assert.assertEquals("Text Matched", expectedThanks, actualThanks);

    // Verify the message "Your order has been successfully processed!"
    String expectedOrderMessage = "Your order has been successfully processed!";
    String actualOrderMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
    Assert.assertEquals("Text Matched", expectedOrderMessage, actualOrderMessage);

    // Click on "Continue"
    driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

    // Verify the text "Welcome to our store"
    String expectedWelcomeMessage = "Welcome to our store";
    String actualWelcomeMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
    Assert.assertEquals("Text Matched", expectedWelcomeMessage, actualWelcomeMessage);
}
@After
public void tearDown() {

    closeBrowser();
    }
}










/*
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Click on Computer Menu.
2.2 Click on Desktop
2.3 Select Sort By position "Name: A to Z"
2.4 Click on "Add To Cart"
2.5 Verify the Text "Build your own computer"
2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
2.7.Select "8GB [+$60.00]" using Select class.
2.8 Select HDD radio "400 GB [+$100.00]"
2.9 Select OS radio "Vista Premium [+$60.00]"
2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
[+$5.00]"
2.11 Verify the price "$1,475.00"
2.12 Click on "ADD TO CARD" Button.
2.13 Verify the Message "The product has been added to your shopping cart" on Top
green Bar
After that close the bar clicking on the cross button.
2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
2.15 Verify the message "Shopping cart"
2.16 Change the Qty to "2" and Click on "Update shopping cart"
2.17 Verify the Total"$2,950.00"
2.18 click on checkbox “I agree with the terms of service”
2.19 Click on “CHECKOUT”
2.20 Verify the Text “Welcome, Please Sign In!”
2.21Click on “CHECKOUT AS GUEST” Tab
2.22 Fill the all mandatory field
2.23 Click on “CONTINUE”
2.24 Click on Radio Button “Next Day Air($0.00)”
2.25 Click on “CONTINUE”
2.26 Select Radio Button “Credit Card”
2.27 Select “Master card” From Select credit card dropdown
2.28 Fill all the details
2.29 Click on “CONTINUE”
2.30 Verify “Payment Method” is “Credit Card”
2.32 Verify “Shipping Method” is “Next Day Air”
2.33 Verify Total is “$2,950.00”
2.34 Click on “CONFIRM”
2.35 Verify the Text “Thank You”
2.36 Verify the message “Your order has been successfully processed!”
2.37 Click on “CONTINUE”
2.37 Verify the text “Welcome to our store”
 */