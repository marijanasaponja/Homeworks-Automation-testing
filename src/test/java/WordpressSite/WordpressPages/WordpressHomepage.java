package WordpressSite.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressHomepage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement LogInButton;

    public WordpressHomepage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogInButton() {
        return driver.findElement(By.linkText("Log In"));
    }

    //---------------------------------------------------

    public void clickOnLogInButton() {
        getLogInButton().click();
    }
}
