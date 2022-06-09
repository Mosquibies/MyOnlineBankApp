package app.servlets.invoice;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.requests.DBInvoiceRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.bank.operation.InvoiceOperation;
import app.model.bank.request.InvoiceRequest;
import app.model.users.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/openInvoiceRequest")
public class OpenInvoiceRequestServlet extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            Client client = DBClientHandler.selectOneById(clientId);
            InvoiceRequest invoiceRequest = new InvoiceOperation().sendOpenInvoiceRequest(client);
            DBInvoiceRequestHandler.insert(invoiceRequest);
            req.setAttribute("invoiceRequest", invoiceRequest);
            DBClientHistoryHandler.insert("Open invoice request, number = " + invoiceRequest.getRequestNumber(), clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientRequests");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
