package app.servlets.card;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.produtcs.DBCardHandler;
import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.bank.operation.CardOperation;
import app.model.bank.product.Card;
import app.model.bank.request.CardRequest;
import app.model.users.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/closeCardRequest")
public class CloseCardRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            int number = Integer.parseInt(req.getParameter("number"));
            Client client = DBClientHandler.selectOneById(clientId);
            Card card = DBCardHandler.selectOneByNumber(number);
            CardRequest cardRequest = new CardOperation().sendCloseCardRequest(client, card);
            DBCardRequestHandler.insert(cardRequest);
            req.setAttribute("cardRequest", cardRequest);
            DBClientHistoryHandler.insert("Close card request, number = " + cardRequest.getRequestNumber(), clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientRequests");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
