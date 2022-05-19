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

public class C09 {
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
    public void test(){
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
         */
        driver.get("http://automationexercise.com");
        WebElement homePage=driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://automationexercise.com/products";
        Assert.assertEquals(expectedUrl, actualUrl);
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("Men Tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        WebElement searchedProducts=driver.findElement(By.xpath("//div[@class='product-overlay']"));
        Assert.assertTrue(searchedProducts.isDisplayed());

        WebElement allTheProducts=driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(allTheProducts.isDisplayed());



    }
}
