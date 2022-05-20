package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C13 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        /*
        1. Launch browser
2. Navigate to url 'https://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
         */
        driver.get("https://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("(//*[text()='View Product'])[2]")).click();
        WebElement productDetail=driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productDetail.isDisplayed());
        Actions actions=new Actions(driver);
        WebElement quantity=driver.findElement(By.xpath("//input[@name='quantity']"));
        actions.moveToElement(quantity).click().sendKeys(Keys.ESCAPE).sendKeys(Keys.BACK_SPACE).sendKeys("4").perform();
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        WebElement cartInfo=driver.findElement(By.id("cart_info_table"));
        Assert.assertTrue(cartInfo.isDisplayed());
        Thread.sleep(5000);

    }


}
