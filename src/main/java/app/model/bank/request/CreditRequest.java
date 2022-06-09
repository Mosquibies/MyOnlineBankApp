package app.model.bank.request;

public class CreditRequest extends BankProductRequest {

    private float sum;
    private int time;
    private float percent;
    private float payment;

    public CreditRequest() {}

    public CreditRequest(int requestNumber, String requestType, float sum, int time, float percent, float payment, int requestUserId, String requestUserFirstname, String requestUserLastname, String requestStatus) {
        super(requestNumber, requestType, requestUserId, requestUserFirstname, requestUserLastname, requestStatus);
        this.sum = sum;
        this.time = time;
        this.percent = percent;
        this.payment = payment;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }
}
