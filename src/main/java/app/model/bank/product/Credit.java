package app.model.bank.product;

public class Credit extends BankProduct {
    private String creditType;
    private float sum;
    private int time;
    private float percent;
    private float payment;

    public Credit() {super();}

    public Credit(int number, String type, float sum, int time, float percent, float payment, int clientId) {
        super(number, clientId);
        this.creditType = type;
        this.sum = sum;
        this.time = time;
        this.percent = percent;
        this.payment = payment;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
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
