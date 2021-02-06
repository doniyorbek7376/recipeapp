package uz.doniyorbek7376.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import uz.doniyorbek7376.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
