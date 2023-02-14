package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) {
        //Zadatak 7 - Ulogovati se na sajt https://demoqa.com/ preko kolacica, izlogovati se i asertovati da je korisnik izlogovan

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        Cookie cookie1 = new Cookie("userName", "marijanas90");
        driver.manage().addCookie(cookie1);
        Cookie cookie2 = new Cookie("userID","87ece40a-793c-4543-8beb-c587f75de20b");
        driver.manage().addCookie(cookie2);
        Cookie cookie3 = new Cookie("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmlqYW5hczkwIiwicGFzc3dvcmQiOiIqTUByaWphbmExMjMqIiwiaWF0IjoxNjczNTUwMTkxfQ.h8XHWxb8f8jEx9Q4OtlKOBqUMMfHUAvDEU4c38AEK9o");
        driver.manage().addCookie(cookie3);
        Cookie cookie4 = new Cookie("expires","2023-01-19T19%3A03%3A11.667Z");
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();

        WebElement profileButton = driver.findElement(By.linkText("profile"));
        profileButton.click();

        WebElement profileName = driver.findElement(By.id("userName-value"));
        Assert.assertEquals(profileName.getText(), "dragoljubqa");

        List<WebElement> button = driver.findElements(By.id("submit"));
        for (int i = 0; i < button.size(); i++) {
            if (button.get(i).getText().equals("Log out")) {
                button.get(i).click();
                break;
            }
        }

        boolean logOutButtonIsDisplayed = false;
        boolean usernameIsDisplayed = false;
        try {
            logOutButtonIsDisplayed = driver.findElement(By.id("submit")).isDisplayed();
        } catch (Exception e) {

        }

        try {
            usernameIsDisplayed = driver.findElement(By.id("submit")).isDisplayed();
        } catch (Exception e) {

        }

        Assert.assertFalse(logOutButtonIsDisplayed);
        Assert.assertFalse(usernameIsDisplayed);

//        Moguce tehnicko pitanje na intervjuu: Koja je razlika izmedju eksplicitnog i implicitnog cekanja?
//        Odgovor je u prethodnoj klasi na pocetku zakomentarisano
//        Ukratko: Eksplicitni ce uvek da ceka koliko vremena zadamo. Implicitni ce cekati dok se uslov ne ispuni ili dok ne istekne

    }
}
