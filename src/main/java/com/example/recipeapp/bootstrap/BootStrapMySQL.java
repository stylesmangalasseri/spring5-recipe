package com.example.recipeapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.recipeapp.model.Category;
import com.example.recipeapp.model.UnitOfMeasure;
import com.example.recipeapp.repositories.CategoryRepository;
import com.example.recipeapp.repositories.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootStrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    
    
    public BootStrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        
        if (categoryRepository.count() == 0L) {
            log.debug("Loading categories");
            loadCategories();
        }
        
        if (unitOfMeasureRepository.count() == 0L) {
            log.debug("Loading UOMs");
            loadUoms();
        }
    }

    private void loadUoms() {
        
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Teaspoon");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Tablespoon");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Cup");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Pinch");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Ounce");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Each");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Dash");
        unitOfMeasureRepository.save(unitOfMeasure);
        
        unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Pint");
        unitOfMeasureRepository.save(unitOfMeasure);
    }
    private void loadCategories() {
        
        Category category = new Category();
        category.setDescription("American");
        categoryRepository.save(category);
        
        category = new Category();
        category.setDescription("Italian");
        categoryRepository.save(category);
        
        category = new Category();
        category.setDescription("Mexican");
        categoryRepository.save(category);
        
        category = new Category();
        category.setDescription("Fast Food");
        categoryRepository.save(category);
    }

}
