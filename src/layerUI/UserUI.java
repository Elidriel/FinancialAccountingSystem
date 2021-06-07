package layerUI;

import entity.PaymentCard;
import entity.User;
import entity.Wallet;
import services.UserService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для работы с внесенными данными:
 *  - запросы баланса карт/счетов;
 *  - редактирование и удаление карт/счетов;
 *  - вывод списков
 */
public class UserUI {

    public void balanceRequest(User user) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Выберите тип запроса:\s
                 1. Баланс карты
                 2. Баланс счета
                 3. Сумма средств на всех картах
                 4. Сумма средств на всех счетах
                 5. Суммарный баланс средств""");
        int tmp = in.nextInt();
        if (tmp > 0 && tmp < 6) {
            switch (tmp) {
                case 1 -> choosingCard(user, in);
                case 2 -> choosingWallet(user, in);
                case 3 -> System.out.println("Сумма средств по всем картам - " + UserService.printSumCards(user));
                case 4 -> System.out.println("Сумма средств по всем счетам - " + UserService.printSumWallet(user));
                case 5 -> System.out.println("Сумма средств по всем счетам - " + UserService.printTotalSum(user));
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
    }

    private void choosingCard(User user, Scanner in) {
        System.out.println("Баланс какой карты хотите посмотреть: ");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard selectedCard = user.getCards().get(in.nextInt() - 1);
        System.out.println("Баланс на карте - " + selectedCard.getCardBalance() + " " + selectedCard.getCurrency());
    }

    private void choosingWallet(User user, Scanner in) {
        System.out.println("Баланс какой счета хотите посмотреть: ");
        user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.getName()));
        Wallet selectedWallet = user.getWallets().get(in.nextInt() - 1);
        System.out.println("Баланс на счете - " + selectedWallet.getWalletBalance() + " " + selectedWallet.getCurrency());
    }

    public void choosingWorkingWithLists(User user) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Выберите:\s
                 1. Вывести список карт
                 2. Вывести список счетов
                 3. Вывести список расходов
                 4. Вывести список доходов
                 5. Вывести список целей""");
        int tmp = in.nextInt();
        if (tmp > 0 && tmp < 6) {
            switch (tmp) {
                case 1 -> user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.toString()));
                case 2 -> user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.toString()));
                case 3 -> user.getExpenses().forEach(expense -> System.out.println((user.getExpenses().indexOf(expense) + 1) + ". " + expense.toString()));
                case 4 -> user.getIncomes().forEach(income -> System.out.println((user.getIncomes().indexOf(income) + 1) + ". " + income.toString()));
                case 5 -> user.getPlannedMajorExpenses().forEach(plannedMajorExpenses -> System.out.println((user.getPlannedMajorExpenses().indexOf(plannedMajorExpenses) + 1) + ". " + plannedMajorExpenses.toString()));
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
    }

    public void workingWithCardsOrWallets(User user) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Выберите тип запроса:\s
                 1. Редактировать информацию по карте
                 2. Удалить карту
                 3. Редактировать информацию по счету
                 4. Удалить счет""");
        int tmp = in.nextInt();
        if (tmp > 0 && tmp < 5) {
            switch (tmp) {
                case 1 -> editCard(user, in);
                case 2 -> deleteCard(user, in);
                case 3 -> editWallet(user, in);
                case 4 -> deleteWallet(user, in);
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
    }

    private void deleteCard(User user, Scanner in) {
        System.out.println("Какую карту вы хотите удалить: ");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        user.getCards().remove(user.getCards().get(in.nextInt() - 1));
    }

    private void deleteWallet(User user, Scanner in) {
        System.out.println("Какой счет вы хотите удалить: ");
        user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.getName()));
        user.getWallets().remove(user.getWallets().get(in.nextInt() - 1));
    }

    private void editCard(User user, Scanner in) {
        System.out.println("Какую карту вы хотите редактировать: ");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard selectedCard = user.getCards().get(in.nextInt() - 1);
        System.out.println(selectedCard);
        System.out.println("""
                Выберите поле редактирования:\s
                 1. Имя
                 2. Баланс""");
        int tmp = in.nextInt();
        switch (tmp) {
            case 1 -> {
                Scanner in1 = new Scanner(System.in);
                System.out.println("Введите новое название карты: ");
                String newName = in1.nextLine();
                selectedCard.setName(newName);
            }
            case 2 -> {
                System.out.println("Введите новый баланс карты: ");
                int newBalance = in.nextInt();
                selectedCard.setCardBalance(newBalance);
            }
        }
    }

    private void editWallet(User user, Scanner in) {
        System.out.println("Какой счет вы хотите редактировать: ");
        user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.getName()));
        Wallet selectedWallet = user.getWallets().get(in.nextInt() - 1);
        System.out.println(selectedWallet);
        System.out.println("""
                Выберите поле редактирования:\s
                 1. Имя
                 2. Баланс
                 3. Процентная ставка""");
        int tmp = in.nextInt();
        switch (tmp) {
            case 1 -> {
                Scanner in1 = new Scanner(System.in);
                System.out.println("Введите новое название счета: ");
                String newName = in1.nextLine();
                selectedWallet.setName(newName);
            }
            case 2 -> {
                System.out.println("Введите новый баланс счета: ");
                int newBalance = in.nextInt();
                selectedWallet.setWalletBalance(newBalance);
            }
            case 3 -> {
                System.out.println("Введите новую процентную ставку: ");
                double newInterestRate = in.nextDouble();
                selectedWallet.setInterestRate(newInterestRate);
            }
        }
    }
}
