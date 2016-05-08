package com.redleefstudios.sushidictionary;

import java.util.ArrayList;

/**
 * Created by Fred on 4/14/2016.
 */
public class FoodObject {

    private String name;
    private String ethnicName;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private int image;

    public FoodObject(String name, String description, int image)
    {
        this.name = name;
        this.image = image;
        this.description = description;
        this.ingredients = new ArrayList<Ingredient>();
        this.ethnicName = "";
    }

    public String getName() {return name;}
    public String getEthnicName() {return ethnicName;}
    public String getDescription() {return description;}
    public ArrayList<Ingredient> getIngredients() {return ingredients;}
    public int getImage() {return image;}

    public void setEthnicName(String ethnicName) { this.ethnicName = ethnicName; }
    public void addIngredient(Ingredient toAdd) {this.ingredients.add(toAdd); }
}
