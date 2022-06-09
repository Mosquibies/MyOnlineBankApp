package app.servlets.card;

import app.database.handlers.produtcs.DBCardHandler;
import app.model.bank.product.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/personalViews/viewAllCards")
public class ViewAllCards extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Card> cards = DBCardHandler.select();
            req.setAttribute("cards", cards);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/personalViews/viewAllCards.jsp");
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
