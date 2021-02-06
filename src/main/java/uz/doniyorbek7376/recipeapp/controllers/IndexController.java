package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uz.doniyorbek7376.recipeapp.services.RecipeService;

@Controller
public class IndexController {

    private RecipeService recipeService;

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

}
