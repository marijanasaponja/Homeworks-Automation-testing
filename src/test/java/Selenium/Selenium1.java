package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //obavezna su ova prva tri koraka !!!
        //driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());


        driver.quit();

    }
}
