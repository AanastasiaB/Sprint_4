package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.DriverManager;

import static org.junit.Assert.assertTrue;

public class MainPageTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver("chrome");
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

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

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
