package Internet.Base;

import Internet.Pages.InternetHomepage;
import Internet.Pages.KeyPressesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class InternetBaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public InternetHomepage internetHomepage;
    public KeyPressesPage keyPressesPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        internetHomepage = new InternetHomepage(driver, wdwait);
        keyPressesPage = new KeyPressesPage(driver, wdwait);
    }



    @AfterClass
    public void tearDown(){
        //driver.quit;
    }
}
