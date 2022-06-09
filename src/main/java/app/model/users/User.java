package app.model.users;

public abstract class User {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private int userAge;
    private int userPhone;
    private String userPassword;

    public User() {}

    public User(String userFirstName, String userLastName, int userAge, String userPassword) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userPassword = userPassword;
    }

    public User(int userId, String userFirstName, String userLastName, int userAge, String userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userPassword = userPassword;
    }

    public User(String userFirstName, String userLastName, int userAge, int userPhone, String userPassword) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public User(int userId, String userFirstName, String userLastName, int userAge, int userPhone, String userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
