package D_12_Marijana_Saponja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci_12_xPath {
    public static void main(String[] args) throws InterruptedException {
       // Otici na YouTube preko Google-a i pustiti pesmu po Vasem izboru.


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchBox.sendKeys("youtube");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement youtube = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/a"));
        Thread.sleep(2000);
        youtube.click();

        WebElement searchSong = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        searchSong.sendKeys("Ponoc pesma iz filma Toma");

        WebElement searchButton= driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/button"));
        searchButton.click();
        Thread.sleep(2000);

        WebElement playSong = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div[2]/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a"));
        Thread.sleep(2000);
        playSong.click();
        Thread.sleep(200000);

        driver.quit();
    }
}
