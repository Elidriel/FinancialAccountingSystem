package services;

import enums.TypeOfIncome;
import entity.Income;
import entity.PaymentCard;
import entity.User;

import java.util.Date;

/**
 * Класс Service-слоя , предназначенный для записи данных нового пополнения в лист пополнения
 */
public class IncomeService {
    public void createIncome(User user, TypeOfIncome typeOfIncome,  PaymentCard selectedCard, Double accrualAmount) {
        Income income = new Income(typeOfIncome, selectedCard, accrualAmount, new Date());
        user.getIncomes().add(income);
        selectedCard.setCardBalance(selectedCard.getCardBalance() + income.getAccrualAmount());
    }
}
