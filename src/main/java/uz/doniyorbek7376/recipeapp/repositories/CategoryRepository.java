package uz.doniyorbek7376.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import uz.doniyorbek7376.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
