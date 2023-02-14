package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        WebElement loginRedirect = driver.findElement(By.linkText("Log In"));
        loginRedirect.click();

        //Thread.sleep(3000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));

        WebElement emailField = driver.findElement(By.id("usernameOrEmail"));
        String username = "dragoljubqa";
        emailField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        //Thread.sleep(2000);
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Swordfish123!@#");

        continueButton.click();

        //Thread.sleep(4000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }
}

//        Lokatori:
//        Prvo trazimo "id" medju lokatorima zato sto je jedinstven element i nije sklon pomenama (u idealnom sistemu)
//        Ako nemamo "id" trazimo onda "name"
//        Za slucaj da nemamo ni "id" ni "name" onda tek prelazimo na "class" ali obavezno treba proveriti da li je element jedinstven tako sto se kopira vrednost klase i ubaci u pretragu (CTRL + F).
//                Program ce naci cesto mnogo resenja ali ne znaci da element nije jedinstven.
//        Na primer:
//        "...
//        for="string"
//        class="string"
//..."
//        ovde ce pronaci dva elementa ali ako trazite preko class onda je jedinstven
//        8:22
//        Ako klasa koju trazite ima vrednost za vise stringova u sebi onda:
//        Promenite iz By.ClassName u By.CssSelector
//        Obrisete razmake i stavite tacku na njihovo mesto
//        Stavite tacku na pocetak vrednosti
//        Na primer:
//        class = "jedan dva tri"
//        onda ne mozete naci kao
//        By.ClassName("jedan dva tri");
//        nego morate
//        By.CssSelector(".jedan.dva.tri");
//
//        Morace da se doda exception za ovo cekanje tako sto kliknete na "sleep" i kliknete ALT + ENTER
//
//
//
//
//
//        8:59
//        Videcete u produzetku metode da se dodao exception
//        8:59
//        U zagradi se pisu milisekunde. Ako hocete da sacekate 2 sekunde onda 2000, ako hocete 5 onda 5000
//
