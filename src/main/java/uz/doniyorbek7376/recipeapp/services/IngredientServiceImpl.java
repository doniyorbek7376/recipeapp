package uz.doniyorbek7376.recipeapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.doniyorbek7376.recipeapp.commands.IngredientCommand;
import uz.doniyorbek7376.recipeapp.converters.IngredientToIngredientCommand;
import uz.doniyorbek7376.recipeapp.domain.Ingredient;
import uz.doniyorbek7376.recipeapp.domain.Recipe;
import uz.doniyorbek7376.recipeapp.repositories.RecipeRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand converter;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand converter) {
        this.recipeRepository = recipeRepository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public IngredientCommand findByRecipeIdAndId(Long recipeId, Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe not found!");
        }
        Recipe recipe = recipeOptional.get();

        Ingredient ingredient = recipe.getIngredients().stream().filter(i -> i.getId() == id).findAny().get();
        return converter.convert(ingredient);
    }

}
