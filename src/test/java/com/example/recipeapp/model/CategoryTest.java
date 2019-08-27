package com.example.recipeapp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;
	
	@Before
	public void setup() {
		
		category = new Category();
	}
	
	@Test
	public void getId() {
		
		Long id = 45l;
		
		category.setId(id);
		
		assertEquals(id, category.getId());
	}
}
