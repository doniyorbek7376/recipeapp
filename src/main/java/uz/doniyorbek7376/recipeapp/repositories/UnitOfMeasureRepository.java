package uz.doniyorbek7376.recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import uz.doniyorbek7376.recipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
