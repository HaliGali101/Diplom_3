import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoToConstructorFromPersonalAccountPageTests extends SetUp{

    private String currentUrl;

    @Test
    @DisplayName("Проверь переход по клику на «Конструктор»")
    public void goToMainPageWithLinkConstructor() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.clickLinkConstructor();

        MainPage mainPage = new MainPage(driver);
        assertThat(mainPage.isHeaderCreateBurger(), equalTo(true));
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);

    }

    @Test
    @DisplayName("Проверь переход по клику на логотип Stellar Burgers")
    public void goToMainPageWithAppIcon() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);

        loginPage.clickAppIcon();

        MainPage mainPage = new MainPage(driver);
        assertThat(mainPage.isHeaderCreateBurger(), equalTo(true));
        currentUrl = driver.getCurrentUrl();
        assertEquals(mainPage.getMainPageUrl(), currentUrl);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
