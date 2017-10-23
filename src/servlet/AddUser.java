package servlet;

import data.*;
//import data.UserDirectory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * AddUser servlet.
 */
public class AddUser extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // check if a user has logged in or not
        if( req.getSession().getAttribute( "cin" ) == null ) {
            resp.sendRedirect( "Login" );
            return;
        }
        req.getRequestDispatcher("/AddUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        char gender = request.getParameter("gender").charAt(0);
        int cin = getNewCin(UserDirectory.getListOfUsers());

        for(User user : UserDirectory.getListOfUsers()) {
            if(user.getUsername().equals(username)){
                request.setAttribute("name", name);
                request.setAttribute("gender",gender);
                request.setAttribute("message","username already exists!");
                request.getRequestDispatcher("/AddUser.jsp").forward(request, response);
                return;
            }
        }

        User newUser = new User(username, password, name, cin, gender);
        UserDirectory.addUser(newUser);

        response.sendRedirect("ViewUser?id="+cin);
    }

    public int getNewCin(List<User> existingUsers){

        int newId = existingUsers.size();
        HashSet<Integer> existingIds = new HashSet<>();
        for(User user : existingUsers){
            existingIds.add(user.getCIN());
        }
        while(existingIds.contains(newId)){
            newId++;
        }
        return newId;
    }
}
