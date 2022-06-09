package app.servlets.manager;

import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.history.PersonalHistory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/personalViews/viewPersonalHistory")
public class ViewPersonalHistory extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            ArrayList<PersonalHistory> histories = DBPersonalHistoryHandler.select(DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            req.setAttribute("histories", histories);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/viewPersonalHistory.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
        e.printStackTrace();
        }
    }
}
