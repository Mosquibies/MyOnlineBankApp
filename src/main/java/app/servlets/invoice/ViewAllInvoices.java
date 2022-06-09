package app.servlets.invoice;

import app.database.handlers.produtcs.DBInvoiceHandler;
import app.model.bank.product.Invoice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/personalViews/viewAllInvoices")
public class ViewAllInvoices extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ArrayList<Invoice> invoices = DBInvoiceHandler.select();
            req.setAttribute("invoices", invoices);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/viewAllInvoices.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
