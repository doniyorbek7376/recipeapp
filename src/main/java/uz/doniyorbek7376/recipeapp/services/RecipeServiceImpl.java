package uz.doniyorbek7376.recipeapp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uz.doniyorbek7376.recipeapp.domain.Recipe;
import uz.doniyorbek7376.recipeapp.repositories.RecipeRepository;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        log.debug("I'm in the service");
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> rOptional = recipeRepository.findById(id);
        if (!rOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }
        return rOptional.get();
    }

}
