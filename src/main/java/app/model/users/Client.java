package app.model.users;

public class Client extends User {

    private int invoicesCount;
    private int cardsCount;
    private int creditCount;

    public Client() {
        super();
    }

    public Client(String userFirstName, String userLastName, int userAge, int userPhone, String userPassword, int invoicesCount, int cardsCount,int creditCount) {
        super(userFirstName, userLastName, userAge, userPhone, userPassword);
        this.invoicesCount = invoicesCount;
        this.cardsCount = cardsCount;
        this.creditCount = creditCount;
    }

    public Client(int userId, String userFirstName, String userLastName, int userAge, int userPhone, String userPassword, int invoicesCount, int cardsCount,int creditCount) {
        super(userId, userFirstName, userLastName, userAge, userPhone, userPassword);
        this.invoicesCount = invoicesCount;
        this.cardsCount = cardsCount;
        this.creditCount = creditCount;
    }

    public int getInvoicesCount() {
        return invoicesCount;
    }

    public void setInvoicesCount(int invoicesCount) {
        this.invoicesCount = invoicesCount;
    }

    public int getCardsCount() {
        return cardsCount;
    }

    public void setCardsCount(int cardsCount) {
        this.cardsCount = cardsCount;
    }

    public int getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(int creditCount) {
        this.creditCount = creditCount;
    }

}
