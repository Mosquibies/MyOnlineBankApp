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
import java.io.IOException;

@WebServlet(urlPatterns = "/createManager")
public class CreateManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/createManager.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            int age = Integer.parseInt(req.getParameter("age"));
            String pass = req.getParameter("password");
            String type = "Manager";
            Manager manager = new Manager(firstName, lastName, age, pass, type);
            DBManagerHandler.insert(manager);
            DBPersonalHistoryHandler.createTable(DBManagerHandler.selectByName(manager.getUserFirstName(), manager.getUserLastName()), manager.getPersonalType());
            DBPersonalHistoryHandler.insert("Personal " + manager.getUserFirstName() + " " + manager.getUserLastName() + " was added to DB", manager.getPersonalType(), DBManagerHandler.selectByName(manager.getUserFirstName(), manager.getUserLastName()));
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
        catch(IOException | NumberFormatException e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/createManager.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
