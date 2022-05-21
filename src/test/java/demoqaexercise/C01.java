package demoqaexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1-https://demoqa.com/ git
        driver.get("https://demoqa.com/");
        //2-Anasayfanin goruntulendigini dogrula
        WebElement homePage=driver.findElement(By.tagName("html"));
        Assert.assertTrue(homePage.isDisplayed());

        //3-Elements Click
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//div[@class='card-body'])[1]")).click();

        //4-Upload and Download Click
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[text()='Upload and Download']")).click();
        //5-Download Click
        driver.findElement(By.id("downloadButton")).click();
        //6-Dosyanin indigini dogrula
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\sampleFile.jpeg";
        String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //7-Dosya Sec Click
        WebElement dosya=driver.findElement(By.xpath("//input[@id='uploadFile']"));
        String yuklenecekDosyaYolu="C:\\Users\\Öner\\Downloads\\sampleFile.jpeg";
        dosya.sendKeys(yuklenecekDosyaYolu);



    }
}
