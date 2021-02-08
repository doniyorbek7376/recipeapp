package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import uz.doniyorbek7376.recipeapp.services.IngredientService;
import uz.doniyorbek7376.recipeapp.services.RecipeService;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipe/{id}/ingredients")
    public String listIngredients(@PathVariable("id") Long id, Model model) {
        log.debug("Getting list of ingredients");
        model.addAttribute("recipe", recipeService.findCommandById(id));
        return "recipe/ingredient/list";
    }

    @GetMapping("/recipe/{recipeId}/ingredients/{id}/show")
    public String showIngredients(@PathVariable("recipeId") Long recipeId, @PathVariable("id") Long id, Model model) {
        log.debug("Getting ingredient by recipeId and ingredientId");
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(recipeId, id));
        return "recipe/ingredient/show";
    }

}
