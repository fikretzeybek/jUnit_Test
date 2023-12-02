package tests.T127_SlaytTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class F03_T extends TestBase {

    @Test
    public void test() {
        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //Cookies kabul edin
        // cookies de iframe icinde oldugundan
        // once o iframe'e gecis yapalim
       //WebElement cookiesIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
       //driver.switchTo().frame(cookiesIFrame);
       //driver.findElement(By.xpath("//*[text()='Accept All']")).click();

        //3) sayfadaki iframe sayısını bulunuz.



        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi : " + iFrameList.size());

        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement playIFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(playIFrame);

        driver.findElement(By.xpath("//*[@id='player']")).click();
        ReusableMethods.bekle(2);
        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        ReusableMethods.bekle(2);
        driver.switchTo().frame(1); // İkinci iframe'a geçiş yap
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(@href,'guru99.com')]"));
        linkElement.click();

        ReusableMethods.bekle(5);
    }
}