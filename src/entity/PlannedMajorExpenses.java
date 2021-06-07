package entity;

import enums.Currency;

/**
 * Класс используется для создания объектов "запланированная цель для накопления", List<PlannedMajorExpenses> plannedMajorExpenses, использующийся в классах User и UserService
 * объекты имеют следующие поля - название цели, требуемая сумма и валюта
 */
public class PlannedMajorExpenses {
    private String nameMajorExpenses;
    private int requiredAmountOfMoney;
    private Currency currency;

    public PlannedMajorExpenses() {
    }

    public PlannedMajorExpenses(String nameMajorExpenses, int requiredAmountOfMoney, Currency currency) {
        this.nameMajorExpenses = nameMajorExpenses;
        this.requiredAmountOfMoney = requiredAmountOfMoney;
        this.currency = currency;
    }

    public String getNameMajorExpenses() {
        return nameMajorExpenses;
    }

    public void setNameMajorExpenses(String nameMajorExpenses) {
        this.nameMajorExpenses = nameMajorExpenses;
    }

    public int getRequiredAmountOfMoney() {
        return requiredAmountOfMoney;
    }

    public void setRequiredAmountOfMoney(int requiredAmountOfMoney) {
        this.requiredAmountOfMoney = requiredAmountOfMoney;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Откладываем на " + nameMajorExpenses  +
                ". На это нужно накопить - " + requiredAmountOfMoney  + currency;
    }
}
