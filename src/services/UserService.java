package services;

import entity.PaymentCard;
import entity.User;
import entity.Wallet;

/**
 * Класс Service-слоя , предназначенный подсчета баланса карт и счетов
 */
public class UserService {
    public static double printSumCards(User user) {
        double sum = 0;
        for (PaymentCard card : user.getCards()) {
            sum += card.getCardBalance();
        }
        return sum;
    }

    public static double printSumWallet(User user) {
        double sum = 0;
        for (Wallet wallet : user.getWallets()) {
            sum += wallet.getWalletBalance();
        }
        return sum;
    }

    public static double printTotalSum(User user) {
        double sumWallets = 0;
        for (Wallet wallet : user.getWallets()) {
            sumWallets += wallet.getWalletBalance();
        }
        double sumCards = 0;
        for (PaymentCard card : user.getCards()) {
            sumCards += card.getCardBalance();
        }
        return (sumWallets + sumCards);
    }
}
