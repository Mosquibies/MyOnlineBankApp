package app.model.bank.request;

public enum ProductRequestStatus {

    APPROVED ("Approved"),
    REJECTED ("Rejected"),
    UNDER_CONSIDERATION ("Under consideration");

    private String title;

    ProductRequestStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
