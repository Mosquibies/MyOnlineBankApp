package app.model.bank.product;

import app.model.users.Client;

public abstract class BankProduct {
    private int number;
    private int clientId;

    public BankProduct(){}

    public BankProduct(int number) {
        this.number = number;
    }

    public BankProduct(int number, int clientId) {
        this.number = number;
        this.clientId = clientId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
