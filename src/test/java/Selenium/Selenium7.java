package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium7 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://crop-circle.imageonline.co/#circlecropresult");

        WebElement uploadButton = driver.findElement(By.id("inputImage"));
        uploadButton.sendKeys("C:\\Users\\drago\\Desktop\\map.png");

    }
}