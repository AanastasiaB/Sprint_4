package utils;

// ========================================================================================= //
// Enum для хранения конфигурационных параметров (например, BASE_URL).
// Позволяет централизованно управлять настройками без дублирования кода.
// ========================================================================================= //

public enum Config {
    BASE_URL("https://qa-scooter.praktikum-services.ru/");

    private final String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
