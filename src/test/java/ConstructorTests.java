import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends SetUp{

    @Test
    @DisplayName("Проверь переходы к разделам в конструкторе: Булки, Соусы», Начинки")
    public void constructorSelectSousesTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();

        mainPage.clickChapterSouses();
        assertEquals(mainPage.getStateUnSelectedElement(), mainPage.getChapterBuns()
                .getAttribute("class"));
        assertEquals(mainPage.getStateSelectedElement(), mainPage.getChapterSouses()
                .getAttribute("class"));
        assertEquals(mainPage.getStateUnSelectedElement(), mainPage.getChapterFillings()
                .getAttribute("class"));
    }

    @Test
    @DisplayName("Проверь переходы к разделам в конструкторе: Булки, Соусы», Начинки")
    public void constructorSelectFillingsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();

        mainPage.clickChapterFillings();
        assertEquals(mainPage.getStateUnSelectedElement(), mainPage.getChapterBuns()
                .getAttribute("class"));
        assertEquals(mainPage.getStateUnSelectedElement(), mainPage.getChapterSouses()
                .getAttribute("class"));
        assertEquals(mainPage.getStateSelectedElement(), mainPage.getChapterFillings()
                .getAttribute("class"));
    }

    @Test
    @DisplayName("Проверь переходы к разделам в конструкторе: Булки, Соусы», Начинки")
    public void constructorSelectBunsTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();

        mainPage.clickChapterSouses();
        Thread.sleep(1000);

        mainPage.clickChapterBuns();
        Thread.sleep(1000);
        assertEquals(mainPage.getStateSelectedElement(), mainPage.getChapterBuns()
                .getAttribute("class"));
        assertEquals(mainPage.getStateUnSelectedElement(), mainPage.getChapterSouses()
                .getAttribute("class"));
        assertEquals(mainPage.getStateUnSelectedElement(), mainPage.getChapterFillings()
                .getAttribute("class"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
