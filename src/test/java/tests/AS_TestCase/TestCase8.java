package tests.AS_TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class TestCase8 extends TestBase  {

    @Test
    public void exercise08() {


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        WebElement imgElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(imgElementi.isDisplayed());

        //4. Click on 'Products' button
        WebElement productsElementi = driver.findElement(By.xpath("//*[text()=' Products']"));
        productsElementi.click();


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productsPageElementi = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(productsPageElementi.isDisplayed());
        //6. The products list is visible
        WebElement productsListElementi = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']"));
        Assert.assertTrue(productsListElementi.isDisplayed());


        //7. Click on 'View Product' of first product

        WebElement firstProduct = driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));
        //productsElementi.sendKeys(Keys.PAGE_DOWN);
        //(//i[@class='fa fa-plus-square'])[1]
        firstProduct.click();



        //8. User is landed to product detail page

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

        WebElement pruductFieldElementi = driver.findElement(By.xpath("//div[@class='product-information']"));
        Assert.assertTrue(pruductFieldElementi.isDisplayed());
        System.out.println(pruductFieldElementi.getText());

        ReusableMethods.bekle(3);


    }


}