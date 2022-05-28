package app.servlets;

import app.database.DBController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("authorization.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String firstName = req.getParameter("userFirstName");
            String lastName = req.getParameter("userLastName");
            String password = req.getParameter("userPassword");
            String isManager = req.getParameter("isManager");
            int[] logIn = DBController.loginUser(firstName, lastName, password, isManager);
            switch (logIn[0]) {
                case 0 -> resp.sendRedirect(req.getContextPath() + "/clientPersonalArea?id=" + logIn[1]);
                case 1 -> resp.sendRedirect(req.getContextPath() + "/managerPersonalArea?managerId=" + logIn[1]);
                default -> resp.sendRedirect(req.getContextPath() + "/userViews/notFound.jsp");
            }
        }
        catch(SQLException e) {
         e.printStackTrace();
        }
    }
}
