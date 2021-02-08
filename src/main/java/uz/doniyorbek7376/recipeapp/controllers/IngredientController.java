package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import uz.doniyorbek7376.recipeapp.commands.IngredientCommand;
import uz.doniyorbek7376.recipeapp.commands.RecipeCommand;
import uz.doniyorbek7376.recipeapp.commands.UnitOfMeasureCommand;
import uz.doniyorbek7376.recipeapp.services.IngredientService;
import uz.doniyorbek7376.recipeapp.services.RecipeService;
import uz.doniyorbek7376.recipeapp.services.UnitOfMeasureService;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService uomService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService,
            UnitOfMeasureService uomService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.uomService = uomService;
    }

    @GetMapping("/recipe/{id}/ingredients")
    public String listIngredients(@PathVariable("id") Long id, Model model) {
        log.debug("Getting list of ingredients");
        model.addAttribute("recipe", recipeService.findCommandById(id));
        return "recipe/ingredient/list";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/show")
    public String showIngredients(@PathVariable("recipeId") Long recipeId, @PathVariable("id") Long id, Model model) {
        log.debug("Getting ingredient by recipeId and ingredientId");
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(recipeId, id));
        return "recipe/ingredient/show";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/update")
    public String updateIngredient(@PathVariable("recipeId") Long recipeId, @PathVariable("id") Long id, Model model) {
        model.addAttribute("uomList", uomService.listAllUoms());
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(recipeId, id));
        return "recipe/ingredient/ingredientform";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/new")
    public String createIngredient(@PathVariable("recipeId") Long recipeId, Model model) {
        model.addAttribute("uomList", uomService.listAllUoms());
        RecipeCommand recipeCommand = recipeService.findCommandById(recipeId);
        if (recipeCommand == null)
            throw new RuntimeException("Recipe not found");
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(recipeId);
        ingredientCommand.setUom(new UnitOfMeasureCommand());
        model.addAttribute("ingredient", ingredientCommand);
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("/recipe/{recipeId}/ingredient")
    public String saveIngredient(@PathVariable("recipeId") Long recipeId, @ModelAttribute IngredientCommand command) {
        ingredientService.saveIngredientCommand(command);
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteIngredient(@PathVariable("recipeId") Long recipeId, @PathVariable("id") Long id) {
        ingredientService.deleteIngredientByRecipeIdAndId(recipeId, id);
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
