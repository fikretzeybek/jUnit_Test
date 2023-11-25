package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class f01_ extends TestBase {
    //
    //1- bir class olusturun


    @Test
    public void amazonTesti() {
        //2- https://www.amazon.com/?ref_=nav_signin adresine gidin
        driver.get("https://www.amazon.com/?ref_=nav_signin");
        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        WebElement titleElementi =
                driver.findElement(By.xpath("//title[text()='Amazon.com. Spend less. Smile more.']"));
        String expectedIcerik = titleElementi.getText();
        System.out.println(expectedIcerik);
        //6- Gift Cards sekmesine basin
        //7- Specialty Gift Cards butonuna basin
        //8- ilk urunu tiklayin
        //9- Gift card details’den 25 $’i secin
        //10-Urun ucretinin 25$ oldugunu test edin
        //11-Sayfayi kapatin



    }

}
