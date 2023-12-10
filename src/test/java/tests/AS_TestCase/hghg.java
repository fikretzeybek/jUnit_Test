package tests.AS_TestCase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class hghg extends TestBase {

    @Test
    public void test01() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        //5. Verify 'New User Signup!' is visible
        String expected = "New User Signup!";
        String actuallIcerik = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        Assert.assertEquals(expected, actuallIcerik);

        //6-Enter name and email address
        WebElement name = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        actions.click(name)
                .sendKeys("selin")
                .sendKeys(Keys.TAB)
                .sendKeys("selin77@gmail.com")
                .perform();


        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement account = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(account.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title = driver.findElement(By.xpath("//div[@class='radio-inline'][2]")); //titlet
        actions = new Actions(driver);
        actions.click(title)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)

                .sendKeys(Keys.TAB)

                .sendKeys("2344545")
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1993")
                .sendKeys(Keys.TAB)
                .perform();
        //ReusableMethods.bekle(3);


        // 10. Select checkbox 'Sign up for our newsletter!'

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
       // ReusableMethods.bekle(2);


        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        Faker faker = new Faker();
        WebElement firstname = driver.findElement(By.xpath("//*[@name='first_name']"));

        actions.click(firstname)


                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().streetAddress())
                .sendKeys(Keys.TAB).perform();

        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select select = new Select(country);
        select.selectByValue("India");
        WebElement state = driver.findElement(By.id("state"));
        actions.click(state)

                .sendKeys("California")

                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().city())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        ReusableMethods.bekle(3);
    }
}
