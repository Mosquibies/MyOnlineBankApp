package app.servlets.credit;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.produtcs.DBCreditHandler;
import app.database.handlers.produtcs.DBInvoiceHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.bank.operation.CreditOperation;
import app.model.bank.product.Credit;
import app.model.bank.product.Invoice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/clientViews/earlyCreditPayment")
public class EarlyCreditPaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int creditNumber = Integer.parseInt(req.getParameter("crdNum"));
            Credit credit = DBCreditHandler.selectOneByNumber(creditNumber);
            req.setAttribute("credit", credit);
            int id = Integer.parseInt(req.getParameter("id"));
            ArrayList<Invoice> invoices = DBInvoiceHandler.selectAllById(id);
            req.setAttribute("invoices", invoices);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/bankProductsViews/earlyCreditPayment.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            int invoiceNumber = Integer.parseInt(req.getParameter("invNum"));
            Invoice invoice = DBInvoiceHandler.selectOneByNumber(invoiceNumber);
            int creditNumber = Integer.parseInt(req.getParameter("crdNum"));
            Credit credit = DBCreditHandler.selectOneByNumber(creditNumber);
            float newBalance = new CreditOperation().repayCredit(invoice, credit);
            if (credit.getSum() == 0) {
                DBInvoiceHandler.updateBalance(newBalance, invoiceNumber);
                DBCreditHandler.delete(creditNumber);
                DBClientHandler.updateCreditsCount(DBCreditHandler.selectAllById(clientId).size(), clientId);
                DBClientHistoryHandler.insert("Credit number=" + creditNumber + " closed", clientId);
            }
            DBClientHistoryHandler.insert("Invoice number= " + invoiceNumber + " has no such money", clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientCredits");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
