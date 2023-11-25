package tests.AS_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase4 extends TestBase {
    //1. Launch browser

    @Test
    public void test(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement hPElementi = driver.findElement(By.xpath("//div[@class='row']"));
        Assert.assertTrue(hPElementi.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //a[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement lyAccountElementi = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(lyAccountElementi.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ali@gel.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("ali123");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement lUsernameElementi = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(lUsernameElementi.isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();

        //10. Verify that user is navigated to login page
        WebElement userNavElementi = driver.findElement(By.xpath("//h2[@class='or']"));
        Assert.assertTrue(userNavElementi.isDisplayed());

    }



}
