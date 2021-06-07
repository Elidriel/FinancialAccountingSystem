package layerUI;

import enums.AccountType;
import enums.Currency;
import entity.User;
import services.WalletService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для внесения данных нового счета
 * и передачи их в класс WalletService
 */
public class WalletUI {
    public void completionAWallet(User user) {
        WalletService walletService = new WalletService();
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите название счета: ");
        String walletName = in.nextLine();
        int selectingTheAccountType;
        System.out.println("""
                Выберите тип счета:\s
                 1. Брокерский счет
                 2. Депозитный вклад
                 3. Наличка
                 4. Криптовалютный счет""");
        selectingTheAccountType = in.nextInt();
        AccountType accountType = null;
        if (selectingTheAccountType > 0 && selectingTheAccountType < 5) {
            switch (selectingTheAccountType) {
                case 1 -> accountType = AccountType.BROKERAGE_ACCOUNT;
                case 2 -> accountType = AccountType.DEPOSIT;
                case 3 -> accountType = AccountType.CASH;
                case 4 -> accountType = AccountType.CRYPTOCURRENCY_WALLET;
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
        int currencySelection;
        System.out.println("""
                Выберите валюту:\s
                 1. Рубль
                 2. Доллар
                 3. Биткоин""");
        currencySelection = in.nextInt();
        Currency currency = null;
        if (currencySelection == 1) {
            switch (currencySelection) {
                case 1 -> currency = Currency.RUB;
                case 2 -> currency = Currency.USD;
                case 3 -> currency = Currency.BTC;
            }
        } else {
            System.out.println("В данное время программа работает в тестовом режиме, доступны только рубли");
            currency = Currency.RUB;
        }
        System.out.println("Введите баланс на счете: ");
        Double walletBalance = in.nextDouble();
        System.out.println("Введите ожидаемую процентную ставку (в %): ");
        Double interestRate = in.nextDouble();
        walletService.createAWallet(user,walletName, accountType, currency, walletBalance, interestRate);
    }
}
