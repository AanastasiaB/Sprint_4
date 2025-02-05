package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Поля формы
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath("//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By metroOption; // Будет динамически заполняться
    private By nextButton = By.xpath("//button[text()='Далее']");

    // Конструктор
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для заполнения имени
    public void setName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    // Метод для заполнения фамилии
    public void setSurname(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameField)).sendKeys(surname);
    }

    // Метод для заполнения адреса
    public void setAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField)).sendKeys(address);
    }

    // Метод для выбора станции метро
    public void selectMetroStation(String metroStation) {
        wait.until(ExpectedConditions.elementToBeClickable(metroField)).click();
        metroOption = By.xpath("//div[text()='" + metroStation + "']");
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(metroOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
        optionElement.click();
    }

    // Метод для заполнения телефона
    public void setPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    // Метод для нажатия кнопки "Далее"
    public void clickNextButton() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Далее']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
    }


    // Метод для заполнения всей формы заказа
    public void fillOrderForm(String firstName, String lastName, String address, String metroStation, String phone) {
        setName(firstName);
        setSurname(lastName);
        setAddress(address);
        selectMetroStation(metroStation);
        setPhone(phone);
    }
}
