package tests.T127_SlaytTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class F02_FaceBookRadioButton extends TestBase {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    @Test
    public void facebookRadioButton() {

        // 	a. Verilen web sayfasına gidin.
        // 	     https://facebook.com
        driver.get("https://facebook.com");

        // 	b. Cookies’i kabul edin


        // 	c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 	d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kadinRB = driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        System.out.println(kadinRB.getText());
        WebElement erkekRB = driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        System.out.println(erkekRB.getText());
        WebElement ozelRB = driver.findElement(By.xpath("(//input[@class='_8esa'])[3]"));
        System.out.println(ozelRB.getText());

        erkekRB.click();
        Assert.assertTrue("erkek secili",erkekRB.isSelected()
                && !kadinRB.isSelected()
                && !ozelRB.isSelected());


    }


}