package app.servlets.client;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.users.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/personalViews/createClient")
public class CreateClientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/createClient.jsp");
            requestDispatcher.forward(req, resp);
        } catch (IOException | NumberFormatException e) {
         e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        try {
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            int age = Integer.parseInt(req.getParameter("age"));
            int phone = Integer.parseInt(req.getParameter("phone"));
            String pass = req.getParameter("password");
            Client client = new Client(firstName, lastName, age, phone, pass, 0, 0, 0);
            DBClientHandler.insert(client);
            DBClientHistoryHandler.createTable(DBClientHandler.selectByName(client.getUserFirstName(), client.getUserLastName()));
            DBPersonalHistoryHandler.insert("Client Id=" + DBClientHandler.selectByName(client.getUserFirstName(), client.getUserLastName()) + " added to DB", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllClients");
        }
        catch(IOException | NumberFormatException e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/createClient.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
