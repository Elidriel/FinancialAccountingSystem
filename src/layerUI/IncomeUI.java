package layerUI;

import entity.PaymentCard;
import entity.User;
import enums.TypeOfIncome;
import services.IncomeService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для внесения данных нового пополнения
 * и передачи их в класс IncomeService
 */
public class IncomeUI {
    public void completionIncome(User user) {
        IncomeService incomeService = new IncomeService();
        Scanner in = new Scanner(System.in);
        int selectionTypeOfExpense;
        System.out.println("""
                Выберите тип пополнения: \s
                 1. Зарплата
                 2. Премия
                 3. Возврат налогов
                 4. Внезапная бонусняшка""");
        selectionTypeOfExpense = in.nextInt();
        TypeOfIncome typeOfIncome = null;
        if (selectionTypeOfExpense > 0 && selectionTypeOfExpense < 5) {
            switch (selectionTypeOfExpense) {
                case 1 -> typeOfIncome = TypeOfIncome.SALARY;
                case 2 -> typeOfIncome = TypeOfIncome.PREMIUM;
                case 3 -> typeOfIncome = TypeOfIncome.TAX_REFUND;
                case 4 -> typeOfIncome = TypeOfIncome.SUDDEN_BONUS;
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
        System.out.println("Выберите карту зачисления: ");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard selectedCard = user.getCards().get(in.nextInt() - 1);
        System.out.println("Введите сумму пополнения: ");
        double accrualAmount = in.nextDouble();
        incomeService.createIncome(user, typeOfIncome, selectedCard, accrualAmount);
    }
}
