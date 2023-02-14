package Login.LoginPages;

import Login.LoginBase.LoginBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SidebarPage extends LoginBaseTest {
    //11. Svaka page klasa ekstenduje BaseTest klasu
    //12. Kreiram konstruktor gde pozivam PageFactory kako bih mogao da inicijalizujem elemente

    public SidebarPage() {
        PageFactory.initElements(driver, this);
    }

    //13. Elemente trazim preko anotacija
    public @FindBy (id = "menu-item-20")
    WebElement PracticeButton;

    //----------------------
    //14. Odvajam delove gde trazim elemente i gde pravim metode za neke akcije
    //-> prelazim na kreiranje ostalih klasa stranica -> PracticePage, LoginPage, ProfilePage
    //-> nakon toga vracam se na BaseTest klasu

    public void clickOnPracticeButton() {
        PracticeButton.click();
    }

}
