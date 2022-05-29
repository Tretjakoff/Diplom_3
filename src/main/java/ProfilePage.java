import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {
    //локатор раздела "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[@class='Account_link__2ETsJ text text_type_main-" +
            "medium text_color_inactive Account_link_active__2opc9'][text()='Профиль']")
    private SelenideElement profileButton;

    //локатор логотипа Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    //локатор кнопки Конструктор
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private SelenideElement constructorButton;

    //метод проверки того, что отобразилась кнопка "Оформить заказ"
    public void displayProfileButton() {
        profileButton.should(exist);
    }

    //метод клика по логотипу Stellar Burgers
    public MainPage clickLogo() {
        logoButton.click();
        return page(MainPage.class);
    }

    //метод клика по кнопке Конструктор
    public MainPage clickConstructor() {
        constructorButton.click();
        return page(MainPage.class);
    }
}
