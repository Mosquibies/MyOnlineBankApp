package app.model.bank.operation;

import app.model.bank.product.Invoice;
import app.model.bank.request.InvoiceRequest;
import app.model.bank.request.ProductRequestStatus;
import app.model.users.Client;
import app.utils.RandomNumber;

import java.math.BigDecimal;


public class InvoiceOperation extends Operation {

    RandomNumber r = new RandomNumber();

    // заявка на открытие счета
    public InvoiceRequest sendOpenInvoiceRequest(Client client) {
        return new InvoiceRequest(r.getRandom(0, 65535), "Open", 0, client.getUserId(), client.getUserFirstName(), client.getUserLastName(), ProductRequestStatus.UNDER_CONSIDERATION.getTitle());
    }

    // заявка на закрытие счета
    public InvoiceRequest sendCloseInvoiceRequest(Client client, Invoice invoice) {
        return new InvoiceRequest(r.getRandom(0, 65535), "Close", invoice.getNumber(), client.getUserId(), client.getUserFirstName(), client.getUserLastName(), ProductRequestStatus.UNDER_CONSIDERATION.getTitle());
    }

    // открыть счет
    public Invoice openInvoice(Client client) {
        return new Invoice(r.getRandom(0, 65535), r.getRandomFloat(), client.getUserId());
    }

    // списание денег
    public float moneyWithdrawal(Invoice invoice, float payment) {
        float invoiceBalance = invoice.getBalance();
        BigDecimal a = BigDecimal.valueOf(invoiceBalance);
        BigDecimal b = BigDecimal.valueOf(payment);
        if (invoiceBalance > payment) {
            a = a.subtract(b);
            invoice.setBalance(a.floatValue());
            return invoice.getBalance();

        } else {
            return invoiceBalance;
        }
    }
    // просмотр всех счетов

    // просмотр баланса(-ов)


    //
}
