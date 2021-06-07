package services;

import entity.User;
import entity.Wallet;
import enums.AccountType;
import enums.Currency;

/**
 * Класс Service-слоя , предназначенный для записи данных нового счета в лист счетов
 */
public class WalletService {
    public void createAWallet(User user, String walletName, AccountType accountType, Currency currency, Double walletBalance, Double interestRate) {
        Wallet wallet = new Wallet(walletName, accountType, currency, interestRate, walletBalance);
        user.getWallets().add(wallet);
    }
}
