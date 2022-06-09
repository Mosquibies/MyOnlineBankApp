package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect extends DBConfig {
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        DBConfig dbConfig = new DBConfig();
        String connectionString = "jdbc:mysql://" + dbConfig.getDbHost() + ":" + dbConfig.getDbPort() + "/" + dbConfig.getDbName();
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionString, dbConfig.getDbUser(), dbConfig.getDbPass());
    }
}
