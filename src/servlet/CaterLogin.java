package servlet;

import data.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CaterLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = request.getParameter("message");
        if(message!=null){
            request.setAttribute("message", message);
        }
        request.getRequestDispatcher("CaterLogin.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = UserDirectory.getListOfUsers();
        boolean foundUser = false;
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                foundUser=true;
                //store userid and username in session for future lookup
                request.getSession().setAttribute("cin", user.getCIN());
                request.getSession().setAttribute("username", user.getUsername());
                request.getSession().setAttribute("isAdmin", user.isAdmin());
                response.sendRedirect("Catering");
                return;
            }
        }
        if(!foundUser){
            //User not found
            System.out.println("user not found");
            response.sendRedirect("CaterLogin?message=username%20and%20password%20combination%20not%20found");
        }
    }

}