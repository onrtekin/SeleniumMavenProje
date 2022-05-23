package demoqaexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.event.WindowEvent;

public class C08 extends TestBase {
    @Test
    public void test(){
        //1-amazona git ve ana sayfanin goruntulendigini dogrula
        driver.get("https://www.amazon.com/");
        WebElement amazonHomePage=driver.findElement(By.xpath("//html[@lang='en-us']"));
        Assert.assertTrue(amazonHomePage.isDisplayed());
        //2-arama cubunda Laptop arat ve buluna sonuc sayisini al
        WebElement sec=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(sec);
        select.selectByValue("search-alias=computers-intl-ship");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        String amazonAramaSonuYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println("Amazon icin sonuc : "+amazonAramaSonuYazisi);
        String amazonWindowHandleDegeri=driver.getWindowHandle();

        //3-Trendyol sayfasina git url i dogrula

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.trendyol.com/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.trendyol.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.findElement(By.id("Rating-Review")).click();

        //4-Arama cubuguna Laptop yazip arat buldugu sonuc sayisini al yazdir ve sayfayi kapat
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("Laptop");
        actions.sendKeys(Keys.ENTER).perform();
        String aramaSonucu=driver.findElement(By.xpath("//div[@class='dscrptn']")).getText();
        System.out.println("Trendyol icin sonuc : "+aramaSonucu);
        driver.close();

        //5-Amazon sayfasina don ve url in dogru oldugunu kontrol et

        driver.switchTo().window(amazonWindowHandleDegeri);
        String actualUrl2=driver.getCurrentUrl();
        String aranan="amazon";
        Assert.assertTrue(actualUrl2.contains(aranan));
















    }

}
