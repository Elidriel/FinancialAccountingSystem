package entity;

import enums.AccountType;
import enums.Currency;

/**
 * Класс используется для создания объектов "счет", List<PaymentCard> cards, использующийся в классах User и UserService
 * объекты имеют следующие поля - название счета, тип счета, валюта, ожидаемый процент накопления и баланс счета
 */
public class Wallet {
    private String name;
    private AccountType accountType;
    private Currency currency;
    private double interestRate;
    private double walletBalance;

    public Wallet(String name, AccountType accountType, Currency currency, double interestRate, double walletBalance) {
        this.name = name;
        this.accountType = accountType;
        this.currency = currency;
        this.interestRate = interestRate;
        this.walletBalance = walletBalance;
    }

    public Wallet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public String toString() {
        return  name + ", " + accountType.getAccountTypeCode() +
                ", с балансом " + walletBalance + currency +
                ". Процентная ставка по счету " + interestRate +
                "%.";
    }


}
