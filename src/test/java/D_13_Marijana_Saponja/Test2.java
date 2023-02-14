package D_13_Marijana_Saponja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        String validUsername = "student";
        String blankPassword = "";
        username.sendKeys(validUsername);
        password.sendKeys(blankPassword);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertFalse(error.isDisplayed());

        String loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);

    }
}
