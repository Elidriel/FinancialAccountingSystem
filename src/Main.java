import enums.*;
import entity.*;
import layerUI.*;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * на повторное ревью
 * чтото я на косячил и пришлось репозиторий пересоздать
 */

/**
 * Основной класс, с которого начинается взаимодействие пользователя с программой
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Тестовая ветка для проверки");
        User user = createDefaultUser();
        PaymentCardUI cardUI = new PaymentCardUI();
        WalletUI walletUI = new WalletUI();
        ExpenseUI expenseUI = new ExpenseUI();
        IncomeUI incomeUI = new IncomeUI();
        PlannedMajorExpensesUI plannedMajorExpensesUI = new PlannedMajorExpensesUI();
        TransferUI transferUI = new TransferUI();
        UserUI userUI = new UserUI();
        Scanner in = new Scanner(System.in);
        int tmp = 999;
        while (tmp != 0) {
            System.out.println("Тестовая ветка для ревью");
            System.out.println("""
                    Выберите операцию: \s
                     1. Добавить карту
                     2. Добавить счет
                     3. Добавить расход
                     4. Добавить доход
                     5. Запланировать крупную покупку
                     6. Совершить перевод между своими счетами
                     7. Запросить состояние
                     8. Редактирование счетов и карт
                     9. Работа со списками
                     0. Выход""");
            try {
                tmp = in.nextInt();
                if (tmp >= 0 && tmp < 10) {
                    switch (tmp) {
                        case 1 -> cardUI.completionCard(user);
                        case 2 -> walletUI.completionAWallet(user);
                        case 3 -> expenseUI.completionExpense(user);
                        case 4 -> incomeUI.completionIncome(user);
                        case 5 -> plannedMajorExpensesUI.completionPlannedMajorExpenses(user);
                        case 6 -> transferUI.transfer(user);
                        case 7 -> userUI.balanceRequest(user);
                        case 8 -> userUI.workingWithCardsOrWallets(user);
                        case 9 -> userUI.choosingWorkingWithLists(user);
                        case 0 -> System.out.println("До свидания!");
                    }
                } else {
                    System.out.println("Введите корректную цифру");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите корректную цифру");
                in.nextLine();
            }
        }
    }

    /**
     * Метод создающий объект user для демонстрации работы программы.
     * Так как сериализация/десериализация через файл для такого объекта сложно реализуема,
     * а в базы данных я еще не умею
     */
    private static User createDefaultUser() {
        User user = User.getUser();
        user.getCards().add(new PaymentCard("Зарплатная", Bank.SBER, Currency.RUB, 10000));
        user.getCards().add(new PaymentCard("Кредитная", Bank.ALFA, Currency.RUB, 200000));

        user.getWallets().add(new Wallet("ИИС", AccountType.BROKERAGE_ACCOUNT, Currency.RUB, 10, 154200));
        user.getWallets().add(new Wallet("Неприкосновенный запас", AccountType.CASH, Currency.RUB, 0, 100000));

        user.getExpenses().add(new Expense(TypeOfExpense.CAFE, user.getCards().get(0), "Шаурма - В Пузо", 200, new Date()));
        user.getExpenses().add(new Expense(TypeOfExpense.PAYMENTS_COMMISSIONS, user.getCards().get(1), "ЖКХ", 400, new Date()));
        user.getExpenses().add(new Expense(TypeOfExpense.HEALTH, user.getCards().get(0), "Аптека - Здоровье в дом", 200, new Date()));
        user.getExpenses().add(new Expense(TypeOfExpense.PRODUCTS, user.getCards().get(0), "Магнит", 900, new Date()));

        user.getIncomes().add(new Income(TypeOfIncome.SALARY, user.getCards().get(0), 45000, new Date()));
        user.getIncomes().add(new Income(TypeOfIncome.PREMIUM, user.getCards().get(0), 100000, new Date()));

        user.getPlannedMajorExpenses().add(new PlannedMajorExpenses("Новенький Индиан", 1_500_000, Currency.RUB));
        user.getPlannedMajorExpenses().add(new PlannedMajorExpenses("Переезд в Грецию", 20_000_000, Currency.RUB));

        return user;
    }
}
