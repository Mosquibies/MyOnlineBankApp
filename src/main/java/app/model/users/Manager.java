package app.model.users;

public class Manager extends User {

    private String personalType;

    public Manager() {
        super();
    }

    public Manager(int userId, String userFirstName, String userLastName, int userAge, int userPhone, String userPassword) {
        super(userId, userFirstName, userLastName, userAge, userPhone, userPassword);
    }

    public Manager(String userFirstName, String userLastName, int userAge, String userPassword, String personalType) {
        super(userFirstName, userLastName, userAge, userPassword);
        this.personalType = personalType;
    }

    public Manager(int userId, String userFirstName, String userLastName, int userAge, String userPassword, String personalType) {
        super(userId, userFirstName, userLastName, userAge, userPassword);
        this.personalType = personalType;
    }

    public String getPersonalType() {
        return personalType;
    }

    public void setPersonalType(String personalType) {
        this.personalType = personalType;
    }
}
