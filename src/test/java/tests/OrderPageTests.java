package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTests extends BaseTest {

    // Параметры для теста
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final String orderButton;

    // Конструктор для получения параметров
    public OrderPageTests(String firstName, String lastName, String address, String metroStation, String phone, String orderButton) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.orderButton = orderButton;
    }

    // Определение данных для параметризации
    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "ул. Пушкина, д.1", "Комсомольская", "+79001234567", "top"},
                {"Анна", "Смирнова", "пр. Ленина, д.15", "Сокол", "+79007654321", "bottom"}
        });
    }

    @Test
    public void testOrderWithDataset() {
        MainPage mainPage = new MainPage(driver);

        // Клик по кнопке "Заказать" в зависимости от параметра
        if ("top".equals(orderButton)) {
            mainPage.clickOrderButtonTop();
        } else if ("bottom".equals(orderButton)) {
            mainPage.clickOrderButtonBottom();
        }

        // Проверка, что URL изменился на /order
        assertTrue("URL не изменился на /order", driver.getCurrentUrl().contains("/order"));

        // Заполнение формы заказа
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderForm(firstName, lastName, address, metroStation, phone);

        // Проверка, что кнопка "Далее" доступна для взаимодействия
        orderPage.clickNextButton();


//    ========================================================================================== //
//    Проверка, что после попытки оформить заказ в Chrome появляется сообщение об ошибке.
//    Тест должен падать, если ошибка оформления не отображается.
//    ========================================================================================== //
        assertTrue("Ожидалась ошибка оформления заказа в Chrome", orderPage.isErrorMessageDisplayed());
    }

}
