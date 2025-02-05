package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    // Локаторы
    private By orderButtonTop = By.cssSelector("button.Button_Button__ra12g");
    private By orderButtonBottom = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonTop() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ждать до 10 секунд
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonTop)).click();
    }

    public void clickOrderButtonBottom() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(orderButtonBottom));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

}
