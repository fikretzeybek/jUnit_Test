package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class F03_iFrame  extends TestBase {

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement aninframeYazisi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(aninframeYazisi.isEnabled());

        WebElement iFrameElementi = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textKutusu = driver.findElement(By.tagName("p"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya");

        //driver.switchTo().defaultContent();  veya
        driver.switchTo().parentFrame();

        WebElement esElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        System.out.println(esElementi);


        ReusableMethods.bekle(4);







    }
}
