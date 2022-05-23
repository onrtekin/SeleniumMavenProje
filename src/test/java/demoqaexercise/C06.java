package demoqaexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06 extends TestBase {
    @Test
    public void test(){
        //1-https://demoqa.com/  adrese git
        driver.get("https://demoqa.com/ ");

        //2-Elements Click
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[1]")).click();

        //3-Web Tables Click
        driver.findElement(By.xpath("(//li[@id='item-3'])[1]")).click();

        //4-Web Tables sayfasina gidildigini dogrula
        WebElement page =driver.findElement(By.className("main-header"));
        Assert.assertTrue(page.isDisplayed());
         //5-Add butonuna ve gelecek formu doldurunuz VE ONAYLAYİNİZ

        driver.findElement(By.id("addNewRecordButton")).click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Omer Faik").sendKeys(Keys.TAB)
                .sendKeys("Tekin").sendKeys(Keys.TAB)
                .sendKeys("omerfaik@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("5").sendKeys(Keys.TAB)
                .sendKeys("5000").sendKeys(Keys.TAB)
                .sendKeys("IT").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //6-Arama cubuguna kaydettiginiz adi girerek mouse ile arama tusuna click yapiniz
        driver.findElement(By.xpath("//input[@placeholder='Type to search']")).sendKeys("Omer Faik");
        WebElement arama=driver.findElement(By.id("basic-addon2"));
        actions.moveToElement(arama).click().perform();
        //7-Arama sayfasinin sonucunda adinizin goruntulendigini dogrulayininz
        WebElement ad=driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[1]"));
        Assert.assertTrue(ad.isDisplayed());
        //8- salary kismina girdidiniz rakami degistiriniz
        driver.findElement(By.xpath("//span[@class='mr-2']")).click();
        for (int i = 0; i <6 ; i++) {
            actions.sendKeys(Keys.TAB).perform();

        }
       actions.sendKeys("10000").perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //9-Delete butonuna basarak siliniz
        driver.findElement(By.id("delete-record-4")).click();
        //10-ekranda No rows found yazisinin goruntulendigini dogrula
        WebElement noRowsFound=driver.findElement(By.className("rt-noData"));
        Assert.assertTrue(noRowsFound.isDisplayed());









    }

}
