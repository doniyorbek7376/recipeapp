package uz.doniyorbek7376.recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import uz.doniyorbek7376.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
