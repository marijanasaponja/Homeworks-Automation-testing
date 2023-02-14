package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
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
        String validPassword = "Password123";
        username.sendKeys(validUsername);
        password.sendKeys(validPassword);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        String loggedInURL = driver.getCurrentUrl();
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();
        //String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        //Posto se DOM promenio nakon logovanja onda je potrebno ponovo naci prethodne webelemente
        //zato sto su oni postali "stali" i java ih ignorise i zahteva da se isti element ponovo pronadje
        //ovaj slucaj nece biti problem kada budemo radili preko Page Object Model
        WebElement username1 = driver.findElement(By.id("username"));
        WebElement password1 = driver.findElement(By.id("password"));
        WebElement submitButton1 = driver.findElement(By.id("submit"));
        Assert.assertTrue(username1.isDisplayed());
        Assert.assertTrue(password1.isDisplayed());
        Assert.assertTrue(submitButton1.isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

        /*WebElement loggedInTitle = driver.findElement(By.className("post-title"));
        WebElement logOutButton1 = driver.findElement(By.linkText("Log out"));
        Assert.assertFalse(logOutButton1.isDisplayed());
        Assert.assertFalse(loggedInTitle.isDisplayed());*/

        //Da bismo proverili da element nije prisutan na stranici ne mozemo da proverimo samo kao
        //Assert.assertFalse(logOutButton.isDisplayed());
        //Zato sto program nece moci da pronadje element i prijavice gresku
        //Da bismo to uradili koristimo try catch blok koji je slican if else funkciji
        //Prvo kreiramo boolean
        boolean button = false;
        try {
            //u try bloku kazemo da ako se element pronadje, onda prethodno kreiran boolean treba da se promeni
            //odnosno da primi vrednost true ako je element pronadjen
            button = logOutButton.isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(button);
        //Na kraju asertujemo samo taj boolean da li je ostao nepromenjen
        //Da proverimo da li ovaj test radi onda cemo samo zakomentarisati prethodne asertove i akciju kada smo se izlogovali
        //Kako bismo omogucili programu da zapravo nadje element i promeni boolean iz try catch bloka
        //Tada ce test da padne nakon cega cemo da vratimo samo na prethodno stanje






    }
}