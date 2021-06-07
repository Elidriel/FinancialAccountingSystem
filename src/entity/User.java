package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Основной класс для создания объекта "пользователь".
 * Пользователь только один,
 * так как программа создавалась по примеру приложений типа "учет расходов и доходов" для смартфонов.
 * Объект содержит в себе списки карт, счетов, платежей, пополнений и целей накопления
 */
public class User {
    private List<PaymentCard> cards;
    private List<Wallet> wallets;
    private List<Expense> expenses;
    private List<Income> incomes;
    private List<PlannedMajorExpenses> plannedMajorExpenses;

//    public User() {
//        this.cards = new ArrayList<>();
//        this.wallets = new ArrayList<>();
//        this.expenses = new ArrayList<>();
//        this.incomes = new ArrayList<>();
//        this.plannedMajorExpenses = new ArrayList<>();
//    }
    private static final User INSTANCE = new User();
    private User() {
        this.cards = new ArrayList<>();
        this.wallets = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
        this.plannedMajorExpenses = new ArrayList<>();
    }
    public static User getUser() {
        return INSTANCE;
    }

    public List<PaymentCard> getCards() {
        return cards;
    }

    public void setCards(List<PaymentCard> cards) {
        this.cards = cards;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    public List<PlannedMajorExpenses> getPlannedMajorExpenses() {
        return plannedMajorExpenses;
    }

    public void setPlannedMajorExpenses(List<PlannedMajorExpenses> plannedMajorExpenses) {
        this.plannedMajorExpenses = plannedMajorExpenses;
    }
}
