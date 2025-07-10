import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import pojo.User;
import steps.ApiSteps;
import testDataGenerator.GetUserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTests extends SetUp {

    private User user;
    private String currentUrl;

    @Before
    public void setUp() {
        user = GetUserData.getUser();
        ApiSteps.createUser(user);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void mainOnButtonLoginInMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.setInputEmail(user.getEmail());
        loginPage.setInputPassword(user.getPassword());
        loginPage.clickButtonLogin();

        assertThat(mainPage.isButtonCreateOrder(), equalTo(true));
        assertThat(mainPage.isLoginButton(), equalTo(true));
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginOnPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.setInputEmail(user.getEmail());
        loginPage.setInputPassword(user.getPassword());
        loginPage.clickButtonLogin();

        assertThat(mainPage.isButtonCreateOrder(), equalTo(true));
        assertThat(mainPage.isLoginButton(), equalTo(true));
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPage() {
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.goToRegistrationPage();

        regPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.setInputEmail(user.getEmail());
        loginPage.setInputPassword(user.getPassword());
        loginPage.clickButtonLogin();

        MainPage mainPage = new MainPage(driver);
        assertThat(mainPage.isButtonCreateOrder(), equalTo(true));
        assertThat(mainPage.isLoginButton(), equalTo(true));
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loinFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.goToForgotPage();

        forgotPasswordPage.clickLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.setInputEmail(user.getEmail());
        loginPage.setInputPassword(user.getPassword());
        loginPage.clickButtonLogin();

        MainPage mainPage = new MainPage(driver);
        assertThat(mainPage.isButtonCreateOrder(), equalTo(true));
        assertThat(mainPage.isLoginButton(), equalTo(true));
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
        ApiSteps.deleteUser(user.getEmail(), user.getPassword());

    }
}
