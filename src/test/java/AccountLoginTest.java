import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Account;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public class AccountLoginTest {

    Account account = new Account(Utils.randomString(10), Utils.randomString(5) + "@yandex.ru",
            Utils.randomString(10));
    private static String bearerToken;

    @Before
    public void registrationAccount() {
        //System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver.exe");
        AccountCreator accountCreator = new AccountCreator();
        bearerToken = accountCreator.returnBearerToken(account.getName(), account.getEmail(), account.getPassword());
        //closeWindow();
    }

    @After
    public void cleanUp() throws InterruptedException {
        Response response = new Requests().deleteUser(bearerToken);
        response.then().assertThat()
                .statusCode(202)
                .body("message", Matchers.is("User successfully removed"));
        Thread.sleep(5000);
    }

    @Test
    @DisplayName("authorization through the main page")
    @Description("authorization through the main page on the button _Sign in_")
    public void accountLoginMainTest() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickAccountLogin();
        loginPage.loginForm(account.getEmail(), account.getPassword());
        loginPage.clickInput();
        mainPage.displayCheckoutButton();
    }

    @Test
    @DisplayName("authorization through the main page")
    @Description("authorization through the main page on the button _Personal Area_")
    public void accountLoginPersonalAreaTest() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAreaUnAuth();
        loginPage.loginForm(account.getEmail(), account.getPassword());
        loginPage.clickInput();
        mainPage.displayCheckoutButton();
    }

    @Test
    @DisplayName("authorization through the registration page")
    @Description("authorization through the registration page on the button _Input_")
    public void accountLoginFromRegistrationPageTest() {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties." +
                "site/register", RegisterPage.class);
        LoginPage loginPage = registerPage.clickInput();
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        mainPage.displayCheckoutButton();
    }

    @Test
    @DisplayName("authorization through the RestorePasswordPage")
    @Description("authorization through the RestorePasswordPage on the button _Input_")
    public void accountLoginFromRestorePasswordPageTest() {
        RestorePasswordPage restorePasswordPage = open("https://stellarburgers." +
                "nomoreparties.site/forgot-password", RestorePasswordPage.class);
        LoginPage loginPage = restorePasswordPage.clickInputButton();
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        mainPage.displayCheckoutButton();
    }
}
