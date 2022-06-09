package app.model.bank.request;

public class InvoiceRequest extends BankProductRequest {

    private int invoiceNumber;

    public InvoiceRequest() {super();}


    public InvoiceRequest(int requestNumber, String requestType, int requestUserId, String requestUserFirstname, String requestUserLastname, String requestStatus) {
        super(requestNumber, requestType, requestUserId, requestUserFirstname, requestUserLastname, requestStatus);
    }

    public InvoiceRequest(int requestNumber, String requestType, int invoiceNumber, int requestUserId, String requestUserFirstname, String requestUserLastname, String requestStatus) {
        super(requestNumber, requestType, requestUserId, requestUserFirstname, requestUserLastname, requestStatus);
        this.invoiceNumber = invoiceNumber;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
