package app.database.handlers.produtcs;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.bank.product.Invoice;

import java.sql.*;
import java.util.ArrayList;

public class DBInvoiceHandler extends DBConnect {

    public static ArrayList<Invoice> select() {
        ArrayList<Invoice> invoices = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.INVOICE_TABLE;
        try{
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                float balance = resultSet.getFloat(2);
                int id = resultSet.getInt(3);
                Invoice invoice = new Invoice(number, balance, id);
                invoices.add(invoice);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    public static ArrayList<Invoice> selectAllById (int id) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.INVOICE_TABLE + " WHERE " +  DBConstants.INVOICE_CLIENT_ID + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                float balance = resultSet.getFloat(2);
                int userId = resultSet.getInt(3);
                Invoice invoice = new Invoice(number, balance, userId);
                invoices.add(invoice);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoices;
    }

    public static Invoice selectOneByNumber (int number) {
        Invoice invoice = null;
        String sql = "SELECT * FROM " + DBConstants.INVOICE_TABLE + " WHERE " +  DBConstants.INVOICE_NUMBER + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int invoiceNumber = resultSet.getInt(1);
                float balance = resultSet.getFloat(2);
                int userId = resultSet.getInt(3);
                invoice = new Invoice(invoiceNumber, balance, userId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return invoice;
    }

    public static int insert(Invoice invoice) {
        String sql = "INSERT INTO " + DBConstants.INVOICE_TABLE + " (" + DBConstants.INVOICE_NUMBER + "," + DBConstants.INVOICE_BALANCE + "," + DBConstants.INVOICE_CLIENT_ID +
                ") Values (?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, invoice.getNumber());
            preparedStatement.setFloat(2, invoice.getBalance());
            preparedStatement.setInt(3, invoice.getClientId());
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateBalance(float balance, int number) {
        String sql = "UPDATE " + DBConstants.INVOICE_TABLE + " SET " + DBConstants.INVOICE_BALANCE + " = ?  WHERE " + DBConstants.INVOICE_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setFloat(1, balance);
            preparedStatement.setInt(2, number);
            return preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int delete(int number) {
        String sql = "DELETE FROM " + DBConstants.INVOICE_TABLE + " WHERE " + DBConstants.INVOICE_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            return preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
