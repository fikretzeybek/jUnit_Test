package tests.TryTestingTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class To_Webtable extends TestBase {

    @Test
    public void test01() {

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//div[@role='hdata']"));
        List<String> baslikYazilariList = ReusableMethods.stringListeDonustur(baslikElementleriList);
        System.out.println("Basliklar : " +baslikYazilariList);
        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi :" +baslikYazilariList.get(2));
        //  4. Tablodaki tum datalari yazdirin
        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        //  6. Tablodaki satir sayisini yazdirin
        //  7. Tablodaki sutun sayisini yazdirin
        //  8. Tablodaki 3.kolonu yazdirin
        //  9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        //10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }

}
