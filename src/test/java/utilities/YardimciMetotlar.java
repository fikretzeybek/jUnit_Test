package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.List;

public class YardimciMetotlar {

    public static int iframeSayisiBul(WebDriver driver) {
        return driver.findElements(By.tagName("iframe")).size();
    }

    public static int iframeIndexiBul(WebDriver driver, String iframeSrc) {
        int index = 0;
        List<WebElement> iframeElementLeri = driver.findElements(By.tagName("iframe"));
        for (WebElement each : iframeElementLeri) {
            if (each.getAttribute("src").contains(iframeSrc)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void clickYap(WebDriver driver, String arananIframeSrc, String playButtonLocater) {
        int iframinIndexi = iframeIndexiBul(driver, arananIframeSrc);

        if (iframinIndexi != -1) {
            driver.switchTo().frame(iframinIndexi); // Sıra 1'den başladığı için -1 çıkarılır

            // Bekleme ekleyin
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(playButtonLocater)));

            clickButton.click();
            driver.switchTo().defaultContent();
        } else {
            System.out.println("Belirtilen src değerine sahip iframe bulunamadı.");
        }
    }

}
