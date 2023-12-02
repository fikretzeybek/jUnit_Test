package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class F01_iFrame extends TestBase {

    @Test
    public void iFrameTesti() {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIFrameYaziElementi = driver.findElement(By.tagName("h3"));
        System.out.println(anIFrameYaziElementi.getText());

        //	- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi = driver.findElement(By.tagName("iFrame"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxKutusu = driver.findElement(By.tagName("p"));
        textBoxKutusu.clear();
        textBoxKutusu.sendKeys("Merhaba Dunya");

        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    linki textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSelyaziElementi = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        System.out.println(elementalSelyaziElementi.getText());
        Assert.assertTrue(elementalSelyaziElementi.isDisplayed());



    }
}
