package tests.T127_SlaytTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.IframeUtilities;
import utilities.ReusableMethods;
import utilities.TestBase;

public class TestIframeUtilities extends TestBase {

    @Test
    public void test() {

        // Istenen url' e gidelim

        driver.get("http://demo.guru99.com/test/guru99home/");

        // Sayfadaki iframe sayısını bulalım
        int iframeSayisi = IframeUtilities.getIframeCount(driver);
        System.out.println("Sayfadaki iframe sayısı: " + iframeSayisi);

        // YouTube iframe'inin sırasını bulalım
        String youtubeIframeSrc = "youtube";
        int youtubeIframeIndexi = IframeUtilities.getIframeIndex(driver, youtubeIframeSrc);
        System.out.println("YouTube iframe " + youtubeIframeIndexi + ". sırada bulunuyor.");

        // Youtube Play butonuna tıklayalım
        String playButtonXPath = "//*[@id='player']";
        IframeUtilities.clickPlayButtonInIframe(driver, youtubeIframeSrc, playButtonXPath);
        ReusableMethods.bekle(3);

        driver.switchTo().frame(1); // İkinci iframe'a geçiş yap
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(@href,'guru99.com')]"));
        linkElement.click();

        ReusableMethods.bekle(5);

    }
}
