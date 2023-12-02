package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class F_S118 extends TestBase {


    @Test
    public void iFrameTesti() {
                    /*
            1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
            2 ) Bir metod olusturun: iframeTest
                    - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
                    konsolda yazdirin.
                    - Text Box’a “Merhaba Dunya!” yazin.
                    - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
                    gorunur oldugunu dogrulayin ve konsolda yazdirin.
                     */


        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        //2 ) Bir metod olusturun: iframeTest
        driver.get("https://the-internet.herokuapp.com/iframe");
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //   konsolda yazdirin.
        WebElement textElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(textElementi.isDisplayed());
        System.out.println(textElementi.getText());

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe); // iframe gecis


        WebElement textKutusu = driver.findElement(By.tagName("p"));
        textKutusu.clear();// kutuda bulunan yaziyi temizler
        textKutusu.sendKeys("Merhaba Dunya!");
        ReusableMethods.bekle(4);

        // Ana sayfaya geri doner
        driver.switchTo().defaultContent();

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //    gorunur oldugunu dogrulayin ve konsolda yazdirin.
        WebElement linkElementi = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkElementi.isDisplayed());
        System.out.println(linkElementi.getText());
    }
}
