package com.example.recipeapp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	private final RecipeRepository recipeRepository;
	
	
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		
		Set<Recipe> recipeSet = new HashSet<>();
		
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		
		return recipeSet;
	}

	public Recipe findById(Long id) {
		
		Optional<Recipe> recipes = recipeRepository.findById(id);
		
		if(!recipes.isPresent()) {
			
			throw new RuntimeException("No recipe found with the ID=" + id);
		}
		
		return recipes.get();
	}
}
