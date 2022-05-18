package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    /*

1) Bu siteye gidin --> http://zero.webappsecurity.com/login.html

2) Login'e "username" -- Password'a "password" yazın . Sign in button'ına tıklayınız.

3) Transfer founds butonuna tıklayınız.

4) From account kısmından herhangı bir(Random'la tıklatın) değer seçınız.

5) To account kısmından herhangı bir(Random'la tıklatın.) değer seçınız.

6) Her hangi bir amount gırınız.

7) Her hangi bir description giriniz.

8)Continue butonuna tiklayiniz.

9)Submit butonuna tiklayiniz.

10) "You successfully submitted your transaction" Yazısı gözükmesi gerekiyor.

     */
    //site artik calismiyor
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown() {
        driver.quit();

    }
    @Test
    public void test(){
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String actualUyari=driver.findElement(By.xpath("//span[@jsselect='heading']")).getText();
        String expectedUyari="Bu siteye ulaşılamıyor";
        Assert.assertEquals(expectedUyari,actualUyari);


    }

}
