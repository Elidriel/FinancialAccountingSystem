package services;

import enums.Bank;
import enums.Currency;
import entity.PaymentCard;
import entity.User;

/**
 * Класс Service-слоя , предназначенный для записи данных новой карты в лист карт
 */
public class PaymentCardService {

    public void createCard(User user, String nameCard, Bank bank, Currency currency, Double cardBalance) {
        PaymentCard card = new PaymentCard(nameCard, bank, currency, cardBalance);
        user.getCards().add(card);
    }
}
