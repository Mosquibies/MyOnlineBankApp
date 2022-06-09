package app.servlets.card;

import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.bank.request.ProductRequestStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/personalViews/rejectCardRequest")
public class RejectCardRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            String status = ProductRequestStatus.REJECTED.getTitle();
            int id = Integer.parseInt(req.getParameter("id"));
            int number = Integer.parseInt(req.getParameter("cardNumber"));
            DBCardRequestHandler.updateStatus(status, id, number);
            DBPersonalHistoryHandler.insert("Card request number=" + number + " rejected", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllActiveRequests");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
