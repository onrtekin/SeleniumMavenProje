import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
        //1) Bu siteye gidin. ->  http://demoqa.com/text-box
        driver.get("http://demoqa.com/text-box");
        //2) Full Name kısmına "Automation" girin.
        WebElement fullName=driver.findElement(By.id("userName"));
        fullName.sendKeys("Automation");
        // 3) Email kısmına "Testing" girin.
        WebElement eMail=driver.findElement(By.id("userEmail"));
        eMail.sendKeys("testing@gmail.com");
        //4) Current Address kısmına "Testing Current Address" girin.
        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Testing Current Address");
        //5) Permanent Address kısmına "Testing Permanent Address" girin.
        WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Testing Permanent Address");
        Thread.sleep(2000);
        //6) Submit butonuna tıklayınız.
        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(2000);


    }




}
