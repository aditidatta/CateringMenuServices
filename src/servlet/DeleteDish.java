package servlet;

import data.*;
import util.ConnectionUtils;
import util.DatabaseConfig;
//import data.UserDirectory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDish extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // check if a user has logged in or not
        if( request.getSession().getAttribute( "cin" ) == null ) {
            response.sendRedirect( "CaterLogin" );
            return;
        }

        int dishId = Integer.parseInt(request.getParameter("dishId"));
        int menuId = Integer.parseInt(request.getParameter("menuId"));
        String sql = "delete from dishes where dishes.id="+dishId;
        Connection c = null;
        try {

            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            Statement stmt = c.createStatement();
            stmt.execute(sql);
        }catch (SQLException e) {
            // Escalate to Server error
            throw new ServletException(e);
        }
        // Always close connections, no matter what happened
        finally {
            try {
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        response.sendRedirect("ViewMenu?id="+menuId);

    }
}
