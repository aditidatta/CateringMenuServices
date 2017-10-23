package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IngredientDirectory {
    private static List<Ingredient> ingredients = new ArrayList<>();

    public static List<Ingredient> getListOfIngredients(){
        return ingredients;
    }

    public static Ingredient getIngredient(int id){
        for (Ingredient e : ingredients) {
            if (e.getId() == id)
                return e;

        }
        return null;
    }

    public static void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public static void removeIngredient(Ingredient ingredient){
        Iterator<Ingredient> iterator = ingredients.iterator();
        while(iterator.hasNext()) {
            Ingredient ing = iterator.next();
            if (ing.equals(ingredient)){
                iterator.remove();
                break;
            }
        }
    }

    public static void removeIngredient(int id){
        Iterator<Ingredient> iterator = ingredients.iterator();
        while(iterator.hasNext()){
            Ingredient ing = iterator.next();
            if(ing.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
