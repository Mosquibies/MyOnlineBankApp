package app.model.history;

public class PersonalHistory extends History {

    private int opPersonalId;
    private String opPersonalRole;

    public PersonalHistory() {
        super();
    }

    public PersonalHistory(int opNumber, int opPersonalId, String opPersonalRole, String opAction, String opDate) {
        super(opNumber, opAction, opDate);
        this.opPersonalId = opPersonalId;
        this.opPersonalRole = opPersonalRole;
    }

    public int getOpPersonalId() {
        return opPersonalId;
    }

    public void setOpPersonalId(int opPersonalId) {
        this.opPersonalId = opPersonalId;
    }

    public String getOpPersonalRole() {
        return opPersonalRole;
    }

    public void setOpPersonalRole(String opPersonalRole) {
        this.opPersonalRole = opPersonalRole;
    }
}
