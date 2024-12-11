package com.capstone.myrefrigerator.service.recipe;

import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.domain.Recipe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecipeQueryService {

    Page<Recipe> getRecipeList(Integer page);

    Recipe getRecipeDetail(Long recipeId);

    Page<Recipe> getContainingIngredientsRecipe(List<String> ingredientsList, Integer page);

    Page<Recipe> searchRecipe(String name, Integer page);

    Page<Recipe> filteringRecipe(String orderType, Integer page);

    Page<Recipe> emotionRecommendRecipe(String emotion, Integer page);
}
