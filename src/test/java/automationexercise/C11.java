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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C11 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
        driver.close();

    }

    @Test
    public void test() throws AWTException {
        /*
        1. Launch browser
2. Navigate to url 'https://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible
         */
        driver.get("https://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[1]")).click();
        Robot esp=new Robot();
        esp.keyPress(KeyEvent.VK_END);
        WebElement subscription=driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        driver.findElement(By.id("susbscribe_email")).sendKeys("omerfaik@gmail.com");
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        WebElement subs=driver.findElement(By.xpath("//div[@class='alert-success alert']"));
        Assert.assertTrue(subs.isDisplayed());




    }
}
