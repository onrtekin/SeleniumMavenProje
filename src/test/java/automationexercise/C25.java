package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C25 extends TestBase {
    @Test
    public void test(){
        /*
        1. Launch browser
2. Navigate to url 'https://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down page to bottom
5. Verify 'SUBSCRIPTION' is visible
6. Click on arrow at bottom right side to move upward
7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
         */
        driver.get("https://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        WebElement subscription=driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());

        actions.sendKeys(Keys.HOME).perform();
        WebElement test=driver.findElement(By.xpath("//*[text()='Full-Fledged practice website for Automation Engineers']"));
        Assert.assertTrue(test.isDisplayed());






    }

}
