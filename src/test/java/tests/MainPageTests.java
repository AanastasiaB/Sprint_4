package tests;

import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class MainPageTests extends BaseTest {

    @Test
    public void testOrderButtonTop() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonTop();

        // Проверка, что URL изменился на /order
        assertTrue(driver.getCurrentUrl().contains("/order"));
    }

    @Test
    public void testOrderButtonBottom() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonBottom();

        // Проверка, что URL изменился на /order
        assertTrue(driver.getCurrentUrl().contains("/order"));
    }
}
