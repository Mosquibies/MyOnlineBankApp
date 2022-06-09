package app.servlets.invoice;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.produtcs.DBInvoiceHandler;
import app.database.handlers.requests.DBInvoiceRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.bank.operation.InvoiceOperation;
import app.model.bank.product.Invoice;
import app.model.bank.request.InvoiceRequest;
import app.model.users.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/closeInvoiceRequest")
public class CloseInvoiceRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            int number = Integer.parseInt(req.getParameter("number"));
            Client client = DBClientHandler.selectOneById(clientId);
            Invoice invoice = DBInvoiceHandler.selectOneByNumber(number);
            InvoiceRequest invoiceRequest = new InvoiceOperation().sendCloseInvoiceRequest(client, invoice);
            DBInvoiceRequestHandler.insert(invoiceRequest);
            req.setAttribute("invoiceRequest", invoiceRequest);
            DBClientHistoryHandler.insert("Close invoice request, number = " + invoiceRequest.getRequestNumber(), clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientRequests");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
