package demoqaexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1-https://demoqa.com/ -->git
        driver.get("https://demoqa.com/");
        //2-Ana sayfanin goruntulendigini dogrula
        WebElement homePage=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());
        //2-Elements Click
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//div[@class='card-body'])[1]")).click();
        //4-Buttons -->Click
        driver.findElement(By.xpath("(//span[@class='text'])[5]")).click();
        //5-clickMe tek click yap

      driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        //6-You have done a dynamic click yazisinin goruntulendigini dogrula
        WebElement clikMeMesaj=driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        System.out.println(clikMeMesaj.getText());
        Assert.assertTrue(clikMeMesaj.isDisplayed());
        Thread.sleep(2000);

        //7-Right ClickMe butonuna Bas You have done a right click yazisinin goruntulendigini dogrula

        WebElement rightClick=driver.findElement(By.xpath("//*[text()='Right Click Me']"));
        actions.contextClick(rightClick).perform();
        WebElement rightClickMesaj=driver.findElement(By.xpath("//p[@id='rightClickMessage']"));
        Assert.assertTrue(rightClickMesaj.isDisplayed());
        Thread.sleep(2000);


        //8-Double ClickMe butonuna bas You have done a double click yazisinin goruntulendigini dogrula
        WebElement doubleClick=driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(doubleClick).perform();
        WebElement doubleClickMesaj=driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
        Assert.assertTrue(doubleClickMesaj.isDisplayed());








    }
}
