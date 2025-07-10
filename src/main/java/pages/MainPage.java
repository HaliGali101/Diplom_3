package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;
    private final String mainPageUrl = "https://stellarburgers.nomoreparties.site/";

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By buttonCreateOrder = By.xpath("//button[text()='Оформить заказ']");
    private final By buttonPersonalAccount = By.xpath("//p[text()='Личный Кабинет']");
    private final By headerCreateBurger = By.xpath("//h1[text()='Соберите бургер']");
    private final By chapterSouses = By.xpath("//span[text()='Соусы']/..");
    private final By chapterBuns = By.xpath("//span[text()='Булки']/..");
    private final By chapterFillings = By.xpath("//span[text()='Начинки']/..");
    private final By headerSouses = By.xpath("//h2[text()='Соусы']");
    private final By headerBuns = By.xpath("//h2[text()='Булки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    @Step("Перейти к главной странице приложения")
    public void goToMainPage(){
        driver.get(mainPageUrl);
    }

    @Step("Нажать на кнопку - Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton)
                .click();
    }

    @Step("Нажать на кнопку - Личный кабинет")
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount)
                .click();
    }

    @Step("Нажать на раздел - Соусы")
    public void clickChapterSouses() {
        driver.findElement(chapterSouses)
                .click();
    }

    @Step("Нажать на раздел - Булки")
    public void clickChapterBuns() {
        driver.findElement(chapterBuns)
                .click();
    }

    @Step("Нажать на раздел - Начинки")
    public void clickChapterFillings() {
        driver.findElement(chapterFillings)
                .click();
    }

    public boolean isButtonCreateOrder() {
        return driver.findElement(buttonCreateOrder)
                .isDisplayed();
    }

    public boolean isLoginButton() {
        return driver.findElements(loginButton).isEmpty();
    }

    public boolean isHeaderCreateBurger() {
        return driver.findElement(headerCreateBurger)
                .isDisplayed();
    }

    public WebElement getChapterSouses() {
        return driver.findElement(chapterSouses);
    }

    public WebElement getChapterBuns() {
        return driver.findElement(chapterBuns);
    }

    public WebElement getChapterFillings() {
        return driver.findElement(chapterFillings);
    }
}
