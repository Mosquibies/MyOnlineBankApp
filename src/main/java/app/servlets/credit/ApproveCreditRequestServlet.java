package app.servlets.credit;

import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.produtcs.DBCreditHandler;
import app.database.handlers.requests.DBCreditRequestHandler;
import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;
import app.model.bank.operation.CreditOperation;
import app.model.bank.product.Credit;
import app.model.bank.request.ProductRequestStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/personalViews/approveCreditRequest")
public class ApproveCreditRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            String status = ProductRequestStatus.APPROVED.getTitle();
            CreditOperation creditOperation = new CreditOperation();
            int id = Integer.parseInt(req.getParameter("id"));
            int number = Integer.parseInt(req.getParameter("creditNumber"));
            DBCreditRequestHandler.updateStatus(status, id, number);
            Credit credit = creditOperation.openCredit(DBCreditRequestHandler.selectByNumberAndId(number, id));
            DBCreditHandler.insert(credit);
            DBClientHandler.updateCreditsCount(DBCreditHandler.selectAllById(id).size(), id);
            DBPersonalHistoryHandler.insert("Credit request number= " + number + " approved", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            DBPersonalHistoryHandler.insert("Credit number=" + credit.getNumber() + " opened", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllActiveRequests");
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
