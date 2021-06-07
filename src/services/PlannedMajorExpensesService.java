package services;

import enums.Currency;
import entity.PlannedMajorExpenses;
import entity.User;

/**
 * Класс Service-слоя , предназначенный для записи данных новой цели накопления в лист целей
 */
public class PlannedMajorExpensesService {
    public void createPlannedMajorExpenses(User user, String plannedMajorExpensesName, Currency currency, Integer requiredAmountOfMoney){
        PlannedMajorExpenses plannedMajorExpenses = new PlannedMajorExpenses(plannedMajorExpensesName, requiredAmountOfMoney, currency);
        user.getPlannedMajorExpenses().add(plannedMajorExpenses);
    }
}
