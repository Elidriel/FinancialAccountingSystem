package layerUI;

import enums.Bank;
import enums.Currency;
import entity.User;
import services.PaymentCardService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для внесения данных новой карты
 * и передачи их в класс PaymentCardService
 */
public class PaymentCardUI {
    public void completionCard(User user) {
        PaymentCardService paymentCardService = new PaymentCardService();
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите название карты или номер: ");
        String nameCard = in.nextLine();
        int bankSelection;
        System.out.println("""
                Выберите банк:\s
                 1. Сбербанк России
                 2. Тинькофф Банк
                 3. Альфа-Банк
                 4. Банк ВТБ""");
        bankSelection = in.nextInt();
        Bank bank = null;
        if (bankSelection > 0 && bankSelection < 5) {
            switch (bankSelection) {
                case 1 -> bank = Bank.SBER;
                case 2 -> bank = Bank.TINKOFF;
                case 3 -> bank = Bank.ALFA;
                case 4 -> bank = Bank.VTB;
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
        System.out.println("Введите баланс на карте: ");
        Double cardBalance = in.nextDouble();
        paymentCardService.createCard(user, nameCard, bank, currency, cardBalance);
    }
}
