package uz.doniyorbek7376.recipeapp.services;

import java.util.Set;

import uz.doniyorbek7376.recipeapp.domain.Recipe;

public interface RecipeService {
    Set<Recipe> getRecipes();

}