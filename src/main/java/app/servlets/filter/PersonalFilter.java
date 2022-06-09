package app.servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/private/personalViews/*")
public class PersonalFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        try {
            String loginURI = req.getContextPath() + "/private/authorization";
            boolean loggedIn = session != null && (session.getAttribute("isLogged") != null) &&
                    ((int) session.getAttribute("managerId") > 0 && session.getAttribute("managerId") != null);
            System.out.println();
            boolean loginRequest = req.getRequestURI().equals(loginURI);

            if (loggedIn || loginRequest) {
                chain.doFilter(request, response);
                System.out.println("Тут персоналу можно");
            } else {
                resp.sendRedirect("/index.jsp");
                System.out.println("А тут персоналу нельзя");
            }
        } catch (IOException | ServletException | NullPointerException e) {
            System.out.println("А тут клиенту не можно");
            session.invalidate();
            resp.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}
