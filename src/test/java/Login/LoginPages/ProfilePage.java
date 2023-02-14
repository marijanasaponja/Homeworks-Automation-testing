package Login.LoginPages;

import Login.LoginBase.LoginBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends LoginBaseTest {
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(linkText = "Log out")
    WebElement LogOutButton;
}
