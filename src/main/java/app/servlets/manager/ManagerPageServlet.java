package app.servlets.manager;

import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.users.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/personalViews/managerPage")
public class ManagerPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException{
        try {
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            Manager manager = DBManagerHandler.selectOneById(managerId);
            req.setAttribute("manager", manager);
            DBPersonalHistoryHandler.insert("Personal " + manager.getUserFirstName() + " " + manager.getUserLastName() + " log in", manager.getPersonalType(), manager.getUserId());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/managerPage.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
