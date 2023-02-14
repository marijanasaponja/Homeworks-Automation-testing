package Internet.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyPressesPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement InputField;
    WebElement Notification;


    public KeyPressesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getInputField() {
        return driver.findElement(By.id("target"));
    }
    public WebElement getNotification() {
        return driver.findElement(By.id("result"));
    }
    //-----------------------------

    public void clickOnInputField(){
        getInputField().click();
    }

    public void sendKeys(String key){
        getInputField().sendKeys(key);
    }


}
