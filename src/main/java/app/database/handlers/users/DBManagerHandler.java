package app.database.handlers.users;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.users.Client;
import app.model.users.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManagerHandler extends DBConnect {

    public static ResultSet getManagerToAuthorization(Manager manager) {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM " + DBConstants.PERSONAL_TABLE + " WHERE " + DBConstants.PERSONAL_FIRSTNAME + "= ? AND " +
                DBConstants.PERSONAL_LASTNAME + " = ? AND " + DBConstants.PERSONAL_PASSWORD + " = ? ";
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql);
            preparedStatement.setString(1, manager.getUserFirstName());
            preparedStatement.setString(2, manager.getUserLastName());
            preparedStatement.setString(3, manager.getUserPassword());
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static int insert(Manager manager) {
        String sql = "INSERT INTO " + DBConstants.PERSONAL_TABLE + " (" + DBConstants.PERSONAL_FIRSTNAME + "," + DBConstants.PERSONAL_LASTNAME + "," + DBConstants.PERSONAL_AGE + "," +
                DBConstants.CLIENT_PASSWORD + "," + DBConstants.PERSONAL_TYPE + ") Values (?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, manager.getUserFirstName());
            preparedStatement.setString(2, manager.getUserLastName());
            preparedStatement.setInt(3, manager.getUserAge());
            preparedStatement.setString(4, manager.getUserPassword());
            preparedStatement.setString(5, manager.getPersonalType());

            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public static ArrayList<Manager> select() {
        ArrayList<Manager> managers = new ArrayList<Manager>();
        String sql = "SELECT * FROM " + DBConstants.PERSONAL_TABLE;
        try {
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String pass = resultSet.getString(5);
                String type = resultSet.getString(6);
                Manager manager = new Manager(id, firstName, lastName, age, pass, type);
                managers.add(manager);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return managers;
    }

    public static int selectByName(String firstname, String lastname) {
        Manager manager = null;
        String sql = "SELECT * FROM " + DBConstants.PERSONAL_TABLE + " WHERE " + DBConstants.PERSONAL_FIRSTNAME + " = ? AND " + DBConstants.PERSONAL_LASTNAME + " = ? AND " + DBConstants.PERSONAL_TYPE + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, "Manager");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String pass = resultSet.getString(5);
                String type = resultSet.getString(6);
                manager = new Manager(id, firstName, lastName, age, pass, type);
            }
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
        if (manager != null) {
            return manager.getUserId();
        }
        return 0;
    }

    public static Manager selectOneById (int id) {
        Manager manager = null;
        String sql = "SELECT * FROM " + DBConstants.PERSONAL_TABLE + " WHERE " +  DBConstants.PERSONAL_ID + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int userId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String pass = resultSet.getString(6);
                String type = resultSet.getString(6);
                manager = new Manager(userId, firstName, lastName, age, pass, type);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return manager;
    }
}
