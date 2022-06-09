package app.servlets.invoice;

import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.produtcs.DBInvoiceHandler;
import app.database.handlers.requests.DBInvoiceRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.bank.operation.InvoiceOperation;
import app.model.bank.product.Invoice;
import app.model.bank.request.ProductRequestStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/private/personalViews/approveInvoiceRequest")
public class ApproveInvoiceRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            String status = ProductRequestStatus.APPROVED.getTitle();
            InvoiceOperation invoiceOperation = new InvoiceOperation();
            int id = Integer.parseInt(req.getParameter("id"));
            int number = Integer.parseInt(req.getParameter("invoiceNumber"));
            int inv = Integer.parseInt(req.getParameter("inv"));
            String type = req.getParameter("op");
            DBInvoiceRequestHandler.updateStatus(status, id, number);
            if(Objects.equals(type, "Open")) {
                Invoice invoice = invoiceOperation.openInvoice(DBClientHandler.selectOneById(id));
                DBInvoiceHandler.insert(invoice);
                DBPersonalHistoryHandler.insert("Invoice request number=" + number + " approved", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
                DBPersonalHistoryHandler.insert("Invoice number=" + invoice.getNumber() + " opened", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            } else {
                DBInvoiceHandler.delete(inv);
                DBPersonalHistoryHandler.insert("Invoice number=" + inv + " closed", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            }
            DBClientHandler.updateInvoicesCount(DBInvoiceHandler.selectAllById(id).size(), id);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllActiveRequests");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
