package automationexercise;

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

public class C05 {
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
        driver.close();

    }
    @Test
    public void test() {
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
         */
        driver.get("http://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        WebElement newUserAccount=driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserAccount.isDisplayed());
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("omer");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("omerfaiktekin@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        WebElement emailAlready=driver.findElement(By.xpath("//p[@style='color: red;']"));
        Assert.assertTrue(emailAlready.isDisplayed());


    }
}
