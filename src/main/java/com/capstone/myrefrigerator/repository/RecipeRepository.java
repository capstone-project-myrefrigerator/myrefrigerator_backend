package com.capstone.myrefrigerator.repository;

import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.domain.IngredientsData;
import com.capstone.myrefrigerator.domain.Recipe;
import com.capstone.myrefrigerator.domain.RecipeIngredients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByIngredientsDataListIn(List<IngredientsData> ingredientsDataList);

    List<Recipe> findAllByRecipeIngredientsListIngredientsDataIn(List<IngredientsData> ingredientsDataList);

    Page<Recipe> findAllByNameContaining(String name, PageRequest pageRequest);

    Page<Recipe> findAllByCategory(String category, PageRequest pageRequest);
}
