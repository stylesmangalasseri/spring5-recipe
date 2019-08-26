package com.example.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.recipeapp.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
