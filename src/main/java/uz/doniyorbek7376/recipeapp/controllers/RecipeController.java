package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import uz.doniyorbek7376.recipeapp.services.RecipeService;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/show/{id}")
    public String getRecipeById(@PathVariable("id") Long id, Model model) {
        log.debug("Getting recipe with id: " + id);
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/show";
    }

}
