package app.servlets.credit;

import app.database.handlers.produtcs.DBCreditHandler;
import app.model.bank.product.Credit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/clientViews/clientCredits")
public class ClientCreditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            ArrayList<Credit> credits = DBCreditHandler.selectAllById(clientId);
            req.setAttribute("credits", credits);
            RequestDispatcher requestDispatcher;
            if (!credits.isEmpty()) {
                requestDispatcher = req.getRequestDispatcher("/private/clientViews/clientCredits.jsp");
            } else {
                requestDispatcher = req.getRequestDispatcher("/private/clientViews/creditsNotFound.jsp");
            }
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
