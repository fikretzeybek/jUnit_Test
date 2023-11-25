package tests.AS_TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase03 {

    public static void main(String[] args) throws InterruptedException {

        //1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String homePage = driver.getTitle();

        if (homePage.equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully testi PASSED");
        } else System.out.println("Home page is visible successfully testi FAILED");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));

        if (loginToYourAccountElement.isDisplayed()) {
            System.out.println("Login to your account is visible testi PASSED");
        } else System.out.println("Login to your account is visible testi FAILED");

        //6. Enter incorrect email address and passwor
        driver.findElement(By.name("email")).sendKeys("veli@veli.com");
        driver.findElement(By.name("password")).sendKeys("123456");

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement yourEmailOrPasswordIncorrectElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/p"));

        if (yourEmailOrPasswordIncorrectElement.isDisplayed()) {
            System.out.println("Your email or password is incorrect! is visible testi PASSED");
        } else System.out.println("Your email or password is incorrect! is visible testi FAILED");

        Thread.sleep(3000);
        driver.quit();

    }
}