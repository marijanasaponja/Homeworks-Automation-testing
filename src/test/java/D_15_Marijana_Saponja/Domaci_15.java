package D_15_Marijana_Saponja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Domaci_15 {

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {

        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        String usernameInput = "marijanas90";
        String passwordInput = "*M@rijana123*";
        username.sendKeys(usernameInput);
        password.sendKeys(passwordInput);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement usernameValue= driver.findElement(By.id("userName-value"));
        String user =usernameValue.getText();
        Assert.assertEquals(user, "marijanas90");

        WebElement emptyTable= driver.findElement(By.className("rt-noData"));
        Assert.assertEquals(emptyTable.getText(), "No rows found");
        driver.get("https://demoqa.com/books");
    }

    @Test (priority = 10)
    public void addOneBook() throws InterruptedException {
        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        book1.click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook1.click();
        driver.navigate().back();

        driver.get("https://demoqa.com/profile");
        WebElement gitPocketGuideBook = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(gitPocketGuideBook.isDisplayed());
        Thread.sleep(4000);

    }

    @Test (priority = 20)
    public void addTwoBooks() throws InterruptedException {
        WebElement book1 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        book1.click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook1.click();
        driver.navigate().back();

        WebElement book2 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        book2.click();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook2.click();
        driver.navigate().back();
        driver.get("https://demoqa.com/profile");
        WebElement learningJavaScriptBook = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(learningJavaScriptBook.isDisplayed());
        WebElement webApiBook = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertTrue(webApiBook.isDisplayed());
        Thread.sleep(4000);

    }
    @Test (priority = 30)
    public void addThreeBooks() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement book1 = driver.findElement(By.linkText("You Don't Know JS"));
        book1.click();
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook1 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook1.click();
        driver.navigate().back();

        WebElement book2 = driver.findElement(By.linkText("Understanding ECMAScript 6"));
        book2.click();
        Thread.sleep(2000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook2 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook2.click();
        driver.navigate().back();

        WebElement book3 = driver.findElement(By.linkText("Speaking JavaScript"));
        book3.click();
        Thread.sleep(2000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement addBook3 = driver.findElement(By.cssSelector(".text-right.fullButton"));
        addBook3.click();
        driver.navigate().back();

        driver.get("https://demoqa.com/profile");
        WebElement youDontKnowJSBook = driver.findElement(By.linkText("You Don't Know JS"));
        Assert.assertTrue(youDontKnowJSBook.isDisplayed());
        WebElement understandingEcmaScriptBook = driver.findElement(By.linkText("Understanding ECMAScript 6"));
        Assert.assertTrue(understandingEcmaScriptBook.isDisplayed());
        WebElement speakingJavaScriptBook = driver.findElement(By.linkText("Speaking JavaScript"));
        Assert.assertTrue(speakingJavaScriptBook.isDisplayed());
        Thread.sleep(4000);

    }


    @AfterMethod
    public void afterMethod() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        List <WebElement> button = driver.findElements(By.id("submit"));
        button.get(2).click();
        Thread.sleep(2000);
        WebElement confirmDelete = driver.findElement(By.id("closeSmallModal-ok"));
        Thread.sleep(2000);
        confirmDelete.click();
        driver.navigate().back();
        driver.navigate().back();
//        driver.get("https://demoqa.com/login");
        WebElement logOut = driver.findElement(By.id("submit"));
        logOut.click();
        Thread.sleep(4000);
        WebElement loginButton = driver.findElement(By.id("login"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");



    }

    @AfterClass
    public void afterClass() {
    driver.quit();
    }

}