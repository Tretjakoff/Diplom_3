import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class RegisterPage {

    //локатор поля ввода Имени
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/fieldset[1]/div/div/" +
            "input[@class='text input__textfield text_type_main-default']")
    private SelenideElement nameField;

    //локатор поля ввода Email
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/fieldset[2]/div/div/" +
            "input[@class='text input__textfield text_type_main-default']")
    private SelenideElement emailField;

    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/fieldset[3]/div/div/" +
            "input[@class='text input__textfield text_type_main-default']")
    private SelenideElement passwordField;

    //локатор ошибки "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[@class='input__error text_type_main-default'][text()='Некорректный пароль']")
    private SelenideElement incorrectPassword;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[@class='button_button__33qZ0 button_button_type_primary" +
            "__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registrationButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement inputButton;

    //метод клика по полю ввода Имени и ввод
    public RegisterPage clickAndInputName(String name) {
        nameField.click();
        nameField.setValue(name);
        return page(RegisterPage.class);
    }

    //метод клика по полю ввода Email и ввод
    public RegisterPage clickAndInputEmail(String email) {
        emailField.click();
        emailField.setValue(email);
        return page(RegisterPage.class);
    }

    //метод клика по полю ввода пароля и ввод
    public RegisterPage clickAndInputPassword(String password) {
        passwordField.click();
        passwordField.setValue(password);
        return page(RegisterPage.class);
    }

    //метод проверки того, что появилась ошибка "Некорректный пароль"
    public void passwordCheck() {
        assertTrue(incorrectPassword.isDisplayed());
    }

    //метод клика по кнопке Зарегистрироваться
    public LoginPage clickRegistration() {
        registrationButton.click();
        return page(LoginPage.class);
    }

    //метод клика по кнопке Войти
    public LoginPage clickInput() {
        inputButton.click();
        return page(LoginPage.class);
    }

    /***
     * Вводим Имя
     * Вводим Email
     * Вводим пароль
     */
    public void registerForm(String name, String email, String password) {
          this.clickAndInputName(name)
                .clickAndInputEmail(email)
                .clickAndInputPassword(password);
    }

}
