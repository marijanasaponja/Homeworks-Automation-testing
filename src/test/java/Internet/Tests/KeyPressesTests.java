package Internet.Tests;

import Internet.Base.InternetBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressesTests extends InternetBaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void userCanAddOneLetterInInput() {
        internetHomepage.clickOnKeyPressButton();
        keyPressesPage.clickOnInputField();
        keyPressesPage.sendKeys("Y");
        Assert.assertTrue(keyPressesPage.getNotification().isDisplayed());

    }

    @Test
    public void userCanAddOneNumberInInput(){
        internetHomepage.clickOnKeyPressButton();
        keyPressesPage.clickOnInputField();
        keyPressesPage.sendKeys("1");
        String message =keyPressesPage.getNotification().getText();
        Assert.assertTrue(keyPressesPage.getNotification().isDisplayed());

    }
}
