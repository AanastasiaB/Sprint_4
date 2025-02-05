package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FAQPage;
import utils.DriverManager;

import static org.junit.Assert.assertFalse;

public class FAQTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver("chrome");
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testFAQDropDown() {
        FAQPage faqPage = new FAQPage(driver);

        for (int i = 1; i <= 8; i++) {
            faqPage.clickQuestion(i);
            String answer = faqPage.getAnswerText(i);
            assertFalse("Ответ для вопроса " + i + " пустой!", answer.isEmpty());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
