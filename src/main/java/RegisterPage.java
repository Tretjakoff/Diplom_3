import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    //локатор поля ввода Имени
    @FindBy(how = How.XPATH, using = ".//label[@class = 'input__placeholder text noselect text_type_main-default'][text()='Имя']")
    private SelenideElement nameField;

    //локатор поля ввода Email
    @FindBy(how = How.XPATH, using = ".//label[@class = 'input__placeholder text noselect text_type_main-default'][text()='Email']")
    private SelenideElement emailField;

    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//label[@class = 'input__placeholder text noselect text_type_main-default'][text()='Пароль']")
    private SelenideElement passwordField;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa")
    private SelenideElement registrationButton;

    //локатор кнопки "Войти"
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
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

    //метод клика по кнопке Зарегистрироваться
    public void clickRegistration() {
        registrationButton.click();
    }

    //метод клика по кнопке Войти
    public void clickInput() {
        inputButton.click();
    }

}
