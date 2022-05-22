package demoqaexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1-https://demoqa.com/ -->git
        driver.get("https://demoqa.com/");
        //2-Ana sayfanin goruntulendigini dogrula
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        //3-Elements Click
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='card-body'])[1]")).click();
        //4-Alerts Frame butonuna tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='pr-1'])[3]")).click();
        driver.findElement(By.xpath("//*[text()='Frames']")).click();
        //5-IFrame 1 This is a sample page gorundugunu dogrula
      WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='frame1']"));
      driver.switchTo().frame(iFrame);
      WebElement page1=driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        Assert.assertTrue(page1.isDisplayed());



        //6-IFrame 2 This is a sample page gorundugunu dogrula
        driver.switchTo().defaultContent();
        actions.sendKeys(Keys.TAB).perform();
        WebElement iFrame2=driver.findElement(By.xpath("//iframe[@id='frame2']"));
        driver.switchTo().frame(iFrame2);
        WebElement page2=driver.findElement(By.xpath("//*[text()='This is a sample page']"));
        Assert.assertTrue(page2.isDisplayed());







    }

}
