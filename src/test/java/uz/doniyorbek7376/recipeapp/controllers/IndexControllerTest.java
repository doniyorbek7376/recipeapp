package uz.doniyorbek7376.recipeapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import uz.doniyorbek7376.recipeapp.services.RecipeServiceImpl;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeServiceImpl recipeService;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {
        assertEquals("index", indexController.getIndexPage(model));
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute("recipes", recipeService.getRecipes());
    }
}
