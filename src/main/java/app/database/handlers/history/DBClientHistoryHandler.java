package app.database.handlers.history;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.history.ClientHistory;
import app.model.history.PersonalHistory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DBClientHistoryHandler extends DBConnect {

    public static void createTable(int id) {
        String sql = "CREATE TABLE " + DBConstants.CLIENT_HISTORY_TABLE + id + " (Number INT PRIMARY KEY AUTO_INCREMENT, Action VARCHAR(50), Date VARCHAR(40))";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ClientHistory> select(int id) {
        ArrayList<ClientHistory> histories = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CLIENT_HISTORY_TABLE + id;
        try{
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String action = resultSet.getString(2);
                String date = resultSet.getString(3);
                ClientHistory clientHistory = new ClientHistory(number, action, date);
                histories.add(clientHistory);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return histories;
    }

    public static int insert(String action, int id) {
        String sql = "INSERT INTO " + DBConstants.CLIENT_HISTORY_TABLE + id + "( " + DBConstants.CLIENT_HISTORY_ACTION + "," +
                DBConstants.CLIENT_HISTORY_DATE + ") Values (?, ?)";
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, action);
            preparedStatement.setString(2, dateTime.format(formatter));
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void deleteTable(int id) {
        String sql = "DROP TABLE " + DBConstants.CLIENT_HISTORY_TABLE + id + ";";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
