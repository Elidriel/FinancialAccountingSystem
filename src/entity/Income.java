package entity;

import enums.TypeOfIncome;

import java.util.Date;

/**
 * Класс используется для создания обьектов "пополнение", List<Income> incomes, использующийся в классах User и UserService
 * объекты имеют следующие поля - карта, тип пополнения, полученная сумма и время платежа
 */
public class Income {
    private TypeOfIncome typeOfIncome;
    private PaymentCard paymentCard;
    private double accrualAmount;
    private Date date;

    public Income() {
    }

    public Income(TypeOfIncome typeOfIncome, PaymentCard paymentCard, double accrualAmount, Date date) {
        this.typeOfIncome = typeOfIncome;
        this.paymentCard = paymentCard;
        this.accrualAmount = accrualAmount;
        this.date = date;
    }

    public TypeOfIncome getTypeOfIncome() {
        return typeOfIncome;
    }

    public void setTypeOfIncome(TypeOfIncome typeOfIncome) {
        this.typeOfIncome = typeOfIncome;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    public double getAccrualAmount() {
        return accrualAmount;
    }

    public void setAccrualAmount(double accrualAmount) {
        this.accrualAmount = accrualAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Тип пополнения - " +
                '\"' + typeOfIncome.getIncomeCode() + '\"' +
                ". " + paymentCard.getName() +
                ". Сумма начисления - " + accrualAmount +
                ". Дата начисления - " + date;
    }
}
