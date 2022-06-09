package app.model.history;

public class ClientHistory extends History {

    public ClientHistory() {
        super();
    }

    public ClientHistory(int opNumber, String opAction, String opDate) {
        super(opNumber, opAction, opDate);
    }
}
