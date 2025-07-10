import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends SetUp{

    @Test
    @DisplayName("Проверь переходы к разделам в конструкторе: Булки, Соусы», Начинки")
    public void constructorTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToMainPage();

        mainPage.clickChapterSouses();
        assertEquals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterBuns()
                .getAttribute("class"));
        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterSouses()
                .getAttribute("class"));
        assertEquals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterFillings()
                .getAttribute("class"));

        mainPage.clickChapterFillings();
        Thread.sleep(1000);
        assertEquals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterBuns()
                .getAttribute("class"));
        assertEquals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterSouses()
                .getAttribute("class"));
        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterFillings()
                .getAttribute("class"));

        mainPage.clickChapterBuns();
        Thread.sleep(1000);
        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterBuns()
                .getAttribute("class"));
        assertEquals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterSouses()
                .getAttribute("class"));
        assertEquals("tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect", mainPage.getChapterFillings()
                .getAttribute("class"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
