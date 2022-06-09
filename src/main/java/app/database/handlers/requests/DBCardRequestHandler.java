package app.database.handlers.requests;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.bank.request.CardRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCardRequestHandler extends DBConnect {

    public static ArrayList<CardRequest> select() {
        ArrayList<CardRequest> cardRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CARD_REQUEST_TABLE;
        try{
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int crdNum = resultSet.getInt(3);
                int userId = resultSet.getInt(4);
                String fname = resultSet.getString(5);
                String lname = resultSet.getString(6);
                String status = resultSet.getString(7);
                CardRequest cardRequest = new CardRequest(number, type, crdNum, userId, fname, lname, status);
                cardRequests.add(cardRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cardRequests;
    }

    public static int insert(CardRequest cardRequest) {
        String sql = "INSERT INTO " + DBConstants.CARD_REQUEST_TABLE + " (" + DBConstants.CARD_REQUEST_NUMBER + ","
                + DBConstants.CARD_REQUEST_TYPE + "," + DBConstants.CARD_REQUEST_CRDNUMBER + "," +
                DBConstants.CARD_REQUEST_CLIENT_ID + "," + DBConstants.CARD_REQUEST_CLIENT_FIRSTNAME + ","
                + DBConstants.CARD_REQUEST_CLIENT_LASTNAME + "," +
                DBConstants.CARD_REQUEST_STATUS + ") Values (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, cardRequest.getRequestNumber());
            preparedStatement.setString(2, cardRequest.getRequestType());
            preparedStatement.setInt(3, cardRequest.getCardNumber());
            preparedStatement.setInt(4, cardRequest.getRequestUserId());
            preparedStatement.setString(5, cardRequest.getRequestUserFirstname());
            preparedStatement.setString(6, cardRequest.getRequestUserLastname());
            preparedStatement.setString(7, cardRequest.getRequestStatus());
            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateStatus(String status, int userId, int requestNumber) {
        String sql = "UPDATE " + DBConstants.CARD_REQUEST_TABLE + " SET " + DBConstants.CARD_REQUEST_STATUS + " = ? " + "WHERE " + DBConstants.CARD_REQUEST_CLIENT_ID + " = ? AND " + DBConstants.CARD_REQUEST_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, requestNumber);
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<CardRequest> selectAllById(int id) {
        ArrayList<CardRequest> cardRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CARD_REQUEST_TABLE + " WHERE " + DBConstants.CARD_REQUEST_CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int crdNum = resultSet.getInt(3);
                int userId = resultSet.getInt(4);
                String fname = resultSet.getString(5);
                String lname = resultSet.getString(6);
                String status = resultSet.getString(7);
                CardRequest cardRequest = new CardRequest(number, type, crdNum, userId, fname, lname, status);
                cardRequests.add(cardRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cardRequests;
    }

    public static ArrayList<CardRequest> selectAllByStatus(String status) {
        ArrayList<CardRequest> cardRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CARD_REQUEST_TABLE + " WHERE " + DBConstants.CARD_REQUEST_STATUS + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int crdNum = resultSet.getInt(3);
                int id = resultSet.getInt(4);
                String fname = resultSet.getString(5);
                String lname = resultSet.getString(6);
                String reqStatus = resultSet.getString(7);
                CardRequest cardRequest = new CardRequest(number, type, crdNum, id, fname, lname, reqStatus);
                cardRequests.add(cardRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cardRequests;
    }

    public static int delete(int number) {
        String sql = "DELETE FROM " + DBConstants.CARD_REQUEST_TABLE + " WHERE " + DBConstants.CARD_REQUEST_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            return preparedStatement.executeUpdate();
        }catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
