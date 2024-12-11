package com.capstone.myrefrigerator.service.ingredients;

import com.capstone.myrefrigerator.domain.Ingredients;

public interface IngredientsCommandService {

    Ingredients deleteIngredients(Long ingredientsId);
}
