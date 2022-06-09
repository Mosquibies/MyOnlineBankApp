package app.model.bank.request;

public abstract class BankProductRequest {

    private int requestNumber;
    private String requestType;
    private int requestUserId;
    private String requestUserFirstname;
    private String requestUserLastname;
    private String requestStatus;

    public BankProductRequest() {}

    public BankProductRequest(int requestNumber, String requestType, int requestUserId, String requestUserFirstname, String requestUserLastname, String requestStatus) {
        this.requestNumber = requestNumber;
        this.requestType = requestType;
        this.requestUserId = requestUserId;
        this.requestUserFirstname = requestUserFirstname;
        this.requestUserLastname = requestUserLastname;
        this.requestStatus = requestStatus;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestUserFirstname() {
        return requestUserFirstname;
    }

    public void setRequestUserFirstname(String requestUserFirstname) {
        this.requestUserFirstname = requestUserFirstname;
    }

    public String getRequestUserLastname() {
        return requestUserLastname;
    }

    public void setRequestUserLastname(String requestUserLastname) {
        this.requestUserLastname = requestUserLastname;
    }

    public int getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(int requestUserId) {
        this.requestUserId = requestUserId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
