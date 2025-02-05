package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FAQPage {
    private WebDriver driver;

    public FAQPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQuestion(int questionIndex) {
        String questionXPath = "(//div[@data-accordion-component='Accordion']//*[contains(@class, 'accordion__button')])[" + questionIndex + "]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(questionXPath)));

        // Скролл к элементу, чтобы убедиться, что он в зоне видимости
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);

        // Клик по элементу
        question.click();
    }


    public String getAnswerText(int questionIndex) {
        String answerXPath = "(//div[@data-accordion-component='Accordion']//*[contains(@class, 'accordion__panel')])[" + questionIndex + "]";
        return driver.findElement(By.xpath(answerXPath)).getText();
    }
}
