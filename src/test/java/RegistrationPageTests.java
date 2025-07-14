
import io.qameta.allure.junit4.DisplayName;
import pages.LoginPage;
import pages.RegistrationPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.User;
import steps.ApiSteps;
import testdatagenerator.GetUserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationPageTests extends SetUp {

    private User user;
    private boolean isUser;
    private String currentUrl;

    @Before
    public void setUp() {
        user = GetUserData.getUser();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void userRegistration() {
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.goToRegistrationPage();
        currentUrl = driver.getCurrentUrl();
        assertEquals(regPage.getPageUrl(), currentUrl);

        regPage.setUserName(user.getName());
        regPage.setUserEmail(user.getEmail());
        regPage.setUserPassword(user.getPassword());
        regPage.clickRegistrationButton();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        isUser = true;
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void userRegistrationWithIncorrectPassword() {
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.goToRegistrationPage();
        currentUrl = driver.getCurrentUrl();
        assertEquals(regPage.getPageUrl(), currentUrl);

        regPage.setUserName(user.getName());
        regPage.setUserEmail(user.getEmail());
        regPage.setUserPassword("12345");
        regPage.clickRegistrationButton();

        assertThat(regPage.isMessage(), equalTo(true));
        assertThat(regPage.getMessageText(), equalTo("Некорректный пароль"));

        isUser = false;
    }

    @After
    public void tearDown() {
        driver.quit();
        if(isUser) {
            ApiSteps.deleteUser(user.getEmail(), user.getPassword());
        }
    }
}
