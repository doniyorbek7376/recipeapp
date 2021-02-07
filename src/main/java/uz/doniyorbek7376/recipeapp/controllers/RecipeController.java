package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import uz.doniyorbek7376.recipeapp.repositories.RecipeRepository;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/show/{id}")
    public String getRecipeById(@PathVariable("id") Long id, Model model) {
        log.debug("Getting recipe with id: " + id);
        model.addAttribute("recipe", recipeRepository.findById(id).get());
        return "recipe/show";
    }
}
