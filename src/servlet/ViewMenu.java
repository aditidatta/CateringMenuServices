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

public class ViewMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // check if a user has logged in or not
        if( req.getSession().getAttribute( "cin" ) == null ) {
            resp.sendRedirect( "CaterLogin" );
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        Menu menu = MenuDirectory.getMenu(id);

        Connection c = null;
        try {
            String sql = "select d.id, d.name, dish_ingredients.ingredient_id, dish_ingredients.quantity " +
                    "from (select dishes.id, dishes.name " +
                    "from dishes right join (select menu_dishes.dish_id from menu_dishes where menu_dishes.menu_id=" + id + ") md " +
                    "on md.dish_id=dishes.id) d " +
                    "left join dish_ingredients on d.id=dish_ingredients.dish_id order by d.id";
            System.out.println(sql);
            c = ConnectionUtils.getMySQLConnection(DatabaseConfig.MYSQL_USERNAME, DatabaseConfig.MYSQL_PASSWORD,
                    DatabaseConfig.MYSQL_HOST, DatabaseConfig.MYSQL_PORT, DatabaseConfig.MYSQL_DATABASE_TO_USE);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Dish> dishes = new ArrayList<>();
            int prevId = -1;
            while (rs.next()) {
                Dish dish;
                int dishId = rs.getInt("id");
                String name = rs.getString("name");
                Object ingId = rs.getObject("ingredient_id");
                if(prevId == dishId) {
                    dish = dishes.get(dishes.size()-1);

                }
                else {
                    dish = new Dish(dishId, name);
                    dishes.add(dish);
                }


                    int ingredientId = (Integer) ingId;
                    Ingredient ing = IngredientDirectory.getIngredient(ingredientId);
                    double quantity = rs.getDouble("quantity");
                    dish.addIngredient(ing, quantity);
                    req.setAttribute("foundIng", 1);

                prevId = dishId;
            }
            for(Dish dish : dishes){
                dish.calculatePrice();
            }
            menu.setDishes(dishes);

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
        req.setAttribute("menus", MenuDirectory.getListOfMenus());
        req.setAttribute("menu", menu);
        req.setAttribute("dishes", menu.getDishes());
        req.getRequestDispatcher("/ViewMenu.jsp").forward(req, resp);
    }
}
