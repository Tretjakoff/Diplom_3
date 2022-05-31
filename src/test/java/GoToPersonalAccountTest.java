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

public class GoToPersonalAccountTest {
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
        Thread.sleep(4000);
    }

    @Test
    @DisplayName("Go to personal account")
    @Description("Going to the personal account of an authorized user")
    public void goToPersonalAccountTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        ProfilePage profilePage = mainPage.clickPersonalAreaAuth();
        profilePage.displayProfileButton();
    }

    @Test
    @DisplayName("Go to personal account without auth")
    @Description("Going to the personal account of an unauthorized user")
    public void goToPersonalAccountWithoutAuthTest() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAreaUnAuth();
        loginPage.displayInput();
    }
}
