package app.database.handlers.history;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.history.PersonalHistory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DBPersonalHistoryHandler extends DBConnect {

    public static void createTable(int id, String role) {
        String sql = "CREATE TABLE " + DBConstants.PERSONAL_HISTORY_TABLE + role + "_" + id +
                " (Number INT PRIMARY KEY AUTO_INCREMENT, PersonalId INT, PersonalRole VARCHAR(30), Action VARCHAR(50), Date VARCHAR(40))";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<PersonalHistory> select(String role, int id) {
        ArrayList<PersonalHistory> histories = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.PERSONAL_HISTORY_TABLE + role + "_" + id;
        try{
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                int persId = resultSet.getInt(2);
                String persRole = resultSet.getString(3);
                String action = resultSet.getString(4);
                String date = resultSet.getString(5);
                PersonalHistory personalHistory = new PersonalHistory(number, persId, persRole, action, date);
                histories.add(personalHistory);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return histories;
    }

    public static int insert(String action, String role, int id) {
        String sql = "INSERT INTO " + DBConstants.PERSONAL_HISTORY_TABLE + role + "_" + id + "( " + DBConstants.PERSONAL_HISTORY_ID + "," +
                DBConstants.PERSONAL_HISTORY_ROLE + "," +
                DBConstants.PERSONAL_HISTORY_ACTION + "," +
                DBConstants.PERSONAL_HISTORY_DATE + ") Values (?, ?, ?, ?)";
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, role);
            preparedStatement.setString(3, action);
            preparedStatement.setString(4, dateTime.format(formatter));
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void deleteTable(String role, int id) {
        String sql = "DROP TABLE " + DBConstants.PERSONAL_HISTORY_TABLE + role + "_" + id + ";";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
