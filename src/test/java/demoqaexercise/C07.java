package demoqaexercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C07 extends TestBase {
    @Test
    public void test(){
        //1-https://demoqa.com/  adrese git
        driver.get("https://demoqa.com/ ");

        //2-Elements Click
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[1]")).click();

        //3-Links Butonuna tikla

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        driver.findElement(By.xpath("(//span[@class='text'])[6]")).click();

        String ilkSayfaWindowHandle=driver.getWindowHandle();

        //4-Home uzerine Click yap yeni sayfaya gec

        driver.findElement(By.id("simpleLink")).click();
        Set<String> windowHandleSet=driver.getWindowHandles();
        String ikinciSayfaWindowHandle="";
        for (String each:windowHandleSet) {
            if(!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandle);
       //5- ilk sayfay geri don
        driver.switchTo().window(ilkSayfaWindowHandle);


















    }

}
