package app.servlets;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.users.Client;
import app.model.users.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session.getAttribute("managerId") != null) {
            int managerId = (int) session.getAttribute("managerId");
            Manager manager = DBManagerHandler.selectOneById(managerId);
            DBPersonalHistoryHandler.insert("Personal " + manager.getUserFirstName() + " " + manager.getUserLastName() + " log out", manager.getPersonalType(), manager.getUserId());
        }
        else if (session.getAttribute("clientId")!=null) {
            int clientId = (int) session.getAttribute("clientId");
            Client client = DBClientHandler.selectOneById(clientId);
            DBClientHistoryHandler.insert("Client " + client.getUserFirstName() + " " + client.getUserLastName() + " log out", clientId);
        }
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
