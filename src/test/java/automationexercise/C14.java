package automationexercise;

import org.bouncycastle.asn1.cmp.KeyRecRepContent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C14 extends TestBase {

    @Test
    public void test() throws InterruptedException, AWTException {
        /*
        1. Launch browser
2. Navigate to url 'https://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
         */
        driver.get("https://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());


        Actions actions = new Actions(driver);
        for (int i = 0; i < 20; i++) {

            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        WebElement product = driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"));

        actions.moveToElement(product).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]")).click();
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        WebElement cartPage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(cartPage.isDisplayed());
        for (int i = 0; i < 6; i++) {

            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        WebElement checkout = driver.findElement(By.xpath("//a[@class='btn btn-default check_out']"));
        checkout.click();
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("omer");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("gbf@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        actions.sendKeys(Keys.TAB).sendKeys("Omer").sendKeys(Keys.TAB).sendKeys("2017")
                .perform();

        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("20");

        WebElement mounth = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMounth = new Select(mounth);
        selectMounth.selectByValue("8");

        WebElement year = driver.findElement(By.id("years"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("2017");


        actions.
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("Omer")
                .sendKeys(Keys.TAB).sendKeys("Faik")
                .sendKeys(Keys.TAB).sendKeys("Bank of Santander")
                .sendKeys(Keys.TAB).sendKeys("Safranbolu")
                .perform();
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByValue("United States");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Espana").sendKeys(Keys.TAB)
                .sendKeys("Madrid").sendKeys(Keys.TAB)
                .sendKeys("78600").sendKeys(Keys.TAB)
                .sendKeys("0555241545").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        WebElement accountCreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        WebElement logged=driver.findElement(By.xpath(" //*[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        for (int i = 0; i < 20; i++) {

            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        WebElement address=driver.findElement(By.xpath("//ul[@class='address alternate_item box']"));
        Assert.assertTrue(address.isDisplayed());
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Hola");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .perform();
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("omer");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("54561641641");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("145");
        driver.findElement(By.xpath("//input[@class='form-control card-expiry-month']")).sendKeys("05");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2025");
        driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();

        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

        WebElement delete=driver.findElement(By.tagName("h1"));
        Assert.assertTrue(delete.isDisplayed());




    }

}
