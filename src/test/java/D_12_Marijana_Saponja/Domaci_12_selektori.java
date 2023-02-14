package D_12_Marijana_Saponja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci_12_selektori {
    public static void main(String[] args) throws InterruptedException {
        // Otici na YouTube preko Google-a i pustiti pesmu po Vasem izboru.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("youtube");
        searchBar.sendKeys(Keys.ENTER);

        WebElement youtube = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        youtube.click();
        Thread.sleep(2000);

        WebElement searchYoutube = driver.findElement(By.name("search_query"));
        searchYoutube.sendKeys("Ponoc muzika iz filma Toma");

        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement findSong= driver.findElement(By.cssSelector(".style-scope.ytd-video-renderer"));
        Thread.sleep(2000);
        findSong.click();

        Thread.sleep(200000);
        driver.quit();

    }
}
