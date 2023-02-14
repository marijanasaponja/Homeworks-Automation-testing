package Login.LoginPages;

import Login.LoginBase.LoginBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePage extends LoginBaseTest {

    public PracticePage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy (linkText = "Test Login Page")
    WebElement TestLoginPageButton;

    //-------------------------

    public void clickOnTestLoginPageButton() {
        TestLoginPageButton.click();
    }
}
