package enums;

/**
 * Класс предназначен для выбора типа осуществленного платежа (используется для работы с классами Expense, ExpenseService)
 */
public enum TypeOfExpense {
    PAYMENTS_COMMISSIONS("Платежи и комиссии"),
    PRODUCTS("Продукты"),
    TRAVEL("Проезд"),
    RELAXATION("Развлечения"),
    CAFE("Кафе и рестораны"),
    HEALTH("Здоровье"),
    OTHER("Прочее");

    private final String expenseCode;

    TypeOfExpense(String expenseCode) {
        this.expenseCode = expenseCode;
    }

    public String getExpenseCode() {
        return expenseCode;
    }
}
