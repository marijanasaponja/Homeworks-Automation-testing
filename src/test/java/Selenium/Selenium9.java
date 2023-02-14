package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Selenium9 {
    WebDriver driver;
    WebDriverWait wdwait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    public void goToLoginPage(){
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    public void logIn() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        String validUsername = "student";
        String validPassword = "Password123";
        username.sendKeys(validUsername);
        password.sendKeys(validPassword);
        submitButton.click();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        goToLoginPage();
        logIn();
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String expectedTitle = "Logged In Successfully";
        WebElement title = driver.findElement(By.className("post-title"));
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(title.getText(), expectedTitle);
        Assert.assertTrue(logOutButton.isDisplayed());

    }

    @Test (priority = 20)
    public void userCanLogOut() {
        goToLoginPage();
        logIn();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement username1 = driver.findElement(By.id("username"));
        WebElement password1 = driver.findElement(By.id("password"));
        WebElement submitButton1 = driver.findElement(By.id("submit"));

        Assert.assertTrue(username1.isDisplayed());
        Assert.assertTrue(password1.isDisplayed());
        Assert.assertTrue(submitButton1.isDisplayed());

    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        goToLoginPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String invalidUsername = "username";
        String validPassword = "Password123";

        username.sendKeys(invalidUsername);
        password.sendKeys(validPassword);
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);


    }

    @Test
    public void userCannotLogInWithInvalidPassword(){
        goToLoginPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String invalidPassword = "password";

        username.sendKeys(validUsername);
        password.sendKeys(invalidPassword);
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your password is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        goToLoginPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String invalidUsername = "username";
        String invalidPassword = "password";

        username.sendKeys(invalidUsername);
        password.sendKeys(invalidPassword);
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @Test
    public void userCannotLogInWithEmptyFields() {
        goToLoginPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.clear();
        password.clear();
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @Test
    public void userCannotLogInWithEmptyUsernameField() {
        goToLoginPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validPassword = "Password123";

        username.clear();
        password.sendKeys(validPassword);
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @Test
    public void userCannotLogInWithEmptyPasswordField() {
        goToLoginPage();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";

        username.sendKeys(validUsername);
        password.clear();
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your password is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}