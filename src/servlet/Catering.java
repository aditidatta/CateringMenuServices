package servlet;

import data.*;
import util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Catering extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
        User user1 = new User("sophie","12345","Sophia Jones", 12345,'F');
        User user2 = new User("aaron","12345","Aaron White", 22345, 'M');
        User user3 = new User("carl","12345","Carlos Davis", 32345, 'M');
        User user4 = new User("emma","12345","Emma Wattson", 42345, 'F');
        User user5 = new User("david","12345","David Jackson", 52345, 'M', true);

        UserDirectory.addUser(user1);
        UserDirectory.addUser(user2);
        UserDirectory.addUser(user3);
        UserDirectory.addUser(user4);
        UserDirectory.addUser(user5);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // check if a user has logged in or not
        if( req.getSession().getAttribute( "cin" ) == null ) {
            resp.sendRedirect( "CaterLogin" );
            return;
        }

        //System.out.println(req.getSession().getAttribute( "cin" ));

        User user = UserDirectory.getUser((Integer)req.getSession().getAttribute( "cin" ));
        //System.out.println(event.getName());
        Connection c = null;
        try {

            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menus");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                if(MenuDirectory.getMenu(id) == null) {
                    MenuDirectory.addMenu(new Menu(id, name));
                }
            }

            rs = stmt.executeQuery("select * from ingredients");
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                if(IngredientDirectory.getIngredient(id) == null) {
                    IngredientDirectory.addIngredient(new Ingredient(id, name, price));
                }
            }

        } catch (SQLException e) {
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

        req.setAttribute("user", user);
        req.setAttribute("menus", MenuDirectory.getListOfMenus());
        req.getRequestDispatcher("/Catering.jsp").forward(req, resp);
    }
}
