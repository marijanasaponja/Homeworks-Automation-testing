package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Selenium4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        //----------------------

        //Apsolutni xpath
        WebElement searchBar1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        //Relativni xpath
        WebElement searchBar2 = driver.findElement(By.xpath("//div/div[2]/input"));
        //Class
        WebElement searchBar3 = driver.findElement(By.className("gLFyf"));
        //Name
        WebElement searchBar4 = driver.findElement(By.name("q"));

        //------------------------

        //Prioritet za pretragu lokatora (selektora)
        //ID - najpouzdaniji jer je najmanje podlozan promenama
        //Name
        //Class
        //Css
        //Xpath - najnepouzdaniji jer je najvise podlozan promenama

        //-------------------

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Wikipedia");

        //searchBar.sendKeys(Keys.ENTER);

        List<WebElement> searchButton = driver.findElements(By.name("btnK"));
        searchButton.get(1).click();

        WebElement wikipediaPage = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaPage.click();

        WebElement wikipediaSearch = driver.findElement(By.id("searchInput"));
        wikipediaSearch.sendKeys("Nikola Tesla");

        WebElement wikipediaButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        wikipediaButton.click();

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String actualTitle = pageTitle.getText();
        String expectedTitle = "Nikola Tesla";

        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed());


    }
}
