package app.servlets.request;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.requests.DBCreditRequestHandler;
import app.database.handlers.requests.DBInvoiceRequestHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/deleteRequest")
public class DeleteRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            int number = Integer.parseInt(req.getParameter("number"));
            DBInvoiceRequestHandler.delete(number);
            DBCreditRequestHandler.delete(number);
            DBCardRequestHandler.delete(number);
            DBClientHistoryHandler.insert("Delete request, number=" + number, clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientRequests");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
