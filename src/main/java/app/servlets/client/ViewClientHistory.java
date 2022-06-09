package app.servlets.client;

import app.database.handlers.history.DBClientHistoryHandler;
import app.model.history.ClientHistory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/clientViews/viewClientHistory")
public class ViewClientHistory extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            ArrayList<ClientHistory> histories = DBClientHistoryHandler.select(clientId);
            req.setAttribute("histories", histories);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/clientViews/viewClientHistory.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
