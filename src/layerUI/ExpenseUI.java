package layerUI;

import entity.PaymentCard;
import entity.User;
import enums.TypeOfExpense;
import services.ExpenseService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для внесения данных нового платежа
 * и передачи их в класс ExpenseService
 */
public class ExpenseUI {

    public void completionExpense(User user) {
        ExpenseService expenseService = new ExpenseService();
        Scanner in = new Scanner(System.in);
        int selectionTypeOfExpense;
        System.out.println("""
                Выберите тип платежа:\s
                 1. Платежи и комиссии
                 2. Продукты
                 3. Проезд
                 4. Развлечения
                 5. Кафе и рестораны
                 6. Здоровье
                 7. Прочее""");
        selectionTypeOfExpense = in.nextInt();
        TypeOfExpense typeOfExpense = null;
        if (selectionTypeOfExpense > 0 && selectionTypeOfExpense < 8) {
            switch (selectionTypeOfExpense) {
                case 1 -> typeOfExpense = TypeOfExpense.PAYMENTS_COMMISSIONS;
                case 2 -> typeOfExpense = TypeOfExpense.PRODUCTS;
                case 3 -> typeOfExpense = TypeOfExpense.TRAVEL;
                case 4 -> typeOfExpense = TypeOfExpense.RELAXATION;
                case 5 -> typeOfExpense = TypeOfExpense.CAFE;
                case 6 -> typeOfExpense = TypeOfExpense.HEALTH;
                case 7 -> typeOfExpense = TypeOfExpense.OTHER;
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
        System.out.println("Выберите карту, с которой совершенна покупка");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard selectedCard = user.getCards().get(in.nextInt() - 1);
        System.out.println("Введите место совершения покупки: ");
        String selectedPlace = in.next();
        System.out.println();
        System.out.println("Введите потраченную сумму: ");
        Double selectedMoney = in.nextDouble();
        expenseService.createExpense(user, typeOfExpense, selectedCard, selectedPlace, selectedMoney);
    }
}
