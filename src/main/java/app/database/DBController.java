package app.database;

import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.users.Client;
import app.model.users.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class DBController {

    public static int [] loginUser(String firstNameText, String lastNameText, String passwordText, String isManager) throws SQLException {
        ResultSet res;
        int nums [] = new int[2];
        if (Objects.equals(isManager, "on"))  {
            Manager manager = new Manager();
            manager.setUserFirstName(firstNameText);
            manager.setUserLastName(lastNameText);
            manager.setUserPassword(passwordText);
            res = DBManagerHandler.getManagerToAuthorization(manager);
            nums[1] = DBManagerHandler.selectByName(manager.getUserFirstName(), manager.getUserLastName());
            System.out.println(nums[1]);
        }
        else {
            Client client = new Client();
            client.setUserFirstName(firstNameText);
            client.setUserLastName(lastNameText);
            client.setUserPassword(passwordText);
            res = DBClientHandler.getClientToAuthorization(client);
            nums[1] = DBClientHandler.selectByName(client.getUserFirstName(), client.getUserLastName());
        }

        int counter = 0;

        while(res.next()) {
            counter++;
        }
        if(counter >= 1 & Objects.equals(isManager, null)) {
            System.out.println("CLIENT FINDING SUCCESS!!!");
            nums[0] = 0;
            return nums;
        } else if (counter >= 1 & Objects.equals(isManager, "on")) {
            System.out.println("MANAGER FINDING SUCCESS!!!");
            nums[0] = 1;
            return nums;
        }
        else {
            System.out.println("USER NOT FOUND IN DATABASE");
            nums[0] = 2;
            nums[1] = 0;
            return nums;
        }
    }
}
