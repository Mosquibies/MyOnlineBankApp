package app.model.history;

public abstract class History {
    private int opNumber;
    private String opAction;
    private String opDate;

    public History() {

    }

    public History(int opNumber, String opAction, String opDate) {
        this.opNumber = opNumber;
        this.opAction = opAction;
        this.opDate = opDate;
    }

    public int getOpNumber() {
        return opNumber;
    }

    public void setOpNumber(int opNumber) {
        this.opNumber = opNumber;
    }

    public String getOpAction() {
        return opAction;
    }

    public void setOpAction(String opAction) {
        this.opAction = opAction;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }
}
