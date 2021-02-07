package uz.doniyorbek7376.recipeapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

}
