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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
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
        driver.get("http://automationexercise.com");
        String entrance=driver.getTitle();
        String pageEntrance="Automation Exercise";
        Assert.assertEquals(pageEntrance,entrance);
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String actualNewUserWrite=driver.findElement(By.xpath("(//h2)[3]")).getText();
        String expectedWrite="New User Signup!";
        Assert.assertEquals(expectedWrite,actualNewUserWrite);
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("omer");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("omerfaiktekin@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement eai=driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(eai.isDisplayed());
        driver.findElement(By.xpath("//input[@type='radio']")).click();
        driver.findElement(By.id("password")).sendKeys("2017");
        WebElement date=driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDate=new Select(date);
        selectDate.selectByValue("16");
        WebElement mounth=driver.findElement(By.id("months"));
        Select selectMounth=new Select(mounth);
        selectMounth.selectByValue("8");
        WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear=new Select(year);
        selectYear.selectByValue("2017");
        driver.findElement(By.xpath("(//input[@name='newsletter'])")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        driver.findElement(By.id("first_name")).sendKeys("Omer Faik");
        driver.findElement(By.id("last_name")).sendKeys("Tekin");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Safranbolu");
        WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry=new Select(country);
        selectCountry.selectByValue("United States");
        driver.findElement(By.id("state")).sendKeys("Chicago");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Peoria");
        driver.findElement(By.id("zipcode")).sendKeys("78600");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("5550254524");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        WebElement accountCreated=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        WebElement loggedInas=driver.findElement(By.xpath("//*[text()=' Logged in as '] "));
        Assert.assertTrue(loggedInas.isDisplayed());
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        WebElement deleteAccount=driver.findElement(By.xpath("//div[@class='page-header']"));
        Assert.assertTrue(deleteAccount.isDisplayed());
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();











    }





}
