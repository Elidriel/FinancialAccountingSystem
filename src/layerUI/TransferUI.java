package layerUI;

import entity.PaymentCard;
import entity.User;
import entity.Wallet;
import services.TransferService;

import java.util.Scanner;

/**
 * Класс UI-слоя, предназначенный для запроса данных по переводу средств
 * и передачи их в класс TransferService
 */
public class TransferUI {

    public void transfer(User user) {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                Выберите тип перевода:\s
                 1. с карты на карту
                 2. с карты на счет
                 3. с счета на карту
                 4. с счета на счет""");
        int tmp = in.nextInt();
        if (tmp > 0 && tmp < 5) {
            switch (tmp) {
                case 1 -> cardToCardUI(user, in);
                case 2 -> cardToWalletUI(user, in);
                case 3 -> walletToCardUI(user, in);
                case 4 -> walletToWalletUI(user, in);
            }
        } else {
            System.out.println("Введите корректную цифру");
        }
    }

    private void cardToCardUI(User user, Scanner in) {
        TransferService transferService = new TransferService();
        System.out.println("Выберите карту списания, выберите карту зачисления, введите переводимую сумму (пример: 1 2 500): ");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard exportCard = user.getCards().get(Integer.parseInt(in.next()) - 1);
        PaymentCard importCard = user.getCards().get(Integer.parseInt(in.next()) - 1);
        double sum = Double.parseDouble(in.next());
        if (exportCard.getCurrency().equals(importCard.getCurrency())) {
            transferService.cardToCard(exportCard, importCard, sum);
            System.out.println();
        } else {
            System.out.println("Выбирете карты с одинаковой валютой");
            cardToCardUI(user, in);
        }
    }

    private void cardToWalletUI(User user, Scanner in) {
        TransferService transferService = new TransferService();
        System.out.println("Выберите карту списания, выберите счет зачисления, введите переводимую сумму (пример: 1 2 500): ");
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard exportCard = user.getCards().get(Integer.parseInt(in.next()) - 1);
        user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.getName()));
        Wallet importWallet = user.getWallets().get(Integer.parseInt(in.next()) - 1);
        double sum = Double.parseDouble(in.next());
        if (exportCard.getCurrency().equals(importWallet.getCurrency())) {
            transferService.cardToWallet(exportCard, importWallet, sum);
            System.out.println();
        } else {
            System.out.println("Выбирете карту и счет с одинаковой валютой");
            cardToWalletUI(user, in);
        }
    }

    private void walletToCardUI(User user, Scanner in) {
        TransferService transferService = new TransferService();
        System.out.println("Выберите счет списания, выберите карту зачисления, введите переводимую сумму (пример: 1 2 500): ");
        user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.getName()));
        Wallet exportWallet = user.getWallets().get(Integer.parseInt(in.next()) - 1);
        user.getCards().forEach(card -> System.out.println((user.getCards().indexOf(card) + 1) + ". " + card.getName()));
        PaymentCard importCard = user.getCards().get(Integer.parseInt(in.next()) - 1);
        double sum = Double.parseDouble(in.next());
        if (exportWallet.getCurrency().equals(importCard.getCurrency())) {
            transferService.walletToCard(exportWallet, importCard, sum);
            System.out.println();
        } else {
            System.out.println("Выбирете карту и счет с одинаковой валютой");
            walletToCardUI(user, in);
        }
    }

    private void walletToWalletUI(User user, Scanner in) {
        TransferService transferService = new TransferService();
        System.out.println("Выберите счет списания, выберите счет зачисления, пвведите переводимую сумму (пример: 1 2 500): ");
        user.getWallets().forEach(wallet -> System.out.println((user.getWallets().indexOf(wallet) + 1) + ". " + wallet.getName()));
        Wallet exportWallet = user.getWallets().get(Integer.parseInt(in.next()) - 1);
        Wallet importWallet = user.getWallets().get(Integer.parseInt(in.next()) - 1);
        double sum = Double.parseDouble(in.next());
        if(exportWallet.getCurrency().equals(importWallet.getCurrency())) {
            transferService.walletToWallet(exportWallet, importWallet, sum);
            System.out.println();
        } else {
            System.out.println("Выбирете счета с одинаковой валютой");
            walletToWalletUI(user, in);
        }
    }
}
