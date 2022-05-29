import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class LoginPage {
    //локатор поля ввода Email
    @FindBy(how = How.XPATH, using = ".//input[@class = 'text input__textfield text_type_main-default'][@name = 'name']")
    private SelenideElement emailField;

    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@class = 'text input__textfield text_type_main-default'][@name = 'Пароль']")
    private SelenideElement passwordField;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_" +
            "button_type_primary__1O7Bx button_button_size_medium__3zxIa'][text()='Войти']")
    private SelenideElement inputButton;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //локатор кнопки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private SelenideElement restorePasswordButton;

    //локатор текста "Вход"
    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/h2[text()='Вход']")
    private SelenideElement textInput;

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
    public MainPage clickInput() {
        inputButton.click();
        return page(MainPage.class);
    }

    //метод клика по кнопке "Зарегистрироваться"
    public void clickRegistration() {
        registrationButton.click();
    }

    //метод клика по кнопке "Восстановить пароль"
    public RegisterPage clickRestorePassword() {
        restorePasswordButton.click();
        return page(RegisterPage.class);
    }

    //метод проверки того, что отобразилось слово "Вход"
    public void displayInput() {
        assertTrue(textInput.isDisplayed());
    }

    /***
     * Вводим Email
     * Вводим пароль
     */
    public void loginForm(String email, String password) {
        this.clickAndInputEmail(email)
                .clickAndInputPassword(password);
    }
}
