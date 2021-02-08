package uz.doniyorbek7376.recipeapp.controllers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import uz.doniyorbek7376.recipeapp.commands.IngredientCommand;
import uz.doniyorbek7376.recipeapp.commands.RecipeCommand;
import uz.doniyorbek7376.recipeapp.services.IngredientService;
import uz.doniyorbek7376.recipeapp.services.RecipeService;

public class IngredientControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientService ingredientService;

    IngredientController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new IngredientController(recipeService, ingredientService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testListIngredients() throws Exception {
        // given
        RecipeCommand recipeCommand = new RecipeCommand();

        // when
        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);

        // then
        mockMvc.perform(get("/recipe/1/ingredients")).andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list")).andExpect(model().attributeExists("recipe"));
        verify(recipeService, times(1)).findCommandById(anyLong());
    }

    @Test
    public void showIngredientTest() throws Exception {
        // given
        IngredientCommand command = new IngredientCommand();

        // when
        when(ingredientService.findByRecipeIdAndId(anyLong(), anyLong())).thenReturn(command);

        // then
        mockMvc.perform(get("/recipe/1/ingredient/1/show")).andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/show")).andExpect(model().attributeExists("ingredient"));
        verify(ingredientService, times(1)).findByRecipeIdAndId(anyLong(), anyLong());
    }
}
