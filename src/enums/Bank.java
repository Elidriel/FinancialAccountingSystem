package enums;

/**
 * Класс предназначен для выбора банка (используется для работы с классом PaymentCard)
 */
public enum Bank {
    SBER("Сбербанк России"),
    TINKOFF("Тинькофф Банк"),
    ALFA("Альфа-Банк"),
    VTB("Банк ВТБ");

    private final String bankCode;

    Bank(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }


}
