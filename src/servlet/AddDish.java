package servlet;


import data.*;
import util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AddDish extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if( request.getSession().getAttribute( "cin" ) == null ) {
            response.sendRedirect( "CaterLogin" );
            return;
        }

        int menuId = Integer.parseInt(request.getParameter("menuId"));
        Menu menu = MenuDirectory.getMenu(menuId);
        request.setAttribute("menu", menu);
        request.setAttribute("ingredients", IngredientDirectory.getListOfIngredients());
        request.getRequestDispatcher("AddDish.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int menuId = Integer.parseInt(request.getParameter("menuId"));
        Menu menu = MenuDirectory.getMenu(menuId);
        String name = request.getParameter("name");
        Connection c = null;
        try {
            String sql = "insert into dishes (name) values (?)";

            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, name);

            pstmt.executeUpdate();
            sql = "select max(id) as id from dishes";
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int dishId = 0;
            if (rs.next()) {
                dishId = rs.getInt("id");
            }

            for(Ingredient ing : IngredientDirectory.getListOfIngredients()){
                double quantity = Double.parseDouble(request.getParameter(ing.getName()));
                if(quantity > 0.0){
                    sql = "insert into dish_ingredients (dish_id, ingredient_id, quantity) values (?, ?, ?)";
                    pstmt = c.prepareStatement( sql );
                    pstmt.setInt( 1, dishId);
                    pstmt.setInt(2, ing.getId());
                    pstmt.setDouble(3, quantity);
                    pstmt.executeUpdate();
                }
            }

            sql = "insert into menu_dishes (menu_id, dish_id) values (?, ?)";
            pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, menuId);
            pstmt.setInt(2, dishId);
            pstmt.executeUpdate();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        //Redirect to different url (from the client), notice how this is different from request forward (server side)
        response.sendRedirect("ViewMenu?id="+menuId);
    }
}
