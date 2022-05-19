package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test(){
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
         */
        driver.get("http://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
        WebElement getInTouch=driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());
        driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("omer");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("omerfaiktekin@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Hola");
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Soy Omer,Quiero haablar  una persona, porfavor me ayuda.");
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
        driver.switchTo().alert().accept();
        WebElement succes=driver.findElement(By.xpath("(//div[@style='display: block;'])[1]"));
        Assert.assertTrue(succes.isDisplayed());
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        String homeP=driver.getCurrentUrl();
        String expectedHomeP="https://automationexercise.com/";
        Assert.assertEquals(expectedHomeP,homeP);




    }
}
