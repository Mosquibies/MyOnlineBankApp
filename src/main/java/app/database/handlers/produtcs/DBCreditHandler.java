package app.database.handlers.produtcs;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.bank.product.Credit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCreditHandler extends DBConnect {

    public static ArrayList<Credit> select() {
        ArrayList<Credit> credits = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CREDIT_TABLE;
        try {
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int id = resultSet.getInt(7);
                Credit credit = new Credit(number, type, sum, time, percent, payment, id);
                credits.add(credit);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }

    public static Credit selectOneByNumber (int number) {
        Credit credit = null;
        String sql = "SELECT * FROM " + DBConstants.CREDIT_TABLE + " WHERE " + DBConstants.CREDIT_NUMBER + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int crdNumber = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int userId = resultSet.getInt(7);
                credit = new Credit(crdNumber, type, sum, time, percent, payment, userId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credit;
    }

    public static int insert(Credit credit) {
        String sql = "INSERT INTO " + DBConstants.CREDIT_TABLE + "(  " + DBConstants.CREDIT_NUMBER + "," +
                DBConstants.CREDIT_TYPE + "," + DBConstants.CREDIT_SUM + "," +
                DBConstants.CREDIT_TIME + "," + DBConstants.CREDIT_PERCENT + "," +
                DBConstants.CREDIT_PAYMENT + "," + DBConstants.CREDIT_CLIENT_ID + ") Values (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, credit.getNumber());
            preparedStatement.setString(2, credit.getCreditType());
            preparedStatement.setFloat(3, credit.getSum());
            preparedStatement.setInt(4, credit.getTime());
            preparedStatement.setFloat(5, credit.getPercent());
            preparedStatement.setFloat(6, credit.getPayment());
            preparedStatement.setInt(7, credit.getClientId());
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateSum(float sum, int number) {
        String sql = "UPDATE " + DBConstants.CREDIT_TABLE + " SET " + DBConstants.CREDIT_SUM + " = ? WHERE " + DBConstants.CREDIT_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setFloat(1, sum);
            preparedStatement.setInt(2, number);
            return preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int delete(int id) {
        String sql = "DELETE FROM " + DBConstants.CREDIT_TABLE + " WHERE " + DBConstants.CREDIT_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<Credit> selectAllById (int id) {
        ArrayList<Credit> credits = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CREDIT_TABLE + " WHERE " + DBConstants.CREDIT_CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                String type = resultSet.getString(2);
                float sum = resultSet.getFloat(3);
                int time = resultSet.getInt(4);
                float percent = resultSet.getFloat(5);
                float payment = resultSet.getFloat(6);
                int userId = resultSet.getInt(7);
                Credit credit = new Credit(number, type, sum, time, percent, payment, userId);
                credits.add(credit);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return credits;
    }
}
