package tests.T127_SlaytTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.IframeUtilities;
import utilities.ReusableMethods;
import utilities.TestBase;
import utilities.YardimciMetotlar;

public class F_S119 extends TestBase {
    /*
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        2) sayfadaki iframe sayısını bulunuz.
        3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        4) ilk iframe'den çıkıp ana sayfaya dönünüz
        5) ikinci iframe'deki (Jmeter Made Easy) linke
            (https://www.guru99.com/live-selenium-project.html) tıklayınız
     */


    @Test
    public void iFrameTesti2() {
        //1) ) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) sayfadaki iframe sayısını bulunuz.
        int iframeSayisi = YardimciMetotlar.iframeSayisiBul(driver);
        System.out.println("Sayfadaki iframe sayisi : " + iframeSayisi);

        String arananIframeSrc = "youtube";
        int ararnanIframeIndexi = YardimciMetotlar.iframeIndexiBul(driver, arananIframeSrc);
        System.out.println("YouTube iframe " + ararnanIframeIndexi + ". sırada bulunuyor.");

        // İlk iframe'deki (Youtube) play butonuna tıklayınız.
        String playButtonLocater = "//*[@id='player']";
        YardimciMetotlar.clickYap(driver, arananIframeSrc, playButtonLocater);
        ReusableMethods.bekle(2);

        // İkinci iframe'deki (Jmeter Made Easy) linke tıklayınız
        arananIframeSrc = "ads.html";
        ararnanIframeIndexi = YardimciMetotlar.iframeIndexiBul(driver, arananIframeSrc);
        System.out.println("JMeter iframe " + ararnanIframeIndexi + ". sırada bulunuyor.");
        String jmeterLocater = "//img[@src='Jmeter720.png']";
        YardimciMetotlar.clickYap(driver, arananIframeSrc, jmeterLocater);
        ReusableMethods.bekle(3);


        driver.switchTo().defaultContent();
        ReusableMethods.bekle(3);
    }
}
