package entity;

import enums.Bank;
import enums.Currency;

/**
 * Класс используется для создания объектов "карта", List<PaymentCard> cards, использующийся в классах User и UserService
 * объекты имеют следующие поля - название карты, название банка, баланс на карте и валюта
 */
public class PaymentCard {
    private String name;
    private Bank bank;
    private double cardBalance;
    private Currency currency;

    public PaymentCard(String name, Bank bank, Currency currency, double cardBalance) {
        this.name = name;
        this.bank = bank;
        this.currency = currency;
        this.cardBalance = cardBalance;
    }

    public PaymentCard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "Карта " + name +
                ", выпущенная банком " + bank.getBankCode() +
                ", имеет текущий баланс " + cardBalance + " " + currency;
    }

}
