package app.servlets.client;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.users.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/clientPage")
public class ClientPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            Client client = DBClientHandler.selectOneById(clientId);
            req.setAttribute("client", client);
            DBClientHistoryHandler.insert("Client " + client.getUserFirstName() + " " + client.getUserLastName() + " log in", clientId);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/clientViews/clientPage.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
