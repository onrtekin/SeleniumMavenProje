package demoqaexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C04 {
    static int count =4;

    public static void main(String[] args) throws InterruptedException {
        /*
        Mehmet hocanin youtube daki videolarini sirayla tek tek acarak ilk bes saniyesini caldiracak codu yaziniz.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        for (int i = 0; i < 58; i++) {
            driver.get("https://www.youtube.com/");
            driver.findElement(By.xpath("//input[@id='search']")).sendKeys("bulutluoz");
            driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-searchbox'])[2]")).click();
            driver.findElement(By.xpath("//img[@src='//yt3.ggpht.com/aJ2j-PxUn7ma2mLRiz0sAvxTVQzpNPExwAKPCq-nUrvCFgcgh8ykS_5uOLoCdLbQdumHvs7T=s176-c-k-c0x00ffffff-no-rj-mo']")).click();

            driver.findElement(By.xpath("(//div[@class='tab-content style-scope tp-yt-paper-tab'])[2]")).click();
            Thread.sleep(2000);


            Actions actions=new Actions(driver);



            for (int j = 0; j < count; j++) {
                actions.sendKeys(Keys.TAB).perform();

            }
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(5000);

            count+=2;


        }
    }


}
