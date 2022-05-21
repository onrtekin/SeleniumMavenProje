package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C15 extends TestBase {

    @Test
    public  void test() throws InterruptedException {

       // 1. Launch browser
      //  2. Navigate to url 'https://automationexercise.com'
        driver.get("https://automationexercise.com");
       // 3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
       // 5. Fill all details in Signup and create account
        Actions actions=new Actions(driver);
        for (int i = 0; i < 13; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
        actions.sendKeys("omer").sendKeys(Keys.TAB)
                .sendKeys("tfmer@gmail.com").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
      WebElement mr=driver.findElement(By.xpath("//input[@id='id_gender1']"));
      actions.moveToElement(mr).click().perform();


       actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB)
               .sendKeys("2017").sendKeys(Keys.TAB)
               .sendKeys("20").sendKeys(Keys.TAB)
               .sendKeys("08").sendKeys(Keys.TAB)
               .sendKeys("2017").sendKeys(Keys.TAB).perform();
        WebElement newsletter=driver.findElement(By.xpath("//input[@name='newsletter']"));

        actions.moveToElement(newsletter).click().perform();
        WebElement speacial= driver.findElement(By.xpath("//input[@name='optin']"));
        actions.moveToElement(speacial).click().perform();
        actions.sendKeys(Keys.TAB)
                .sendKeys("omer").sendKeys(Keys.TAB)
                .sendKeys("Faik").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Calle Campezo").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("United States").sendKeys(Keys.TAB)
                .sendKeys("Andalucia").sendKeys(Keys.TAB)
                .sendKeys("Granada").sendKeys(Keys.TAB)
                .sendKeys("78600").sendKeys(Keys.TAB)
                .sendKeys("00436665256532").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
          WebElement accountCreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
          Assert.assertTrue(accountCreated.isDisplayed());
          driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //7. Verify ' Logged in as username' at top
        WebElement logged=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(logged.isDisplayed());
        //8. Add products to cart
        for (int i = 0; i < 3; i++) {

            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        WebElement product=driver.findElement(By.xpath("//a[@data-product-id='28']"));
        actions.moveToElement(product).click().perform();
        //9. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //10. Verify that cart page is displayed
       WebElement cartPage=driver.findElement(By.xpath("//*[text()='Shopping Cart']"));
       Assert.assertTrue(cartPage.isDisplayed());
       //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //12. Verify Address Details and Review Your Order
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        //13. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hola quiero comprar esta product");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        for (int i = 0; i <12 ; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
      actions.sendKeys("omer").sendKeys(Keys.TAB)
              .sendKeys("1252126615").sendKeys(Keys.TAB)
              .sendKeys("123").sendKeys(Keys.TAB)
              .sendKeys("05").sendKeys(Keys.TAB)
              .sendKeys("2025").sendKeys(Keys.TAB).perform();
        //15. Click 'Pay and Confirm Order' button
              actions.sendKeys(Keys.ENTER).perform();
      //16. Verify success message 'Your order has been placed successfully!'



        //17-Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        //18-Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deleteAccount=driver.findElement(By.xpath("//h1[text()='Delete Account']"));
        Assert.assertTrue(deleteAccount.isDisplayed());














    }
}
