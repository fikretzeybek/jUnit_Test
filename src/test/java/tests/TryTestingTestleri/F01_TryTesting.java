package tests.TryTestingTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class F01_TryTesting extends TestBase {

    @Test
    public void trytesti(){
        // https://trytestingthis.netlify.app/ adresine gidin
        driver.get("https://trytestingthis.netlify.app/");
        // "Your Website to practice Automation Testing" gorundugunu dogrulayin
        Assert.assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());
        // "This is your Sample login page" de bulunan "username" ve "password" de
        //              aciklamaya uygun degerleri girerek login olun
        driver.findElement(By.xpath("//input[@id='uname']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        // "Login Successful :)" yazisinin gorunurlugunu dogrulayin
        Assert.assertTrue(driver.findElement(By.tagName("h2")).isDisplayed());
        // "Click here to go back to the home page" yazisinde bulunan
        //              "here" linkini kullanarak ana sayafaya donun
        driver.findElement(By.xpath("//a[normalize-space()='here']")).click();
        // Ana sayfaya dondugunuzu dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//legend[text()='This is your Sample login page:']")).isDisplayed());

    }
}
