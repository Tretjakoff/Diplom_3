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

public class GoToConstructorTest {
    Account account = new Account(Utils.randomString(10), Utils.randomString(5) + "@yandex.ru",
            Utils.randomString(10));
    private static String bearerToken;

    @Before
    public void registrationAccount() throws InterruptedException {
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
    @DisplayName("Go to constructor")
    @Description("Go to constructor using the constructor button")
    public void goToConstructorTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        ProfilePage profilePage = mainPage.clickPersonalAreaAuth();
        profilePage.clickConstructor();
        mainPage.displayAssembleBurger();
    }

    @Test
    @DisplayName("Go to constructor")
    @Description("Go to constructor using the logo")
    public void goToConstructorUsingLogoTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        ProfilePage profilePage = mainPage.clickPersonalAreaAuth();
        profilePage.clickLogo();
        mainPage.displayAssembleBurger();
    }
}
