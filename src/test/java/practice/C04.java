package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
    /*
    /*
*"https://www.e-shopland.ch/sellacious/index.php" sayfasına gidin
*  * Arama simgesine tıklayın ve "Canon" u arayın
* * "Canon" kamera için "Add to cart" a tıklayın
*    * "Ödeme Yap" ı tıklayın
* Email adresini girin ve ""Proceed" e tıklayın.
* "Checkout as Guest"  te tıklayın.
* Formu doldurun.(rastgele bir ülke seçilmeli) - (Eyalet ve ilçe için hiçbir şey seçmeyin)
* Save butonuna tıklayın
* Adresin altındaki 'Bill Here' ve 'deliver here' butonuna tıklayın ve devam etmek için oka tıklayın
* Devam etmek için ok butonuna tıklayın
* "Proceed to payment" butonuna tıklayın
* "Cheque" ve "pay now" butonuna tıklayın. (burada bir bug var)
* "Adress Adress" kutucugunu kapatmak için X 'e basın. (thread sleep)
* "Cheque" e tıklayın ve "Pay Now" butonuna tekrar basın.
* "Payment via Cheque approved" mesajının görüntülendiğini dogrulayın
* Success" mesajının görüntülendiğini doğrulayın
* "View Invoice" butonuna tıklayın ve doğru ürünü siparis ettiginizi onaylayın.
* "View Receipt" e tıklayın ve e postanızın makbuzda dogru yazıldıgını kontol edin, onaylayın.
*
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
    driver.quit();

    }
    @Test
    public void test(){
        driver.get("https://www.e-shopland.ch/sellacious/index.php");
        driver.findElement(By.id("wt-cli-accept-all-btn")).click();
        driver.findElement(By.xpath("//input[@placeholder='Suchen…']")).sendKeys("Canon");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println(driver.getTitle());




    }



}
