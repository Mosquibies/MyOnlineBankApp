package app.servlets.client;

import app.database.handlers.users.DBClientHandler;
import app.model.users.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/personalViews/viewAllClients")
public class ViewClientsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Client> clients = DBClientHandler.select();
            req.setAttribute("clients", clients);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/viewAllClients.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
