import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RestorePasswordPage {
    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement inputButton;

    //метод клика по кнопке "Войти"
    public LoginPage clickInputButton() {
        inputButton.click();
        return page(LoginPage.class);
    }
}
