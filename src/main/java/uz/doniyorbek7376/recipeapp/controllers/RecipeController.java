package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import uz.doniyorbek7376.recipeapp.repositories.RecipeRepository;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/show/{id}")
    public String getRecipeById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("recipe", recipeRepository.findById(id).get());
        return "recipe/show";
    }
}
