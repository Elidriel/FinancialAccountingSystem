package services;

import enums.TypeOfExpense;
import entity.Expense;
import entity.PaymentCard;
import entity.User;

import java.util.Date;

/**
 * Класс Service-слоя , предназначенный для записи данных нового платежа в лист платежей
 */
public class ExpenseService {
    public void createExpense(User user, TypeOfExpense selectedType, PaymentCard selectedCard, String selectedPlaceOfPayment, Double selectedMoney) {
        Expense expense = new Expense(selectedType, selectedCard, selectedPlaceOfPayment, selectedMoney, new Date());
        user.getExpenses().add(expense);
        selectedCard.setCardBalance(selectedCard.getCardBalance() - expense.getAmountOfMoneyDebited());
    }
}
