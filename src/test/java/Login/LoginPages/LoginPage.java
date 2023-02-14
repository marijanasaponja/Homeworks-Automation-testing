package Login.LoginPages;

import Login.LoginBase.LoginBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginBaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(id = "user-name")
    WebElement Username;

    public @FindBy(id = "password")
    WebElement Password;

    public @FindBy(id = "submit")
    WebElement SubmitButton;

    //--------------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void insertPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickOnSubmitButton() {
        SubmitButton.click();
    }

}
