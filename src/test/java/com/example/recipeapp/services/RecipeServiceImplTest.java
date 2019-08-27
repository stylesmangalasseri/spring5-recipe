package com.example.recipeapp.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.recipeapp.model.Recipe;
import com.example.recipeapp.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		
		recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void getRecipes() {
		
		Recipe recipe = new Recipe();
		
		HashSet<Recipe> hashSet = new HashSet<Recipe>();
		hashSet.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(hashSet);
		
		Set<Recipe> recipes = recipeServiceImpl.getRecipes();
		
		assertEquals(1, recipes.size());
		
		//Verify whether recipeRepository.findAll() is calling only once
		verify(recipeRepository, times(1)).findAll();
	}
}
