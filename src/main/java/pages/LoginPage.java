package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    private final WebDriver driver;

    private final By pageHeader = By.xpath("//h2[text()='Вход']");
    private final By inputEmail = By.xpath("//label[text()='Email']/following-sibling::input[1]");
    private final By inputPassword = By.xpath("//label[text()='Пароль']/following-sibling::input[1]");
    private final By buttonLogin = By.xpath("//button[text()='Войти']");
    private final By linkConstructor = By.xpath("//p[text()='Конструктор']");
    private final By appIcon = By.xpath("//div[@class=\"AppHeader_header__logo__2D0X2\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageHeader() {
        return driver.findElement(pageHeader).isDisplayed();
    }

    public static String getLoginPageUrl() {
        return LOGIN_PAGE_URL;
    }

    @Step("Перейти к странице авторизации")
    public void goToLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }
    @Step("Ввести в поле Email - email пользователя")
    public void setInputEmail(String email) {
        driver.findElement(inputEmail)
                .sendKeys(email);
    }

    @Step("Ввести в поле Пароль - пароль пользователя")
    public void setInputPassword(String password) {
        driver.findElement(inputPassword)
                .sendKeys(password);
    }

    @Step("Нажать на кнопку - Войти")
    public void clickButtonLogin() {
        driver.findElement(buttonLogin)
                .click();
    }

    @Step("Нажать на ссылку - Конструктор")
    public void clickLinkConstructor() {
        driver.findElement(linkConstructor)
                .click();
    }

    @Step("Нажать на иконку приложения")
    public void clickAppIcon() {
        driver.findElement(appIcon)
                .click();
    }

    public String getPageUrl() {
        return LOGIN_PAGE_URL;
    }
}
