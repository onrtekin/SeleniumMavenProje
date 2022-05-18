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

public class C04 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() {
        driver.get("http://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();
        WebElement loginYtA=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginYtA.isDisplayed());
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("omerfaikteki@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("2017");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        WebElement loggedUserName=driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedUserName.isDisplayed());
        driver.findElement(By.xpath("//a[@style='color:brown;']")).click();
        WebElement login=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(login.isDisplayed());

    }
    @After
    public void tearDown() {
        driver.close();

    }

}
