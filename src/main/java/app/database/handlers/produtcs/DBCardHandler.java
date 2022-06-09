package app.database.handlers.produtcs;

import app.database.DBConnect;
import app.database.DBConstants;
import app.model.bank.product.Card;

import java.sql.*;
import java.util.ArrayList;

public class DBCardHandler extends DBConnect {

    public static ArrayList<Card> select() {
        ArrayList<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CARD_TABLE;
        try{
            ResultSet resultSet = getDbConnection().createStatement().executeQuery(sql);
            while(resultSet.next()) {
                int number = resultSet.getInt(1);
                int invoiceNumber = resultSet.getInt(2);
                float balance = resultSet.getFloat(3);
                int id = resultSet.getInt(4);
                Card card = new Card(number, invoiceNumber, balance, id);
                cards.add(card);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  cards;
    }

    public static Card selectOneById (int id) throws SQLException, ClassNotFoundException {
        Card card = null;
        String sql = "SELECT * FROM " + DBConstants.CARD_TABLE + " WHERE " + DBConstants.CARD_NUMBER + " = ?";
        try (PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                //  ПАРАМЕТРЫ БД КАРТ ЧЕРЕЗ resultSet.get...()
                card = new Card();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        getDbConnection().close();
        return card;
    }

    public static Card selectOneByNumber (int number) {
        Card card = null;
        String sql = "SELECT * FROM " + DBConstants.CARD_TABLE + " WHERE " + DBConstants.CARD_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int cardNumber = resultSet.getInt(1);
                int invoiceNumber = resultSet.getInt(2);
                float balance = resultSet.getFloat(3);
                int userId = resultSet.getInt(4);
                card = new Card(cardNumber, invoiceNumber, balance, userId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return card;
    }

    public static int insert(Card card) {
        String sql = "INSERT INTO " + DBConstants.CARD_TABLE + " (" + DBConstants.CARD_NUMBER + "," + DBConstants.CARD_INVOICE_NUMBER + "," + DBConstants.CARD_BALANCE +
                "," + DBConstants.CARD_CLIENT_ID + ") Values (?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, card.getNumber());
            preparedStatement.setInt(2, card.getInvoiceNumber());
            preparedStatement.setFloat(3, card.getBalance());
            preparedStatement.setInt(4, card.getClientId());
            return preparedStatement.executeUpdate();
        }
        catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int update(Card card) {
        String sql = "UPDATE" + DBConstants.CARD_TABLE + " SET WHERE " + DBConstants.CARD_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            //  ЧЕРЕЗ preparedStatement.set...()
            return preparedStatement.executeUpdate();
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int delete(int id) {
        String sql = "DELETE FROM " + DBConstants.CARD_TABLE + " WHERE " + DBConstants.CARD_NUMBER + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static ArrayList<Card> selectAllById (int id) {
        ArrayList<Card> cards = new ArrayList<>();
        String sql = "SELECT * FROM " + DBConstants.CARD_TABLE + " WHERE " + DBConstants.CARD_CLIENT_ID + " = ?";
        try(PreparedStatement preparedStatement = getDbConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int number = resultSet.getInt(1);
                int invoiceNumber = resultSet.getInt(2);
                float balance = resultSet.getFloat(3);
                int userId = resultSet.getInt(4);
                Card card = new Card(number, invoiceNumber, balance, userId);
                cards.add(card);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cards;
    }
}
