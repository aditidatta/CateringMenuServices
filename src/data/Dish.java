package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dish {
    int id;
    String name;
    HashMap<Ingredient, Double> ingredients;
    double price;

    public Dish(int id, String name, HashMap<Ingredient, Double> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = 0;
    }

    public Dish(int id, String name) {
        this.id = id;
        this.name = name;
        this.ingredients = new HashMap<>();
        this.price = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Ingredient, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, Double> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void calculatePrice(){
        for (Map.Entry<Ingredient, Double> entry : ingredients.entrySet()){
            price += entry.getKey().getPrice() * entry.getValue();
        }
    }

    public void addIngredient(Ingredient ingredient, double quantity){
        ingredients.put(ingredient, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        return (id == dish.id);
    }

}
