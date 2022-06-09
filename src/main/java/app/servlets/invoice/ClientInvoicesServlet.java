package app.servlets.invoice;

import app.database.handlers.produtcs.DBInvoiceHandler;
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

@WebServlet(urlPatterns = "/private/clientViews/clientInvoices")
public class ClientInvoicesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            ArrayList<Invoice> invoices = DBInvoiceHandler.selectAllById(clientId);
            req.setAttribute("invoices", invoices);
            RequestDispatcher requestDispatcher;
            if (!invoices.isEmpty()) {
                requestDispatcher = req.getRequestDispatcher("/private/clientViews/clientInvoices.jsp");
            } else {
                requestDispatcher = req.getRequestDispatcher("/private/clientViews/invoicesNotFound.jsp");
            }
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
