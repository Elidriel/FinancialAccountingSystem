package enums;

/**
 * Класс предназначен для выбора валюты (используется для работы с классами PaymentCard, Wallet, PlannedMajorExpenses)
 * На настоящий момент программа находится на бета-тестировании, в связи с чем в программе юзабельны только рубли
 */
public enum Currency {
    RUB( "рубль"),
    USD("доллар"),
    BTC("биткоин");

    private final String currencyCode;

    Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
