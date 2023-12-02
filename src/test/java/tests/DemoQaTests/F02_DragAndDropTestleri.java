package tests.DemoQaTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class F02_DragAndDropTestleri extends TestBase {
    Actions actions;

    @Test
    public void dropTesti() {
        driver.get("https://demoqa.com/droppable");
        actions = new Actions(driver);
        WebElement dragElementi = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropElementi = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.dragAndDrop(dragElementi, dropElementi).perform();

        WebElement droppedYazisi = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(droppedYazisi.isDisplayed());

    }
}
