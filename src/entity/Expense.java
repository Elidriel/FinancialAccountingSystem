package entity;

import enums.TypeOfExpense;

import java.util.Date;

/**
 * Класс используется для создания объектов "платеж", записываемых List<Expense> expenses, использующийся в классах User и UserService
 * объекты имеют следующие поля - карта, тип платежа, место платежа, потраченная сумма и время платежа
 */
public class Expense {
    private TypeOfExpense typeOfExpense;
    private PaymentCard paymentCard;
    private String placeOfPayment;
    private double amountOfMoneyDebited;
    private Date date;

    public Expense(TypeOfExpense typeOfExpense, PaymentCard paymentCard, String placeOfPayment, double amountOfMoneyDebited,  Date date) {
        this.typeOfExpense = typeOfExpense;
        this.paymentCard = paymentCard;
        this.placeOfPayment = placeOfPayment;
        this.amountOfMoneyDebited = amountOfMoneyDebited;
        this.date = date;
    }

    public Expense() {
    }

    public TypeOfExpense getTypeOfExpense() {
        return typeOfExpense;
    }

    public void setTypeOfExpense(TypeOfExpense typeOfExpense) {
        this.typeOfExpense = typeOfExpense;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    public String getPlaceOfPayment() {
        return placeOfPayment;
    }

    public void setPlaceOfPayment(String placeOfPayment) {
        this.placeOfPayment = placeOfPayment;
    }


    public double getAmountOfMoneyDebited() {
        return amountOfMoneyDebited;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmountOfMoneyDebited(double amountOfMoneyDebited) {
        this.amountOfMoneyDebited = amountOfMoneyDebited;
    }

    @Override
    public String toString() {
        return "Тип платежа - " + '\"' + typeOfExpense.getExpenseCode() + '\"' +
                ". Сумма списания - " + amountOfMoneyDebited +
                ". Карта списания - " + paymentCard.getName() +
                ". Место платежа - " + placeOfPayment +
                ". Дата платежа: " + date;
    }
}
