import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import pojo.User;
import steps.ApiSteps;
import testDataGenerator.GetUserData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogOutTests extends SetUp {

    private User user;
    private String currentUrl;

    @Before
    public void setUp() {
        user = GetUserData.getUser();
        ApiSteps.createUser(user);
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void logOut() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.setInputEmail(user.getEmail());
        loginPage.setInputPassword(user.getPassword());
        loginPage.clickButtonLogin();

        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isHeaderCreateBurger());
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);

        mainPage.clickButtonPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        assertTrue(personalAccountPage.isIconProfile());
        assertTrue(personalAccountPage.isButtonLogOut());

        personalAccountPage.clickButtonLogOut();

        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
        ApiSteps.deleteUser(user.getEmail(), user.getPassword());
    }
}
