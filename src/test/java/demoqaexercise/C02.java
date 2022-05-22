package demoqaexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void test(){
        //1-https://demoqa.com/ -->git
        driver.get("https://demoqa.com/");
        //2-Elements Click
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//div[@class='card-body'])[1]")).click();
        //3-textBox Click
        driver.findElement(By.xpath("//*[text()='Text Box']")).click();
        //4-Formu doldur

        actions.sendKeys(Keys.TAB).sendKeys("Omer")
                .sendKeys(Keys.TAB).sendKeys("omer@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("Safranbolu")
                .sendKeys(Keys.TAB).sendKeys("Granada")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //5-Bilgilerin girildigini yazdir ve dogrula
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement bilgiler=driver.findElement(By.xpath("//div[@class='mt-4 row']"));
        System.out.println(bilgiler.getText());
        Assert.assertTrue(bilgiler.isDisplayed());


    }
}
