import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Account;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationProcessTest {
    private final String urlStellarBurgersRegister = "https://stellarburgers.nomoreparties.site/register";
    Account correct = new Account(Utils.randomString(10), Utils.randomString(5) + "@yandex.ru",
            Utils.randomString(6));
    private static String bearerToken;

    @Before
    public void registrationAccount() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver.exe");
        AccountCreator accountCreator = new AccountCreator();
        bearerToken = accountCreator.returnBearerToken(correct.getName(), correct.getEmail(), correct.getPassword());
        //closeWindow();
    }

    @After
    public void cleanUp() throws InterruptedException {
        Response response = new Requests().deleteUser(bearerToken);
        response.then().assertThat()
                .statusCode(202)
                .body("message", Matchers.is("User successfully removed"));
        Thread.sleep(10000);
        //closeWindow();
    }

    @Test
    @DisplayName("correct registration")
    @Description("registration with correct password")
    public void registrationProcessCorrectTest() {
        //открываем страницу регистрации
        RegisterPage registerPage = open(urlStellarBurgersRegister, RegisterPage.class);
        registerPage.registerForm(Utils.randomString(10), Utils.randomString(5) + "@yandex.ru",
                Utils.randomString(6));
        LoginPage loginPage = registerPage.clickRegistration();
        loginPage.displayInput();
    }

    @Test
    @DisplayName("incorrect registration")
    @Description("registration with incorrect password")
    public void registrationProcessIncorrectTest() {
        //открываем страницу регистрации
        RegisterPage registerPage = open(urlStellarBurgersRegister, RegisterPage.class);
        registerPage.registerForm(Utils.randomString(10), Utils.randomString(5) + "@yandex.ru",
                Utils.randomString(5));
        registerPage.clickRegistration();
        registerPage.passwordCheck();
    }
}
