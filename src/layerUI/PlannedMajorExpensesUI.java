package layerUI;

import enums.Currency;
import entity.User;
import services.PlannedMajorExpensesService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для внесения данных новой цели накопления
 * и передачи их в класс createPlannedMajorExpenses
 */
public class PlannedMajorExpensesUI {
    public void completionPlannedMajorExpenses(User user) {
        PlannedMajorExpensesService plannedMajorExpensesService = new PlannedMajorExpensesService();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите цель накопления: ");
        String plannedMajorExpensesName = in.nextLine();
        int currencySelection;
        System.out.println("""
                Выберите валюту:\s
                 1. Рубль
                 2. Доллар
                 3. Биткоин""");
        currencySelection = in.nextInt();
        Currency currency = null;
        if (currencySelection == 1) {
            switch (currencySelection) {
                case 1 -> currency = Currency.RUB;
                case 2 -> currency = Currency.USD;
                case 3 -> currency = Currency.BTC;
            }
        } else {
            System.out.println("В данное время программа работает в тестовом режиме, доступны только рубли");
            currency = Currency.RUB;
        }
        System.out.println("Введите требуемую сумму: ");
        Integer requiredAmountOfMoney = in.nextInt();
        plannedMajorExpensesService.createPlannedMajorExpenses(user, plannedMajorExpensesName, currency, requiredAmountOfMoney);
    }
}
