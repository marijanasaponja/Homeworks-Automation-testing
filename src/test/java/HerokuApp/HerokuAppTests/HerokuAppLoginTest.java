package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }

    @Test (priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1,1);
            herokuAppLoginPage.insertUsername(invalidUsername);
            herokuAppLoginPage.inserPassword(validPassword);
            herokuAppLoginPage.clickOnLogInButton();
            String expectedURL = excelReader.getStringData("URL", 1,1);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(herokuAppLoginPage.errorLogin.isDisplayed());
        }
    }
    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            herokuAppLoginPage.insertUsername(validUsername);
            herokuAppLoginPage.inserPassword(invalidPassword);
            herokuAppLoginPage.clickOnLogInButton();
            String expectedURL = excelReader.getStringData("URL", 1,1);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(herokuAppLoginPage.errorLogin.isDisplayed());
        }
    }


    @Test (priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i,3);
            herokuAppLoginPage.insertUsername(invalidUsername);
            herokuAppLoginPage.inserPassword(invalidPassword);
            herokuAppLoginPage.clickOnLogInButton();
            String expectedURL = excelReader.getStringData("URL", 1,1);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(herokuAppLoginPage.errorLogin.isDisplayed());

        }
    }

    @Test (priority = 50)
    public void userCannotLogInWithEmptyFields() {

            herokuAppLoginPage.clickOnLogInButton();
            String expectedURL = excelReader.getStringData("URL", 1,1);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(herokuAppLoginPage.errorLogin.isDisplayed());

        }

    @Test (priority = 60)
    public void userCannotLogInWithEmptyUsernameField() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {;
            String validPassword = excelReader.getStringData("Login", 1,1);
            herokuAppLoginPage.inserPassword(validPassword);
            herokuAppLoginPage.clickOnLogInButton();
            String expectedURL = excelReader.getStringData("URL", 1,1);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(herokuAppLoginPage.errorLogin.isDisplayed());
        }
    }
    @Test (priority = 70)
    public void userCannotLogInWithEmptyPasswordField() {
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUsername = excelReader.getStringData("Login", 1, 0);
            herokuAppLoginPage.insertUsername(validUsername);
            herokuAppLoginPage.clickOnLogInButton();
            String expectedURL = excelReader.getStringData("URL", 1,1);
            Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
            Assert.assertTrue(herokuAppLoginPage.errorLogin.isDisplayed());
        }
    }
    @Test (priority = 80)
    public void userCanLogOut() {
     userCanLogIn();
     herokuAppLogoutPage.clickOnLogoutButton();
     Assert.assertTrue(herokuAppLoginPage.LogInButton.isDisplayed());
     Assert.assertTrue(herokuAppLogoutPage.Notification.isDisplayed());
     String expectedURL = excelReader.getStringData("URL", 1,0);
     Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        }
    }



