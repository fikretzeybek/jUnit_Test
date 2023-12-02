package tests.AS_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class TestCase06 extends TestBase {

    @Test
    public void test(){

        // Web uygulamasına gidin
        driver.get("http://automationexercise.com");

        // Ana sayfanın başarılı bir şekilde yüklendiğini kontrol etme
        WebElement hPageElementi = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(hPageElementi.isDisplayed());

        // 'Contact Us' butonuna tıkla
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

        // 'GET IN TOUCH' elementinin görüntülendiğini kontrol etme
        WebElement getInTouchElementi = driver.findElement(By.xpath("//*[@href='/contact_us']"));
        Assert.assertTrue(getInTouchElementi.isDisplayed());

        // İsim, e-posta, konu ve mesajı girme
        WebElement nameElementi = driver.findElement(By.xpath("//input[@data-qa='name']"));
        nameElementi.sendKeys("ali");

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);
        actions.sendKeys(" gel")
                .sendKeys(Keys.TAB)
                .sendKeys("ali@gel.com")
                .sendKeys(Keys.TAB)
                .sendKeys("bilinmez")
                .sendKeys(Keys.TAB)
                .sendKeys("nasil yapabilirim")
                .perform();

        // Dosya yükleme işlemi
        WebElement dosyaYuklemeElementi = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
        ReusableMethods.bekle(5);
        dosyaYuklemeElementi.sendKeys("C:\\Users\\Z€YB\\Desktop\\deneme.txt");

        // Dosya yükleme işlemi başarılıysa, bir doğrulama yapma (Bu kısım düzenlenmiş)
        Assert.assertTrue("Dosya yükleme başarılı", !dosyaYuklemeElementi.getAttribute("value").isEmpty());

        // 'Submit' düğmesine tıkla
        ReusableMethods.bekle(2);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
        submitButton.click();

        // Dosya yükleme işleminden sonra çıkan alert penceresini kabul et
        Alert fileUploadedAlert = driver.switchTo().alert();
        fileUploadedAlert.accept();

        // Başarı mesajının görüntülendiğini kontrol et
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]"));
        Assert.assertTrue(successMessage.isDisplayed());

        // 'Home' butonuna tıkla ve başarılı bir şekilde ana sayfaya dönüldüğünü kontrol et
        WebElement homeButton = driver.findElement(By.xpath("//*[@href='/']"));
        homeButton.click();
        WebElement homePageLogo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePageLogo.isDisplayed());

        // WebDriver'ı kapatma
        driver.quit();
    }
}