import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
        1) Bu siteye gidin. ->  http://demoqa.com/text-box
        2) Full Name kısmına "Automation" girin.
        3) Email kısmına "Testing" girin.
        4) Current Address kısmına "Testing Current Address" girin.
        5) Permanent Address kısmına "Testing Permanent Address" girin.
        6) Submit butonuna tıklayınız.
        7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
        8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın

    */
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
       // driver.close();

    }
    @Test
    public void test() throws InterruptedException {
        driver.get("http://demoqa.com/text-box");

        Thread.sleep(1000);

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Automation");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("name@example.com");

        WebElement cAddress = driver.findElement(By.id("currentAddress"));
        cAddress.sendKeys("Testing Current Address");

        WebElement pAddress = driver.findElement(By.id("permanentAddress"));
        pAddress.sendKeys("Testing Permanent Address");

        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement name2 = driver.findElement(By.id("name"));
        String name2txt = name2.getText();

        WebElement email2 = driver.findElement(By.id("email"));
        String email2txt = email2.getText();


        Assert.assertEquals("Name:Automation", name2txt);
        Assert.assertEquals("Email:name@example.com", email2txt);
        driver.quit();

    }




}
