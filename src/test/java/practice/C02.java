package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    /*

        1) Bu siteye gidin. -> https://www.snapdeal.com/

        2) "teddy bear" aratın ve  Search butonuna tıklayın.

        3) Bu yazının göründüğünü doğrulayınız. -> (We've got 918 results for 'teddy bear')
        Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

        4) Snepdeal logosuna tıklayınız.

        5) URL'in bu olduğunu doğrulayın. (https://www.snapdeal.com/)

     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
       driver.quit();

    }
    @Test
    public void test(){
        driver.get("https://www.snapdeal.com/");
        driver.findElement(By.id("inputValEnter")).sendKeys("teddy bear");
        driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
        String actualYazi=driver.findElement(By.xpath("(//span[@class='nnn'])[1]")).getText();
        String expectedYazi="We've got 256 results for 'teddy bear'";
        Assert.assertEquals(expectedYazi,actualYazi);
        driver.findElement(By.xpath("//a[@class='notIeLogoHeader hashAdded']")).click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.snapdeal.com/";
        Assert.assertEquals(expectedUrl,actualUrl);






    }
}
