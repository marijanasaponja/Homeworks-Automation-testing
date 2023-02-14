package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(0));
        driver.get("https://www.google.com");

        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.youtube.com");

        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://www.linkedin.com");

        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://www.joberty.rs");

        for (int i = 1 ; i < listaTabova.size(); i++) {
            driver.switchTo().window(listaTabova.get(i)).close();
        }
        driver.quit();

        //0 - 1
        //0 - 2 - 1
        //0 - 3 - 2 - 1
    }
}
