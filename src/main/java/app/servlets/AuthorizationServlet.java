package app.servlets;

import app.database.DBController;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/private/authorization")
public class AuthorizationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession(true);
            String firstName = req.getParameter("userFirstName");
            String lastName = req.getParameter("userLastName");
            String password = req.getParameter("userPassword");
            String isManager = req.getParameter("isManager");
            int[] logIn = DBController.loginUser(firstName, lastName, password, isManager);
            switch (logIn[0]) {
                case 0 -> {
                    session.setAttribute("clientId", logIn[1]);
                    session.setAttribute("managerId", null);
                    session.setAttribute("isLogged", true);
                    resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientPage");
                }
                case 1 -> {
                    session.setAttribute("managerId", logIn[1]);
                    session.setAttribute("clientId", null);
                    session.setAttribute("isLogged", true);
                    resp.sendRedirect(req.getContextPath() + "/private/personalViews/managerPage");
                }
                default -> {
                    session.invalidate();
                    System.out.println("!ПОЛЬЗОВАТЕЛЬ НЕ НАЙДЕН!");
                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                }
            }
        }
        catch(SQLException e) {
         e.printStackTrace();
        }
    }
}
