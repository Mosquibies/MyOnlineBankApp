package app.database.handlers.users;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.users.Client;

import java.sql.*;
import java.util.ArrayList;

public class DBClientHandler extends DBConnect {

    public static ArrayList<Client> select() {
        ArrayList<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CLIENT_TABLE;
        try {
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                int phone = resultSet.getInt(5);
                String pass = resultSet.getString(6);
                int invoices = resultSet.getInt(7);
                int cards = resultSet.getInt(8);
                int credits = resultSet.getInt(9);
                Client client = new Client(id, firstName, lastName, age, phone, pass, invoices, cards, credits);
                clients.add(client);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static Client selectOneById (int id) {
        Client client = null;
        String sql = "SELECT * FROM " + DBConstants.CLIENT_TABLE + " WHERE " +  DBConstants.CLIENT_ID + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int userId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                int phone = resultSet.getInt(5);
                String pass = resultSet.getString(6);
                int invoices = resultSet.getInt(7);
                int cards = resultSet.getInt(8);
                int credits = resultSet.getInt(9);
                client = new Client(userId, firstName, lastName, age, phone, pass, invoices, cards, credits);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return client;
    }

    public static int selectByName(String firstname, String lastname) {
        Client client = null;
        String sql = "SELECT * FROM " + DBConstants.CLIENT_TABLE + " WHERE " + DBConstants.CLIENT_FIRSTNAME + " = ? AND " + DBConstants.CLIENT_LASTNAME + " = ? ";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                int userPhone = resultSet.getInt(5);
                String pass = resultSet.getString(6);
                int invoices = resultSet.getInt(7);
                int cards = resultSet.getInt(8);
                int credits = resultSet.getInt(9);
                client = new Client(id, firstName, lastName, age, userPhone, pass, invoices, cards, credits);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (client != null) {
            return client.getUserId();
        }
        return 0;
    }

    public static int insert(Client client) {
        String sql = "INSERT INTO " + DBConstants.CLIENT_TABLE + " (" + DBConstants.CLIENT_FIRSTNAME + "," + DBConstants.CLIENT_LASTNAME + "," + DBConstants.CLIENT_AGE + "," +
                DBConstants.CLIENT_PHONE + "," + DBConstants.CLIENT_PASSWORD + "," + DBConstants.CLIENT_INVOICES + "," + DBConstants.CLIENT_CARDS + "," +
                DBConstants.CLIENT_CREDITS + ") Values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, client.getUserFirstName());
            preparedStatement.setString(2, client.getUserLastName());
            preparedStatement.setInt(3, client.getUserAge());
            preparedStatement.setInt(4, client.getUserPhone());
            preparedStatement.setString(5, client.getUserPassword());
            preparedStatement.setInt(6, client.getInvoicesCount());
            preparedStatement.setInt(7, client.getCardsCount());
            preparedStatement.setInt(8, client.getCreditCount());

            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public static int update(Client client) {
        String sql = "UPDATE " + DBConstants.CLIENT_TABLE + " SET " + DBConstants.CLIENT_FIRSTNAME + " = ?, " + DBConstants.CLIENT_LASTNAME + " = ?, " + DBConstants.CLIENT_AGE + " = ?, " +
                DBConstants.CLIENT_PHONE + " = ?, " + DBConstants.CLIENT_PASSWORD + " = ? WHERE " + DBConstants.CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, client.getUserFirstName());
            preparedStatement.setString(2, client.getUserLastName());
            preparedStatement.setInt(3, client.getUserAge());
            preparedStatement.setInt(4, client.getUserPhone());
            preparedStatement.setString(5, client.getUserPassword());
            preparedStatement.setInt(6, client.getUserId());

            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int delete(int id) {
        String sql = "DELETE FROM " + DBConstants.CLIENT_TABLE + " WHERE " + DBConstants.CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ResultSet getClientToAuthorization(Client client) {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM " + DBConstants.CLIENT_TABLE + " WHERE " + DBConstants.CLIENT_FIRSTNAME + "= ? AND " +
                DBConstants.CLIENT_LASTNAME + " = ? AND " + DBConstants.CLIENT_PASSWORD + " = ? ";
        try{
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql);
            preparedStatement.setString(1, client.getUserFirstName());
            preparedStatement.setString(2, client.getUserLastName());
            preparedStatement.setString(3, client.getUserPassword());
            resultSet = preparedStatement.executeQuery();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static int updateInvoicesCount(int invoicesCount, int id) {
        String sql = "UPDATE " + DBConstants.CLIENT_TABLE + " SET " + DBConstants.CLIENT_INVOICES + " = ? WHERE " + DBConstants.CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, invoicesCount);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateCardsCount(int cardsCount, int id) {
        String sql = "UPDATE " + DBConstants.CLIENT_TABLE + " SET " + DBConstants.CLIENT_CARDS + " = ? WHERE " + DBConstants.CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, cardsCount);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateCreditsCount(int creditsCount, int id) {
        String sql = "UPDATE " + DBConstants.CLIENT_TABLE + " SET " + DBConstants.CLIENT_CREDITS + " = ? WHERE " + DBConstants.CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, creditsCount);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
