package uz.doniyorbek7376.recipeapp.services;

import uz.doniyorbek7376.recipeapp.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteIngredientByRecipeIdAndId(Long recipeId, Long id);
}
