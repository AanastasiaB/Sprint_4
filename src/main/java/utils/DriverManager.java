package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver getDriver(String browser) {
        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions(); // Помогает легче работать браузеру и тестам
            options.addArguments("--disable-dev-shm-usage"); // Использование диска вместо памяти
            options.addArguments("--no-sandbox"); // Запуск без песочницы
            options.addArguments("--remote-allow-origins=*"); // Разрешение удаленных запросов
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // Устанавливаем полноэкранный режим
        driver.manage().window().maximize();

        return driver;
    }
}
