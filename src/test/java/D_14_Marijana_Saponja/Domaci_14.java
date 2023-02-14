package D_14_Marijana_Saponja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

import static java.awt.SystemColor.window;

public class Domaci_14 {
    public static void main(String[] args) throws InterruptedException {
//        Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
//                Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");

        Cookie cookie1 = new Cookie("userName", "marijanas90");
        driver.manage().addCookie(cookie1);
        Cookie cookie2 = new Cookie("userID","87ece40a-793c-4543-8beb-c587f75de20b");
        driver.manage().addCookie(cookie2);
        Cookie cookie3 = new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmlqYW5hczkwIiwicGFzc3dvcmQiOiIqTUByaWphbmExMjMqIiwiaWF0IjoxNjczODIwODEzfQ.4_8zuD2Qs-qrVZT53XcFWAjoIUCGcIoVp7rI-hPlr6Q");
        driver.manage().addCookie(cookie3);
        Cookie cookie4 = new Cookie("expires","2023-01-22T22%3A13%3A33.743Z");
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();

        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook1.click();
        driver.navigate().back();

        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book2.click();
        Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook2.click();
        driver.navigate().back();

        driver.manage().deleteCookie(cookie1);
        driver.manage().deleteCookie(cookie2);
        driver.manage().deleteCookie(cookie3);
        driver.manage().deleteCookie(cookie4);
        driver.get("https://demoqa.com/login");

        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        String usernameInput = "marijanas90";
        String passwordInput = "*M@rijana123*";
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        Thread.sleep(3000);
        WebElement gitPocketGuideBook = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(gitPocketGuideBook.isDisplayed());
        WebElement learningJavaScriptBook = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(learningJavaScriptBook.isDisplayed());

      WebElement logOutButton = driver.findElement(By.id("submit"));
      logOutButton.isDisplayed();
      driver.quit();



    }
}
