package services;

import entity.PaymentCard;
import entity.Wallet;

/**
 * Класс Service-слоя , предназначенный для перевода средств между картами и счетами
 */
public class TransferService {

    public void cardToCard(PaymentCard exportCard, PaymentCard importCard, Double sum) {
        exportCard.setCardBalance(exportCard.getCardBalance() - sum);
        importCard.setCardBalance(importCard.getCardBalance() + sum);
    }

    public void cardToWallet(PaymentCard exportCard, Wallet importWallet, Double sum) {
        exportCard.setCardBalance(exportCard.getCardBalance() - sum);
        importWallet.setWalletBalance(importWallet.getWalletBalance() + sum);
    }

    public void walletToCard(Wallet exportWallet, PaymentCard importCard, Double sum) {
        exportWallet.setWalletBalance(exportWallet.getWalletBalance() - sum);
        importCard.setCardBalance(importCard.getCardBalance() + sum);
    }

    public void walletToWallet(Wallet exportWallet, Wallet importWallet, Double sum) {
        exportWallet.setWalletBalance(exportWallet.getWalletBalance() - sum);
        importWallet.setWalletBalance(importWallet.getWalletBalance() + sum);
    }

}

