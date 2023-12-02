package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class F_S97 extends TestBase {

    @Test
    public void test01(){


        // a. Verilen web sayfasına gidin.
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chBx1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement chBx2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chBx1.isSelected()) {
            chBx1.click();
        }

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!chBx2.isSelected()) {
            chBx2.click();
        }

        // e. Doğrulama işlemleri
        Assert.assertTrue(chBx1.isSelected());
        Assert.assertTrue(chBx2.isSelected());

        // WebDriver'ı kapatın
        driver.quit();
    }
}
