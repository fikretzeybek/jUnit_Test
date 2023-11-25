package tests.AS_TestCase;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase01 {

    public static void main(String[] args) throws InterruptedException {

        //  Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com/");

        // Verify that home page is visible successfully

        if (driver.getTitle().equals("Automation Exercise")) {
            System.out.println("Home page is visible successfully testi PASSED");
        } else System.out.println("Home page is visible successfully testi FAILED");

        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //  Verify 'New User Signup!' is visible
        WebElement newUserElement = driver.findElement(By.xpath("//h2[contains(text(), 'New User Signup!')]"));

        if (newUserElement.isDisplayed()) {
            System.out.println("New User Signup! görünürlük testi PASSED");
        } else System.out.println("New User Signup! görünürlük testi FAILED");

        // Enter name and email address
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("ali");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("alim@ali.com");

        // Click 'Signup' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccInformation = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b"));

        if (enterAccInformation.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION görünürlük testi PASSED");
        } else System.out.println("ENTER ACCOUNT INFORMATION görünürlük testi FAILED");

        // Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ali12345");
        Thread.sleep(2000);
        driver.findElement(By.id("days")).sendKeys("27");
        driver.findElement(By.id("months")).sendKeys("July");
        driver.findElement(By.id("years")).sendKeys("2001");
        // Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        // Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label")).click();
        Thread.sleep(2000);

        // Fill details: First name, Last name, Company, Address, Address2,
        // Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Ali");
        driver.findElement(By.id("last_name")).sendKeys("CAN");
        driver.findElement(By.id("company")).sendKeys("A & C");
        driver.findElement(By.id("address1")).sendKeys("İşyeri1");
        driver.findElement(By.id("address2")).sendKeys("İşyeri2");
        driver.findElement(By.id("country")).sendKeys("Canada");
        driver.findElement(By.id("state")).sendKeys("Alberta");
        driver.findElement(By.id("city")).sendKeys("Calgary");
        driver.findElement(By.id("zipcode")).sendKeys("1111111");
        driver.findElement(By.id("mobile_number")).sendKeys("555555555");

        //  Click 'Create Account button'
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();

        // Click 'Continue' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();

        // Verify that 'Logged in as username' is visible
        WebElement loggedUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));

        if (loggedUsername.isDisplayed()) {
            System.out.println("Logged in as username görünürlük testi PASSED");
        } else System.out.println("Logged in as username görünürlük testi FAILED");

        // Click 'Delete Account' button
       // driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));


        if (accountDeleted.isDisplayed()) {
            System.out.println("ACCOUNT DELETED! görünürlük testi PASSED");
        } else System.out.println("ACCOUNT DELETED! görünürlük testi FAILED");

        accountDeleted.click();


        Thread.sleep(4000);

        driver.quit();

    }

}
