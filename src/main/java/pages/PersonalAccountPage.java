package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By iconProfile = By.xpath("//a[text()='Профиль']");
    private final By buttonLogOut = By.xpath("//button[text()='Выход']");

    @Step("Нажать на кнопку - Выход")
    public void clickButtonLogOut() {
        driver.findElement(buttonLogOut)
                .click();
    }

    public boolean isIconProfile() {
        return driver.findElement(iconProfile)
                .isDisplayed();
    }

    public boolean isButtonLogOut() {
        return driver.findElement(buttonLogOut)
                .isDisplayed();
    }
}
