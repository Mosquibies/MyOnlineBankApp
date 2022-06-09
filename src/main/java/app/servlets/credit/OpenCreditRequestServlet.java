package app.servlets.credit;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.requests.DBCreditRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.model.bank.operation.CreditOperation;
import app.model.bank.request.CreditRequest;
import app.model.users.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/clientViews/openCreditRequest")
public class OpenCreditRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/bankProductsViews/openCreditPage.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        try{
            HttpSession session = req.getSession(false);
            int clientId = (int) session.getAttribute("clientId");
            float sum = Float.parseFloat(req.getParameter("sum"));
            int time = Integer.parseInt(req.getParameter("time"));
            Client client = DBClientHandler.selectOneById(clientId);
            CreditRequest creditRequest = new CreditOperation().sendOpenCreditRequest(client, sum, time);
            DBCreditRequestHandler.insert(creditRequest);
            DBClientHistoryHandler.insert("Open credit request, number=" + creditRequest.getRequestNumber(), clientId);
            resp.sendRedirect(req.getContextPath() + "/private/clientViews/clientRequests");
        }
        catch(IOException | NumberFormatException e) {
            e.printStackTrace();
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/private/bankProductsViews/openCreditPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
