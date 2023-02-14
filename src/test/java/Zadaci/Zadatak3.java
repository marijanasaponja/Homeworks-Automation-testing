package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement wikipediaPage = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a"));
        wikipediaPage.click();

        Thread.sleep(2000);

        WebElement wikipediaSearch = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"));
        wikipediaSearch.sendKeys("Nikola Tesla");

        Thread.sleep(2000);

        WebElement wikipediaButton = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/button/i"));
        wikipediaButton.click();

        Thread.sleep(2000);

        driver.quit();


    }
}