import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    //локатор поля ввода Email
    @FindBy(how = How.XPATH, using = ".//input[@class = 'text input__textfield text_type_main-default'][@name = 'name']")
    private SelenideElement emailField;

    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@class = 'text input__textfield text_type_main-default'][@name = 'Пароль']")
    private SelenideElement passwordField;

    //локатор кнопки "Вход"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa")
    private SelenideElement inputButton;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement registrationButton;

    //локатор кнопки "Восстановить пароль"
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement restorePasswordButton;

    //метод клика по полю ввода Email и ввод
    public LoginPage clickAndInputEmail(String email) {
        emailField.click();
        emailField.setValue(email);
        return page(LoginPage.class);
    }

    //метод клика по полю ввода пароля и ввод
    public LoginPage clickAndInputPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);
        return page(LoginPage.class);
    }

    //метод клика по кнопке Войти
    public void clickInput() {
        inputButton.click();
    }

    //метод клика по кнопке "Зарегистрироваться"
    public void clickRegistration() {
        registrationButton.click();
    }

    //метод клика по кнопке "Восстановить пароль"
    public void clickRestorePassword() {
        restorePasswordButton.click();
    }
}
