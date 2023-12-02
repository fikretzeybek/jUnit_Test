package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class F_111 extends TestBase {

    @Test
    public void test01(){

        //3 test method'u olusturup asagidaki gorevi tamamlayin
        //1. Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String alertYazi1 = driver.switchTo().alert().getText();
        String expectedAlert1Yazi = "I am a JS Alert";
        Assert.assertEquals(expectedAlert1Yazi,alertYazi1);
        //- OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();


    }
    @Test
    public void test02(){
        //2.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 2.alert'e tiklayalim
       driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        WebElement cancelYazisi = driver.findElement(By.id("result"));
        Assert.assertTrue(cancelYazisi.isDisplayed());
    }
    @Test
    public void test03(){
        //3.Test
        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
       Assert.assertTrue( driver.findElement(By.id("result")).isDisplayed());
    }
}
