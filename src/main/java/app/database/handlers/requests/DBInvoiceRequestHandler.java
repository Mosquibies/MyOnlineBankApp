package app.database.handlers.requests;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.bank.request.InvoiceRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBInvoiceRequestHandler extends DBConnect {

    public static ArrayList<InvoiceRequest> select() {
        ArrayList<InvoiceRequest> invoiceRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.INVOICE_REQUEST_TABLE;
        try {
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int invNum = resultSet.getInt(3);
                int id = resultSet.getInt(4);
                String firstname = resultSet.getString(5);
                String lastname = resultSet.getString(6);
                String status = resultSet.getString(7);
                InvoiceRequest invoiceRequest = new InvoiceRequest(number, type, invNum,id, firstname, lastname, status);
                invoiceRequests.add(invoiceRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoiceRequests;
    }

    public static int insert(InvoiceRequest invoiceRequest) {
        String sql = "INSERT INTO " + DBConstants.INVOICE_REQUEST_TABLE + " (" + DBConstants.INVOICE_REQUEST_NUMBER + ","
                + DBConstants.INVOICE_REQUEST_TYPE + "," + DBConstants.INVOICE_REQUEST_INVNUMBER + ","
                + DBConstants.INVOICE_REQUEST_CLIENT_ID + "," + DBConstants.INVOICE_REQUEST_CLIENT_FIRSTNAME + "," + DBConstants.INVOICE_REQUEST_CLIENT_LASTNAME + "," + DBConstants.INVOICE_REQUEST_STATUS + ") Values (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, invoiceRequest.getRequestNumber());
            preparedStatement.setString(2, invoiceRequest.getRequestType());
            preparedStatement.setInt(3, invoiceRequest.getInvoiceNumber());
            preparedStatement.setInt(4, invoiceRequest.getRequestUserId());
            preparedStatement.setString(5, invoiceRequest.getRequestUserFirstname());
            preparedStatement.setString(6, invoiceRequest.getRequestUserLastname());
            preparedStatement.setString(7, invoiceRequest.getRequestStatus());

            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public static int updateStatus(String status, int userId, int requestNumber) {
        String sql = "UPDATE " + DBConstants.INVOICE_REQUEST_TABLE + " SET " + DBConstants.INVOICE_REQUEST_STATUS + " = ? " + "WHERE " + DBConstants.INVOICE_REQUEST_CLIENT_ID + " = ? AND " + DBConstants.INVOICE_REQUEST_NUMBER + " = ?";
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

    public static ArrayList<InvoiceRequest> selectAllById (int id) {
        ArrayList<InvoiceRequest> invoiceRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.INVOICE_REQUEST_TABLE + " WHERE " +  DBConstants.INVOICE_REQUEST_CLIENT_ID + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int invNum = resultSet.getInt(3);
                int userId = resultSet.getInt(4);
                String firstname = resultSet.getString(5);
                String lastname = resultSet.getString(6);
                String status = resultSet.getString(7);
                InvoiceRequest invoiceRequest = new InvoiceRequest(number, type, invNum, userId, firstname, lastname, status);
                invoiceRequests.add(invoiceRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoiceRequests;
    }

    public static ArrayList<InvoiceRequest> selectAllByStatus (String status) {
        ArrayList<InvoiceRequest> invoiceRequests = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.INVOICE_REQUEST_TABLE + " WHERE " +  DBConstants.INVOICE_REQUEST_STATUS + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                int invNum = resultSet.getInt(3);
                int id = resultSet.getInt(4);
                String firstname = resultSet.getString(5);
                String lastname = resultSet.getString(6);
                String reqStatus = resultSet.getString(7);
                InvoiceRequest invoiceRequest = new InvoiceRequest(number, type, invNum, id, firstname, lastname, reqStatus);
                invoiceRequests.add(invoiceRequest);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoiceRequests;
    }

    public static int delete(int number) {
        String sql = "DELETE FROM " + DBConstants.INVOICE_REQUEST_TABLE + " WHERE " + DBConstants.INVOICE_REQUEST_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            return preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
