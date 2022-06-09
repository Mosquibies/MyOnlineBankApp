package app.servlets.client;

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

@WebServlet(urlPatterns = "/private/personalViews/editClient")
public class EditClientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int clientId = Integer.parseInt(req.getParameter("id"));
            Client client = DBClientHandler.selectOneById(clientId);
            if(client!=null) {
                req.setAttribute("client", client);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/editClient.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/userNotFound.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        catch(ServletException | IOException e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/userNotFound.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            int id = Integer.parseInt(req.getParameter("id"));
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            int age = Integer.parseInt(req.getParameter("age"));
            int phone = Integer.parseInt(req.getParameter("phone"));
            String pass = req.getParameter("password");
            int invoices = Integer.parseInt(req.getParameter("invoices"));
            int cards = Integer.parseInt(req.getParameter("cards"));
            int credits = Integer.parseInt(req.getParameter("credits"));
            Client client = new Client(id, firstName, lastName, age, phone, pass, invoices, cards, credits);
            DBClientHandler.update(client);
            DBPersonalHistoryHandler.insert("Client's Id=" + id + " personal data updated", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllClients");
        }
        catch(IOException e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/userViews/notFound.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
