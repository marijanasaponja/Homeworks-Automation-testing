package WordpressSite.WordpressTests;

import WordpressSite.WordpressBase.WordpressBaseTest;
import WordpressSite.WordpressPages.WordpressLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WordpressLoginTest extends WordpressBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");
    }

    @Test
    public void userCanLogIn() {


        wordpressHomepage.clickOnLogInButton();
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));
        wordpressLoginPage.insertUsername("marijanas90");
        wordpressLoginPage.clickOnContinueButton();
        wdwait.until(ExpectedConditions.elementToBeClickable(wordpressLoginPage.getPasswordField()));
        wordpressLoginPage.insertPassword("*M@rijana123*");
        wordpressLoginPage.clickOnContinueButton();
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/read"));

        Assert.assertTrue(wordpressProfilePage.getProfileIcon().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/read");


    }
}
