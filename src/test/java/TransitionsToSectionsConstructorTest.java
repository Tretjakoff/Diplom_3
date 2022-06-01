import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Account;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TransitionsToSectionsConstructorTest {
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
        Thread.sleep(10000);
    }

    @Test
    @DisplayName("Choice of section of buns")
    @Description("Choose a section and check")
    public void choiceOfSectionWithBunsTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        mainPage.clickSauces()
                .clickBuns();
        assertTrue("Bun section not selected", mainPage.displayBunsText());
    }

    @Test
    @DisplayName("Choice of section with sauces")
    @Description("Choose a section and check")
    public void choiceOfSectionWithSaucesTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        mainPage.clickSauces();
        assertTrue("Sauce section not selected", mainPage.displaySaucesText());
    }

    @Test
    @DisplayName("Choice of section with fillings")
    @Description("Choose a section and check")
    public void choiceOfSectionWithFillingsTest() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginForm(account.getEmail(), account.getPassword());
        MainPage mainPage = loginPage.clickInput();
        mainPage.clickFillings();
        assertTrue("Toppings section not selected", mainPage.displayFillingsText());
    }
}
