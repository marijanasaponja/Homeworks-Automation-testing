package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {

        //Eksplicitni waiter (thread sleep) ce uvek cekati onoliko koliko zadamo komandu
        //Thread.sleep(5000) u ovom slucaju ce se uvek cekati 5 sekundi iako se element pojavi posle 1 sekunde

        //Implicitni waiter (WebDriverWait) ce cekati dok se element ne pojavi
        //Ali ce cekati najvise onoliko vremena koliko podesimo u kreiranju objekta wdwait
        //U ovom slucaju ce cekati najvise 10 sekundi na element
        //Ako se element pojavi nakon 1 sekunde onda nece cekati dalje kao thread sleep
        //Najcesci implicitni waiteri su
        //elementToBeClickable - ceka da element bude klikabilan
        //visibilityOf - ceka da element bude prisutan
        //urlToBe - ceka dok se url ne promeni

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //WebDriverWait kreiram na ovaj nacin i dajem mu komandu na kraju koliko ce maksimalno da ceka ispunjavanje uslova
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://wordpress.com/");

        WebElement loginRedirect = driver.findElement(By.linkText("Log In"));
        loginRedirect.click();

        //Thread.sleep(3000);
        //Prvo sam postavio thread sleep da proverim da li je problem do cekanja na element ili sam element
        //Kada sam utvrdio da je do cekanja onda brisem thread sleep i postavljam waiter
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));

        //Proveravam da li postoji neki jedinstven element, nalazim id i proverio sam da je jedinstven
        // (napomena: treba da bude jedinstven KAO ID,
        // ako postoji recimo name ili class sa tim nazivom onda nije problem,
        // bitno je da ne postoji drugi ID sa tim nazivom)
        WebElement emailField = driver.findElement(By.id("usernameOrEmail"));
        String username = "marijanas90";
        //String za username sam kreirao naknadno jer kada se ulogujem meni se na stranici prikaze username
        //i zelim da asertujem da na mom profilu pise moj username
        //onda kreiram string koji cu kasnije da prosledim i asertu
        //Ako se bilo koji podatak pojavljuje vise puta na testu, pametno je smestiti ga u neku promenljivu
        //Zasto? Zato sto ako sutra promenim taj username, moram da trazim gde sam sve koristio taj username
        //i da promenim na svakom mestu. Sada je to na 2 mesta samo ali sutra ce mozda biti na 20
        //Ako string cuvam u nekoj promenljivoj onda je dovoljno da promenim username na toj promenljivoj
        //i bice svuda zamenjen
        emailField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        //Program ce pasti kod ovog dela ako se ne ubaci cekanje jer program ide u potragu
        // elementa iako nije sacekao. Tokom kreiranja testa prvo ubacujemo Thread.sleep(neko vreme)
        // pa na kraju menjamo taj thread sleep sa webdriverwait-erom
        // webdriverwait ce sacekati dok se ne ispune uslovi (URL bude neki odredjen, element postane
        // vidljiv, element postane klikabilan itd. ili ce da saceka maksimalno 10 sekundi)
        //Thread.sleep(2000);
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("*M@rijana123*");

        //Kada sam hteo da trazim webelement za dugme video sam da je to isto dugme kao sto sam nasao ranije
        //da ne bih onda kreirao ponovo webelement samo cu da pozovem klik na isti.
        //Ovaj element nece biti stale jer se DOM nije promenio (ostali smo na istoj stranici) ili zato sto
        //nije se desio refresh
        continueButton.click();

        //Thread.sleep(4000);
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("site__title"))));
        WebElement profileName = driver.findElement(By.className("site__title"));

        Assert.assertEquals(profileName.getText(), username);

        //Napomena za kraj
        //Tokom pravljenja testa koristite thread sleep gde mislite da je potrebno
        //Kasnije pokrenite program bez thread sleepa i vidite gde je zapravo potrebno cekanje
        //Na mestu gde je potrebno zamenite thread sleep sa webdriverwait-om

    }
}
