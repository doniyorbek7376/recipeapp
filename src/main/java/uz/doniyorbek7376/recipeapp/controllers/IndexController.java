package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import uz.doniyorbek7376.recipeapp.services.RecipeService;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        log.debug("Getting index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

}
