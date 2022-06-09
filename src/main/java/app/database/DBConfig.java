package app.database;

public class DBConfig {
    private String dbHost = "localhost";
    private String dbPort = "3306";
    private String dbUser = "dmitry";
    private String dbPass = "2022L;fdf";
    private String dbName = "onlinebankdb";

    public String getDbHost() {
        return dbHost;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public String getDbName() {
        return dbName;
    }

}
