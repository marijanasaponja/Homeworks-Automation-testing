package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
    public static void main(String[] args) {

        //https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        String expectedUrl= "https://practicetestautomation.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        String expectedName= "Hello";
        WebElement actual= driver.findElement(By.className("post-title"));
        String actualName= actual.getText();
        Assert.assertEquals(expectedName, actualName);

        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();

        WebElement testLoginPage= driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement submit= driver.findElement(By.id("submit"));
        submit.click();

        String expectedURL= "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        String expectedTitle= "Logged In Successfully";
        WebElement pageTitle = driver.findElement(By.className("post-title"));
        String actualTitle = pageTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);

        String secondExpectedTitle= "Congratulations student. You successfully logged in!";
        WebElement secondPageTitle = driver.findElement(By.className("has-text-align-center"));
        String secondActualTitle= secondPageTitle.getText();
        Assert.assertEquals(secondExpectedTitle, secondActualTitle);


        driver.quit();




    }
}
