import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoToPersonalAccountFromMainPageTests extends SetUp{

    private String currentUrl;

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверь переход по клику на «Личный кабинет»")
    public void loinOnPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();
        mainPage.clickButtonPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isPageHeader());
        currentUrl = driver.getCurrentUrl();
        assertEquals(LoginPage.getLoginPageUrl(), currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
