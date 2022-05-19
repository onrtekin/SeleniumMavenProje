package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.io.File;
import java.time.Duration;

public class C12 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    public void test(){
        /*
        1. Launch browser
2. Navigate to url 'https://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
         */
        driver.get("https://automationexercise.com");
        WebElement homePage= driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
      driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
      WebElement productTwo=driver.findElement(By.xpath("//a[@data-product-id='2']"));
      Actions act=new Actions(driver);
      act.click(productTwo).perform();
      driver.findElement(By.xpath("//*[text()='View Cart']")).click();
      WebElement addedToCart=driver.findElement(By.xpath("//tbody"));
      Assert.assertTrue(addedToCart.isDisplayed());

    }
}
