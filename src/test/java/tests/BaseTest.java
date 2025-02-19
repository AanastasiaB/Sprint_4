package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.Config;
import utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver("chrome");
        driver.get(Config.BASE_URL.getValue());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
