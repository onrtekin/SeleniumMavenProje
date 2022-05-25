package demoqaexercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C09 extends TestBase {
    static  int satirNo;
    static  int sutunNo;

    @Test
    public void test(){

      // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
      // 2. Headers da bulunan department isimlerini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@class='rt-thead -header']")).getText());
      // 3. sutunun basligini yazdirin
        System.out.println("Sutun Basligi : "+driver.findElement(By.xpath("//div[@class='rt-resizable-header-content']")).getText());
      // 4. Tablodaki tum datalari yazdirin
        System.out.println("Tum Datalar : "+driver.findElement(By.xpath("//div[@class='rt-tbody']")).getText());
      // 5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> cellList=driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("taboladaki hucre sayisi : "+cellList.size());

      // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirList=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki Satir Sayisi : "+satirList.size());

      // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutList=driver.findElements(By.className("rt-resizable-header-content"));
        System.out.println("Sutun Sayisi : "+sutList.size());

      // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement>ucuncuKoln=driver.findElements(By.xpath("//div[@role='rowgroup']//div[3]"));
        for (WebElement each:ucuncuKoln) {
         if(!each.getText().equals(" ")){
             System.out.println(each.getText());
         }
        }

      // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("Kierra Salary : "+driver.findElement(By.xpath("(//div[@role='rowgroup'])[3]//div[5]")).getText());


      // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        getir(3,5);



    }

    private List<WebElement> getir(int satirsayisi, int sutunsayisi) {


     List<WebElement> data=driver.findElements(By.xpath("(//div[@role='rowgroup'])["+satirsayisi+"]//div["+sutunsayisi+"]"));

        for (WebElement each:data) {

            System.out.println(each.getText());
        }
     return data;

    }
}
