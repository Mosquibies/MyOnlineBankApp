package app.model.bank.product;

public class Invoice extends BankProduct {
    private float balance;

    public Invoice(){super();}

    public Invoice(int number, float balance, int clientId) {
        super(number, clientId);
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
