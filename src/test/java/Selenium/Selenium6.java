package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium6 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        Cookie cookie = new Cookie("wordpress_logged_in", "dragoljubqa%7C1768157022%7Cm8TwCT57w5iun6LeU24iL8M7Seo1c9R73ZYHzOJsB48%7Caab2e1e41f6382b67b919d5e052932d0857059fdaaa3acc13788482b39404206");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}