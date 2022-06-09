package app.servlets.request;

import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.requests.DBCreditRequestHandler;
import app.database.handlers.requests.DBInvoiceRequestHandler;
import app.model.bank.request.CardRequest;
import app.model.bank.request.CreditRequest;
import app.model.bank.request.InvoiceRequest;
import app.model.bank.request.ProductRequestStatus;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/personalViews/viewAllActiveRequests")
public class ViewAllActiveRequestsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String status = ProductRequestStatus.UNDER_CONSIDERATION.getTitle();
            ArrayList<InvoiceRequest> invoiceRequests = DBInvoiceRequestHandler.selectAllByStatus(status);
            req.setAttribute("invoiceRequests", invoiceRequests);
            ArrayList<CardRequest> cardRequests = DBCardRequestHandler.selectAllByStatus(status);
            req.setAttribute("cardRequests", cardRequests);
            ArrayList<CreditRequest> creditRequests = DBCreditRequestHandler.selectAllByStatus(status);
            req.setAttribute("creditRequests", creditRequests);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/viewAllRequests.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
