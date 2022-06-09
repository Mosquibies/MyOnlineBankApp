package app.servlets.request;

import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.requests.DBCreditRequestHandler;
import app.database.handlers.requests.DBInvoiceRequestHandler;
import app.model.bank.request.CardRequest;
import app.model.bank.request.CreditRequest;
import app.model.bank.request.InvoiceRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/clientViews/clientRequests")
public class ViewAllClientRequestsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            ArrayList<InvoiceRequest> invoiceRequests = DBInvoiceRequestHandler.selectAllById(clientId);
            req.setAttribute("invoiceRequests", invoiceRequests);
            ArrayList<CreditRequest> creditRequests = DBCreditRequestHandler.selectAllById(clientId);
            req.setAttribute("creditRequests", creditRequests);
            ArrayList<CardRequest> cardRequests = DBCardRequestHandler.selectAllById(clientId);
            req.setAttribute("cardRequests", cardRequests);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/clientViews/clientRequests.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/private/clientViews/notFound.jsp").forward(req, resp);
        }

    }

}
