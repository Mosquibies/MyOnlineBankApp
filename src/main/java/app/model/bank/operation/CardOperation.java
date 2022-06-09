package app.model.bank.operation;

import app.model.bank.product.Card;
import app.model.bank.product.Invoice;
import app.model.bank.request.CardRequest;
import app.model.bank.request.ProductRequestStatus;
import app.model.users.Client;
import app.utils.RandomNumber;

public class CardOperation extends Operation {

    RandomNumber r = new RandomNumber();

    // просмотр всех карт клиента

    // заявка на открытие карты
    public CardRequest sendOpenCardRequest(Client client) {
        return new CardRequest(r.getRandom(0, 65535), "Open", 0,client.getUserId(), client.getUserFirstName(), client.getUserLastName(), ProductRequestStatus.UNDER_CONSIDERATION.getTitle());
    }
    // заявка на закрытие карты
    public CardRequest sendCloseCardRequest(Client client, Card card) {
        return new CardRequest(r.getRandom(0, 65535), "Close", card.getNumber(), client.getUserId(), client.getUserFirstName(), client.getUserLastName(), ProductRequestStatus.UNDER_CONSIDERATION.getTitle());
    }

    // открыть карту
    public Card openCard(Client client, Invoice invoice) {
        return new Card(r.getRandom(0, 65535), invoice.getNumber(), invoice.getBalance(), client.getUserId());
    }

    // просмотреть баланс

    // получить историю платежей
}
