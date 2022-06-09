package app.servlets.card;

import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.produtcs.DBCardHandler;
import app.database.handlers.produtcs.DBInvoiceHandler;
import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.bank.operation.CardOperation;
import app.model.bank.operation.InvoiceOperation;
import app.model.bank.product.Card;
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

@WebServlet(urlPatterns = "/private/personalViews/approveCardRequest")
public class ApproveCardRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, NumberFormatException, NullPointerException {
        try {
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            String status = ProductRequestStatus.APPROVED.getTitle();
            InvoiceOperation invoiceOperation = new InvoiceOperation();
            CardOperation cardOperation = new CardOperation();
            int id = Integer.parseInt(req.getParameter("id"));
            int number = Integer.parseInt(req.getParameter("cardNumber"));
            String type = req.getParameter("op");
            System.out.println(type);
            int crd = Integer.parseInt(req.getParameter("crd"));
            System.out.println(crd);
            DBCardRequestHandler.updateStatus(status, id, number);
            if(Objects.equals(type, "Open")){
                Invoice invoice = invoiceOperation.openInvoice(DBClientHandler.selectOneById(id));
                DBInvoiceHandler.insert(invoice);
                Card card = cardOperation.openCard(DBClientHandler.selectOneById(id), invoice);
                DBCardHandler.insert(card);
                DBPersonalHistoryHandler.insert("Card request number=" + number + " approved", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
                DBPersonalHistoryHandler.insert("Invoice number=" + invoice.getNumber() + " opened", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
                DBPersonalHistoryHandler.insert("Card number=" + card.getNumber() + " opened", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            } else {
                DBCardHandler.delete(crd);
                DBPersonalHistoryHandler.insert("Card number=" + crd + " closed", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            }
            DBClientHandler.updateCardsCount(DBCardHandler.selectAllById(id).size(), id);
            DBClientHandler.updateInvoicesCount(DBInvoiceHandler.selectAllById(id).size(), id);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllActiveRequests");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
