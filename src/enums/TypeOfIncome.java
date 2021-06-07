package enums;

/**
 * Класс предназначен для выбора типа поступившего пополнения (используется для работы с классами Income, IncomeService)
 */
public enum TypeOfIncome {
    SALARY("Зарплата"),
    PREMIUM("Премия"),
    TAX_REFUND("Возврат налогов"),
    SUDDEN_BONUS("Внезапная бонусняшка");

    private final String incomeCode;

    TypeOfIncome(String incomeCode) {
        this.incomeCode = incomeCode;
    }

    public String getIncomeCode() {
        return incomeCode;
    }
}
