package app.model.bank.request;

public class CardRequest extends BankProductRequest {

    private int cardNumber;

    public CardRequest() {}

    public CardRequest(int requestNumber, String requestType, int requestUserId, String requestUserFirstname, String requestUserLastname, String requestStatus) {
        super(requestNumber, requestType, requestUserId, requestUserFirstname, requestUserLastname, requestStatus);
    }

    public CardRequest(int requestNumber, String requestType, int cardNumber, int requestUserId, String requestUserFirstname, String requestUserLastname, String requestStatus) {
        super(requestNumber, requestType, requestUserId, requestUserFirstname, requestUserLastname, requestStatus);
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
