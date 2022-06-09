package app.servlets.card;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.produtcs.DBCardHandler;
import app.database.handlers.requests.DBCardRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.bank.operation.CardOperation;
import app.model.bank.request.CardRequest;
import app.model.users.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/openCardRequest")
public class OpenCardRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            Client client = DBClientHandler.selectOneById(clientId);
            CardRequest cardRequest = new CardOperation().sendOpenCardRequest(client);
            System.out.println(cardRequest.getRequestNumber());
            DBCardRequestHandler.insert(cardRequest);
            req.setAttribute("cardRequest", cardRequest);
            DBClientHistoryHandler.insert("Open card request, number = " + cardRequest.getRequestNumber(), clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientRequests");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
