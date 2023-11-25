package tests.AS_TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase02 {

    public static void main(String[] args) throws InterruptedException {

        //1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com/");

        //3. Verify that home page is visible successfully
        String homePage = driver.getTitle();

        if (homePage.equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully testi PASSED");
        } else System.out.println("Home page is visible successfully testi FAILED");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountElement = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/h2"));

        if (loginToYourAccountElement.isDisplayed()) {
            System.out.println("Login to your account görünürlük testi PASSED");
        } else System.out.println("Login to your account görünürlük testi FAILED");

        //6. Enter correct email address and password ali12345
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/input[2]")).sendKeys("ali@ali.com");
        driver.findElement(By.name("password")).sendKeys("ali12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/button")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement logedInUsernameElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));

        if (logedInUsernameElement.isDisplayed()) {
            System.out.println("Logged in as username görünürlük testi PASSED");
        } else System.out.println("Logged in as username görünürlük testi FAILED");

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));

        if (accountDeleted.isDisplayed()) {
            System.out.println("ACCOUNT DELETED! görünürlük testi PASSED");
        } else System.out.println("ACCOUNT DELETED! görünürlük testi FAILED");


        Thread.sleep(4000);
        driver.quit();
    }
}
