import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationProcessTest {
    private final String urlStellarBurgersRegister = "https://stellarburgers.nomoreparties.site/register";

    @Test
    @DisplayName("correct registration")
    @Description("registration with correct password")
    public void registrationProcessCorrectTest() {
        //открываем страницу регистрации
        RegisterPage registerPage = open(urlStellarBurgersRegister, RegisterPage.class);
        registerPage.registerForm(Utils.randomString(10), Utils.randomString(5)+"@yandex.ru",
                Utils.randomString(6));
        LoginPage loginPage = registerPage.clickRegistration();
        $(By.xpath(".//div[@class='Auth_login__3hAey']/h2[text()='Вход']")).should(exist);
    }

    @Test
    @DisplayName("incorrect registration")
    @Description("registration with incorrect password")
    public void registrationProcessIncorrectTest(){
        //открываем страницу регистрации
        RegisterPage registerPage = open(urlStellarBurgersRegister, RegisterPage.class);
        registerPage.registerForm(Utils.randomString(10), Utils.randomString(5)+"@yandex.ru",
                Utils.randomString(5));
        registerPage.clickRegistration();
        registerPage.passwordCheck();
    }
}
