package Login.LoginBase;

import Login.LoginPages.LoginPage;
import Login.LoginPages.PracticePage;
import Login.LoginPages.ProfilePage;
import Login.LoginPages.SidebarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class LoginBaseTest {
    //DDT - Data Driven Test

    //Drugi nacin kako raditi Page Object Model
    //1. Deklarisati driver da bude static
    public static WebDriver driver;
    public WebDriverWait wdwait;
    //2. ExcelReader klasu samo kopiram, ne kucam rucno metode u njoj
    //nakon toga deklarisem excelReader van svih metoda
    public ExcelReader excelReader;
    public String homeURL;
    //15. Deklarisem sve pages stranice koje sam kreirao
    //-> prelazim na Test klasu
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    //3. Kreiram metodu setUp sa anotacijom BeforeClass jer zelim da se ova metoda izvrsi na pocetku
    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        //4. Prosledjujem putanje excel fajla. Ako fajl stavim unutar projekta mogu uvek da ga dohvatim bez apsolutne putanje
        //ova putanja se pronalazi tako sto prvo ubacimo fajl u folder projekta
        //sa leve strane mogu da vidim da se nalazi fajl ispod paketa
        //desni klik na fajl -> Copy Path/Reference -> Path From Content Root
        excelReader = new ExcelReader("src/test/java/Login/TestData.xlsx");
        //5. Kreiram objekat za pocetnu stranicu odakle ce mi krenuti svaki test
        //*primeti da driver nisam inicijalizovao u ovoj metodi jer zelim da nakon svakog testa zatvorim browser
        //i pokrenem ga ponovo pri svakom testu. Da bih to uradio moram driver da inicijalizujem u BeforeMethod
        //i da ga zatvorim u AfterMethod
        //-> prelazim na klasu Test
        homeURL = excelReader.getStringData("URL", 1, 0);
    }

    //20. Kreiram pomocne metode koje ce mi mozda trebati
    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //21. Ova metoda funkcionise samo ako se elementi nalaze preko anotacija, ne preko getera
    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

}
