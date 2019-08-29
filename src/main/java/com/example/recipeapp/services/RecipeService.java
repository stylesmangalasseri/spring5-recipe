package com.example.recipeapp.services;

import java.util.Set;

import com.example.recipeapp.model.Recipe;


public interface RecipeService {

	public Set<Recipe> getRecipes();
	
	public Recipe findById(Long id);
}
