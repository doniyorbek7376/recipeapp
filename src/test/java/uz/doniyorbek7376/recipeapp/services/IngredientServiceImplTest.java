package uz.doniyorbek7376.recipeapp.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import uz.doniyorbek7376.recipeapp.commands.IngredientCommand;
import uz.doniyorbek7376.recipeapp.converters.IngredientToIngredientCommand;
import uz.doniyorbek7376.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import uz.doniyorbek7376.recipeapp.domain.Ingredient;
import uz.doniyorbek7376.recipeapp.domain.Recipe;
import uz.doniyorbek7376.recipeapp.repositories.RecipeRepository;

public class IngredientServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        UnitOfMeasureToUnitOfMeasureCommand uomConverter = new UnitOfMeasureToUnitOfMeasureCommand();
        IngredientToIngredientCommand ingredientConverter = new IngredientToIngredientCommand(uomConverter);
        ingredientService = new IngredientServiceImpl(recipeRepository, ingredientConverter);
    }

    @Test
    public void findByRecipeIdAndIdTest() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        Ingredient ingredient2 = new Ingredient();
        ingredient1.setId(2L);
        Ingredient ingredient3 = new Ingredient();
        ingredient1.setId(3L);
        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);

        // when
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        // then
        IngredientCommand result = ingredientService.findByRecipeIdAndId(1L, 3L);
        assertEquals(3L, result.getId());
        assertEquals(1L, result.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }
}
