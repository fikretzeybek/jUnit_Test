package tests.TryTestingTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {

    @Test
    public void cookieTesti(){

        driver.get("https://www.testrelic.com");

        Set<Cookie> cokiesSeti = driver.manage().getCookies();

        int  siraNo = 1;
        for (Cookie each : cokiesSeti
             ) {
           // System.out.println(siraNo + ". Cookie : " + each);
            siraNo ++;
        }

        int expectedCookiesSayisi = 4;
        int actualCookiesSayisi = cokiesSeti.size();

        Assert.assertTrue(actualCookiesSayisi > expectedCookiesSayisi);

        String actualCookieValue = driver.manage().getCookieNamed("_gat_gtag_UA_180732778_1").getValue();
        String expectedCookieValue = "1";

        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        cokiesSeti = driver.manage().getCookies();


          siraNo = 1;
        for (Cookie each : cokiesSeti
        ) {
            System.out.println(siraNo + ". Cookie : " + each);
            siraNo ++;
        }
         actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
         expectedCookieValue = "cikolatali";

        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        driver.manage().deleteCookieNamed("_ga");

        Assert.assertTrue(driver.manage().getCookieNamed("_ga") == null);

        driver.manage().deleteAllCookies();

        cokiesSeti = driver.manage().getCookies();
        Assert.assertTrue(cokiesSeti.size() == 0);
    }
}
