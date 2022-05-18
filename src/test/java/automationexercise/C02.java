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

public class C02 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.quit();

    }
    @Test
    public void test(){
        driver.get("https://automationexercise.com");
        String expectedUrl="https://automationexercise.com/";

        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());





        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("omerfaiktekin@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("2017");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        WebElement logged=driver.findElement(By.xpath(" //*[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        WebElement delete=driver.findElement(By.xpath("(//*[text()='Delete Account'])[2]"));
        Assert.assertTrue(delete.isDisplayed());




    }









}
