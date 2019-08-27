package com.example.recipeapp.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.recipeapp.model.UnitOfMeasure;

/**
 * Integration test class for {@link UnitOfMeasureRepository}
 * 
 * @author Styles.Mangalasseri
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
	public void setup() {

	}

	@Test
	public void findByDescription() {
		UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon").get();
		assertEquals("Teaspoon", unitOfMeasure.getDescription());
	}
}
