package uz.doniyorbek7376.recipeapp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import uz.doniyorbek7376.recipeapp.domain.Category;
import uz.doniyorbek7376.recipeapp.domain.UnitOfMeasure;
import uz.doniyorbek7376.recipeapp.repositories.CategoryRepository;
import uz.doniyorbek7376.recipeapp.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage() {
        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Pinch");
        System.out.println("Category id: " + category.get().getId());
        System.out.println("UOM id: " + uom.get().getId());
        return "index";
    }

    public IndexController(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }
}
