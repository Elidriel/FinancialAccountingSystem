package enums;

/**
 * Класс предназначен для выбора типа счета (используется для работы с классом Wallet)
 */
public enum AccountType {
    BROKERAGE_ACCOUNT("Брокерский счет"),
    DEPOSIT("Депозитный вклад"),
    CASH("Наличка"),
    CRYPTOCURRENCY_WALLET("Криптовалютный счет");


    private final String accountTypeCode;

    AccountType(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }
}
