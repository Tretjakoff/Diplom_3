import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    //локатор кнопки Личный кабинет
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va ml-2")
    private SelenideElement personalAreaButton;

    //локатор кнопки Войти в аккаунт
    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg")
    private SelenideElement accountLoginButton;

    //локатор логотипа Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    //локатор кнопки Конструктор
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va ml-2")
    private SelenideElement constructorButton;

    //локатор раздела Булки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Булки']")
    private SelenideElement bunsButton;

    //локатор раздела Соусы
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Соусы']")
    private SelenideElement saucesButton;

    //локатор раздела Начинки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Начинки']")
    private SelenideElement fillingsButton;

    //метод клика по кнопке Личный кабинет
    public void clickPersonalArea() {
        personalAreaButton.click();
    }

    //метод клика по кнопке Войти в аккаунт
    public void clickAccountLogin() {
        accountLoginButton.click();
    }

    //метод клика по логотипу Stellar Burgers
    public void clickLogo() {
        logoButton.click();
    }

    //метод клика по кнопке Конструктор
    public void clickConstructor() {
        constructorButton.click();
    }

    //метод клика по разделу Булки
    public void clickBuns() {
        bunsButton.click();
    }

    //метод клика по разделу Соусы
    public void clickSauces() {
        saucesButton.click();
    }

    //метод клика по разделу Начинки
    public void clickFillings() {
        fillingsButton.click();
    }
}
