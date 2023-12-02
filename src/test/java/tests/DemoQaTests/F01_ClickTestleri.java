package tests.DemoQaTests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class F01_ClickTestleri extends TestBase {
    Actions actions;

    @Test
    public void rightClickTesti() {
        //1- https://demoqa.com/buttons sitesine gidin
        driver.get("https://demoqa.com/buttons");
        //2- “Right click me” uzerinde sag click yapin
        WebElement rightCMeButton = driver.findElement(By.id("rightClickBtn"));
        actions = new Actions(driver);
        actions.contextClick(rightCMeButton).perform();
        //3-“You have done a right click” gorundugunu test edin.
        WebElement rightClickYazi = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickYazi.isDisplayed());

    }

    @Test
    public void clickMeTesti() {
        driver.get("https://demoqa.com/buttons");
        WebElement clickMeButton = driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[3]"));
        actions = new Actions(driver);
        actions.click(clickMeButton).perform();
        WebElement clickMeYazi = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(clickMeYazi.isDisplayed());

    }

    @Test
    public void CdoublelickMeTesti() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickMeButton = driver.findElement(By.xpath("(//*[@type='button'])[2]"));
        actions = new Actions(driver);
        actions.doubleClick(doubleClickMeButton).perform();
        WebElement doubleClickMeYazi = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertTrue(doubleClickMeYazi.isDisplayed());
    }
}
