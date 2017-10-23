package servlet;

import data.*;
//import data.UserDirectory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * EditUser servlet.
 */
public class EditUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // check if a user has logged in or not
        if( req.getSession().getAttribute( "cin" ) == null ) {
            resp.sendRedirect( "Login" );
            return;
        }

        User user = UserDirectory.getUser(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("user",user);
        req.getRequestDispatcher("/EditUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cin = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        char gender = request.getParameter("gender").charAt(0);
        //int cin = getNewCin(UserDirectory.getListOfUsers());

        User user = UserDirectory.getUser(cin);
        user.setName(name);
        user.setGender(gender);
        response.sendRedirect("ViewUser?id="+cin);
    }
}
