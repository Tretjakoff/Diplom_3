import io.restassured.response.Response;
import model.Login;

import static com.codeborne.selenide.Selenide.open;

public class AccountCreator {
    private static String bearerToken;
    public String returnBearerToken(String name, String email, String password) throws InterruptedException {
        RegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register",
                RegisterPage.class);
        registerPage.registerForm(name, email, password);
        registerPage.clickRegistration();
        Response response = new Requests().loginUser(new Login(email, password));
        Thread.sleep(10000);
        response.then().assertThat()
                .statusCode(200);
        if (response.statusCode() == 200) {
            bearerToken = response.jsonPath().getString("accessToken").replace("Bearer ", "");
        }
        return bearerToken;
    }
}
