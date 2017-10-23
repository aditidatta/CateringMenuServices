package servlet;

import data.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ViewUser class
 */
public class ViewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // check if a user has logged in or not
        if( req.getSession().getAttribute( "cin" ) == null ) {
            resp.sendRedirect( "Login" );
            return;
        }

        User user = UserDirectory.getUser(Integer.parseInt(req.getParameter("id")));
        //System.out.println(event.getName());
        req.setAttribute("user", user);
        req.getRequestDispatcher("/ViewUser.jsp").forward(req, resp);
    }
}
