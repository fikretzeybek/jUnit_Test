package tests.AS_TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class TestCase04 extends TestBase {

    @Test
    public void test04() {

        //1. Launch browser

        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePageElement = driver.findElement(By.xpath("//div[@class='row']"));
        System.out.println(homePageElement.getText());
        Assert.assertTrue(homePageElement.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //a[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginAccountElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginAccountElementi.isDisplayed());
        //6. Enter correct email aaddress and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ali@gel.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("ali123");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedUsenameElementi = driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedUsenameElementi.isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        //10. Verify that user is navigated to login page
        String expectedUrl = "https://automationexercise.com/login";
        String actualUel = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUel);



    }


}
