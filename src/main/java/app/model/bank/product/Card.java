package app.model.bank.product;

public class Card extends BankProduct {
    private int invoiceNumber;
    private float balance;

    public Card(){super();}

    public Card(int number, int invoiceNumber, float balance, int clientId){
        super(number, clientId);
        this.invoiceNumber = invoiceNumber;
        this.balance = balance;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
