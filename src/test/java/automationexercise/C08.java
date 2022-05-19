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

public class C08 {
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
2. Navigate to url 'https://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
         */
        driver.get("https://automationexercise.com");
        WebElement homePage= driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();
        String allProductsPage=driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        String suchen="ALL PRODUCTS";
        Assert.assertEquals(suchen,allProductsPage);
        WebElement productsList=driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(productsList.isDisplayed());
        driver.findElement(By.xpath("(//a[@style='color: brown;'])[1]")).click();
        WebElement productInformation=driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(productInformation.isDisplayed());


    }



}
