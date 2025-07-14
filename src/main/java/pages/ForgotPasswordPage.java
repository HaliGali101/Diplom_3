package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    private static final String FORGOT_USER_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private final By linkLogin = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти к странице сброса пароля")
    public void goToForgotPage() {
        driver.get(FORGOT_USER_URL);
    }

    @Step("Нажать на ссылку - Войти")
    public void clickLoginLink() {
        driver.findElement(linkLogin)
                .click();
    }
}
