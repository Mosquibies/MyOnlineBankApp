package app.model.bank.operation;

import app.model.bank.BankProductConstants;
import app.model.bank.product.Credit;
import app.model.bank.product.Invoice;
import app.model.bank.request.CreditRequest;
import app.model.bank.request.ProductRequestStatus;
import app.model.users.Client;
import app.utils.RandomNumber;

import java.math.BigDecimal;

public class CreditOperation extends Operation {

    RandomNumber r = new RandomNumber();

    // подать заявку на кредит
    public CreditRequest sendOpenCreditRequest(Client client, float sum, int time) {
        float percent = BankProductConstants.CREDIT_PERCENT;
        float payment = sum / time + (sum * percent / 100) / 12;
        return new CreditRequest(r.getRandom(0, 65535), "Open", sum, time, percent, payment, client.getUserId(), client.getUserFirstName(), client.getUserLastName(), ProductRequestStatus.UNDER_CONSIDERATION.getTitle());
    }

    // подать заявку на погашение кредита
    public CreditRequest sendCloseCreditRequest(Client client, float sum, int time, float percent, float payment) {
        return new CreditRequest(r.getRandom(0, 65535), "Close", sum, time, percent, payment, client.getUserId(), client.getUserFirstName(), client.getUserLastName(), ProductRequestStatus.UNDER_CONSIDERATION.getTitle());
    }

    // открыть кредит
    public Credit openCredit(CreditRequest creditRequest) {
        return new Credit(r.getRandom(0, 65535), "Consumer credit", creditRequest.getSum(), creditRequest.getTime(), creditRequest.getPercent(), creditRequest.getPayment(), creditRequest.getRequestUserId());
    }

    // внесение платежа по кредиту
    public float moneyDepositing(Credit credit) {
        float balance = credit.getSum();
        BigDecimal a = BigDecimal.valueOf(balance);
        BigDecimal b = BigDecimal.valueOf(credit.getPayment());
        a = a.subtract(b);
        credit.setSum(a.floatValue());
        return credit.getSum();
    }

    // погасить кредит
    public float repayCredit(Invoice invoice, Credit credit) {
        if (invoice.getBalance() > credit.getSum()) {
            BigDecimal a = BigDecimal.valueOf(invoice.getBalance());
            BigDecimal b = BigDecimal.valueOf(credit.getSum());
            a = a.subtract(b);
            invoice.setBalance(a.floatValue());
            credit.setSum(0F);
        }
        return invoice.getBalance();
    }
}