package app.servlets.client;

import app.database.handlers.history.DBClientHistoryHandler;
import app.database.handlers.history.DBPersonalHistoryHandler;
import app.database.handlers.users.DBClientHandler;
import app.database.handlers.users.DBManagerHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/private/personalViews/deleteClient")
public class DeleteClientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession(false);
            int managerId = (int) session.getAttribute("managerId");
            int clientId = Integer.parseInt(req.getParameter("id"));
            DBClientHandler.delete(clientId);
            DBPersonalHistoryHandler.insert("Client Id=" + clientId + " deleted from DB", DBManagerHandler.selectOneById(managerId).getPersonalType(), managerId);
            DBClientHistoryHandler.deleteTable(clientId);
            resp.sendRedirect(req.getContextPath() + "/private/personalViews/viewAllClients");
        }
        catch(IOException e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(req, resp);
        }
    }
}
