//package Zadaci;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Zadatak9 {
//    public static void main(String[] args) throws InterruptedException {
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://imgflip.com/memegenerator");
//
//        WebElement uploadTemplate = driver.findElement(By.id("mm-show-upload"));
//        uploadTemplate.click();
//
//        WebElement uploadImage = driver.findElement(By.id("mm-upload-file"));
//        uploadImage.sendKeys("C:\\Users\\HP\\Desktop\\meme.jpg");
//
//        WebElement upload = driver.findElement(By.id("mm-upload-btn"));
//        upload.click();
//        WebElement topText = driver.findElement(By.className("mm-text"));
//        topText.sendKeys("me after i finish my qa homework");
//
//        WebElement generateMeme = driver.findElement(By.cssSelector(".mm-generate.b.but"));
//        generateMeme.click();
//        Thread.sleep(3000);
//        WebElement goToImage = driver.findElement(By.partialLinkText("Go to image page"));
//        goToImage.click();
//
//
//    }
//}
package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak9 {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://imgflip.com/memegenerator");

        String location = "C:\\Users\\drago\\Desktop\\thread.jpg";

        WebElement uploadTemplate = driver.findElement(By.id("mm-show-upload"));
        uploadTemplate.click();

        WebElement uploadPicture = driver.findElement(By.id("mm-upload-file"));
        uploadPicture.sendKeys(location);

        WebElement uploadButton = driver.findElement(By.id("mm-upload-btn"));
        uploadButton.click();

        List<WebElement> textbox = driver.findElements(By.className("mm-text"));
        textbox.get(0).sendKeys("Kada podesis thread sleep na godine umesto na milisekunde");

        WebElement generateMeme = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateMeme.click();

        //-----------------------------------

        //Save image
        WebElement meme = driver.findElement(By.id("done-img"));
        wdwait.until(ExpectedConditions.attributeContains(meme, "src", "imgflip.com"));
        String link = meme.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage, "png", new File("C:\\Users\\drago\\Desktop\\meme.png"));

    }
}