package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;
    private final String registerPageUrl = "https://stellarburgers.nomoreparties.site/register";

    private final By inputName = By.xpath("//label[text()='Имя']/following-sibling::input[1]");
    private final By inputEmail = By.xpath("//label[text()='Email']/following-sibling::input[1]");
    private final By inputPassword = By.xpath("//label[text()='Пароль']/following-sibling::input[1]");
    private final By buttonRegistration = By.xpath("//button[text()='Зарегистрироваться']");
    private final By incorrectPasswordMessage = By.xpath("//p[text()='Некорректный пароль']");
    private final By linkLogin = By.xpath("//a[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти к странице регистрации")
    public void goToRegistrationPage() {
        driver.get(registerPageUrl);
    }

    @Step("Ввести в поле Имя - имя пользователя")
    public void setUserName(String userName) {
        driver.findElement(inputName)
                .sendKeys(userName);
    }

    @Step("Ввести в поле Email - email пользователя")
    public void setUserEmail(String userEmail) {
        driver.findElement(inputEmail)
                .sendKeys(userEmail);
    }

    @Step("Ввести в поле Пароль - пароль пользователя")
    public void setUserPassword(String userPassword) {
        driver.findElement(inputPassword)
                .sendKeys(userPassword);
    }

    @Step("Нажать на кнопку - Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(buttonRegistration)
                .click();
    }

    @Step("Нажать на ссылку - Войти")
    public void clickLoginLink() {
        driver.findElement(linkLogin)
                .click();
    }

    public boolean isMessage() {
        return driver.findElement(incorrectPasswordMessage).isDisplayed();
    }

    public String getMessageText() {
        return driver.findElement(incorrectPasswordMessage).getText();
    }

    public String getPageUrl() {
        return registerPageUrl;
    }


}
