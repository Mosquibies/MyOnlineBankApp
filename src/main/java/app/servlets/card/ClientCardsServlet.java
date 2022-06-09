package app.servlets.card;

import app.database.handlers.produtcs.DBCardHandler;
import app.model.bank.product.Card;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/private/clientViews/clientCards")
public class ClientCardsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            ArrayList<Card> cards = DBCardHandler.selectAllById(clientId);
            req.setAttribute("cards", cards);
            RequestDispatcher requestDispatcher;
            if (!cards.isEmpty()){
                requestDispatcher = req.getRequestDispatcher("/private/clientViews/clientCards.jsp");
            } else {
                requestDispatcher = req.getRequestDispatcher("/private/clientViews/cardsNotFound.jsp");
            }
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
           e.printStackTrace();
        }
    }
}
