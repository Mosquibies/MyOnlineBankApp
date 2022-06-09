package app.database.handlers.requests;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.bank.request.CreditRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCreditRequestHandler extends DBConnect {

    public static ArrayList<CreditRequest> select() {
        ArrayList<CreditRequest> creditRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CREDIT_REQUEST_TABLE;
        try{
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int userId = resultSet.getInt(7);
                String fname = resultSet.getString(8);
                String lname = resultSet.getString(9);
                String status = resultSet.getString(10);
                CreditRequest creditRequest = new CreditRequest(number, type, sum, time, percent, payment, userId, fname, lname, status);
                creditRequests.add(creditRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return creditRequests;
    }

    public static int insert(CreditRequest creditRequest) {
        String sql = "INSERT INTO " + DBConstants.CREDIT_REQUEST_TABLE + " (" + DBConstants.CREDIT_REQUEST_NUMBER + "," + DBConstants.CREDIT_REQUEST_TYPE + ","
                + DBConstants.CREDIT_REQUEST_SUM + "," + DBConstants.CREDIT_REQUEST_TIME + "," + DBConstants.CREDIT_REQUEST_PERCENT + "," +
                DBConstants.CREDIT_REQUEST_PAYMENT + "," + DBConstants.CREDIT_REQUEST_CLIENT_ID + "," + DBConstants.CREDIT_REQUEST_CLIENT_FIRSTNAME +
                "," + DBConstants.CREDIT_REQUEST_CLIENT_LASTNAME + "," + DBConstants.CREDIT_REQUEST_STATUS + ") Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, creditRequest.getRequestNumber());
            preparedStatement.setString(2, creditRequest.getRequestType());
            preparedStatement.setFloat(3, creditRequest.getSum());
            preparedStatement.setInt(4, creditRequest.getTime());
            preparedStatement.setFloat(5, creditRequest.getPercent());
            preparedStatement.setFloat(6, creditRequest.getPayment());
            preparedStatement.setInt(7, creditRequest.getRequestUserId());
            preparedStatement.setString(8, creditRequest.getRequestUserFirstname());
            preparedStatement.setString(9, creditRequest.getRequestUserLastname());
            preparedStatement.setString(10, creditRequest.getRequestStatus());
            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<CreditRequest> selectAllById(int id) {
        ArrayList<CreditRequest> creditRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CREDIT_REQUEST_TABLE + " WHERE " + DBConstants.CREDIT_REQUEST_CLIENT_ID + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int userId = resultSet.getInt(7);
                String fname = resultSet.getString(8);
                String lname = resultSet.getString(9);
                String status = resultSet.getString(10);
                CreditRequest creditRequest = new CreditRequest(number, type, sum, time, percent, payment, userId, fname, lname, status);
                creditRequests.add(creditRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return creditRequests;
    }

    public static CreditRequest selectByNumberAndId(int number, int id) {
        CreditRequest creditRequest = new CreditRequest();
        String sql = "SELECT * FROM " + DBConstants.CREDIT_REQUEST_TABLE + " WHERE " + DBConstants.CREDIT_REQUEST_NUMBER + " = ? AND " + DBConstants.CREDIT_REQUEST_CLIENT_ID + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int reqNumber = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int reqId = resultSet.getInt(7);
                String fname = resultSet.getString(8);
                String lname = resultSet.getString(9);
                String reqStatus = resultSet.getString(10);
                creditRequest = new CreditRequest(reqNumber, type, sum, time, percent, payment, reqId, fname, lname, reqStatus);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return creditRequest;
    }

    public static ArrayList<CreditRequest> selectAllByStatus(String status) {
        ArrayList<CreditRequest> creditRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CREDIT_REQUEST_TABLE + " WHERE " + DBConstants.CREDIT_REQUEST_STATUS + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int id = resultSet.getInt(7);
                String fname = resultSet.getString(8);
                String lname = resultSet.getString(9);
                String reqStatus = resultSet.getString(10);
                CreditRequest creditRequest = new CreditRequest(number, type, sum, time, percent, payment, id, fname, lname, reqStatus);
                creditRequests.add(creditRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return creditRequests;
    }

    public static int delete(int number) {
        String sql = "DELETE FROM " + DBConstants.CREDIT_REQUEST_TABLE + " WHERE " + DBConstants.CREDIT_REQUEST_NUMBER + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateStatus(String status, int userId, int requestNumber) {
        String sql = "UPDATE " + DBConstants.CREDIT_REQUEST_TABLE + " SET " + DBConstants.CREDIT_REQUEST_STATUS + " = ? " + "WHERE " + DBConstants.CREDIT_REQUEST_CLIENT_ID + " = ? AND " + DBConstants.CREDIT_REQUEST_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, requestNumber);
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  0;
    }
}
