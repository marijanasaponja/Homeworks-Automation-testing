package WordpressSite.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressLoginPage {
    public WebDriver driver;
    public WebDriverWait wdwait;


    public WordpressLoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    WebElement usernameField;
    WebElement passwordField;
    WebElement continueButton;


    public WebElement getUsernameField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    //-----------------------------------------

    public void insertUsername(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void insertPassword(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnContinueButton() {
        getContinueButton().click();
    }

}

