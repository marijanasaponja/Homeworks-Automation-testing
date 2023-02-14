package WordpressSite.WordpressBase;

import WordpressSite.WordpressPages.WordpressHomepage;
import WordpressSite.WordpressPages.WordpressLoginPage;
import WordpressSite.WordpressPages.WordpressProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WordpressBaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public WordpressHomepage wordpressHomepage;
    public WordpressLoginPage wordpressLoginPage;
    public WordpressProfilePage wordpressProfilePage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wordpressHomepage = new WordpressHomepage(driver, wdwait);
        wordpressLoginPage = new WordpressLoginPage(driver, wdwait);
        wordpressProfilePage = new WordpressProfilePage(driver, wdwait);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

}
