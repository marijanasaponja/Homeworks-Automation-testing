package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {
                //Zadatak 8
//https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
//Potrebno je napraviti test dodavanja knjige u korpu
//i brisanjem samo jednog cookie-a treba da se obrise knjiga iz korpe

                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
                driver.manage().window().maximize();
                driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

                WebElement cart = driver.findElement(By.id("nav-cart-count"));
                String cartBeforeAdding = cart.getText();
                Assert.assertEquals(cartBeforeAdding, "0");

                WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
                addToCartButton.click();

                cart = driver.findElement(By.id("nav-cart-count"));
                String cartAfterAdding = cart.getText();
                Assert.assertEquals(cartAfterAdding, "1");

                driver.navigate().back();
                driver.navigate().refresh();

                cart = driver.findElement(By.id("nav-cart-count"));
                String cartAfterRefresh = cart.getText();
                Assert.assertEquals(cartAfterRefresh, "1");

                driver.manage().deleteCookieNamed("session-id");
                driver.navigate().refresh();
                driver.navigate().refresh();

                cart = driver.findElement(By.id("nav-cart-count"));
                String cartAfterDelete = cart.getText();
                Assert.assertEquals(cartAfterDelete, "0");

                WebElement goToCartButton = driver.findElement(By.id("nav-cart"));
                goToCartButton.click();

                WebElement notification = driver.findElement(By.cssSelector(".a-row.sc-your-amazon-cart-is-empty"));
                Assert.assertTrue(notification.isDisplayed());

            }
        }

