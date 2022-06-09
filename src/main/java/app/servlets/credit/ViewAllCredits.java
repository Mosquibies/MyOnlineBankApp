package app.servlets.credit;

import app.database.handlers.produtcs.DBCreditHandler;
import app.model.bank.product.Credit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/personalViews/viewAllCredits")
public class ViewAllCredits extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            ArrayList<Credit> credits = DBCreditHandler.select();
            req.setAttribute("credits", credits);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/viewAllCredits.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
