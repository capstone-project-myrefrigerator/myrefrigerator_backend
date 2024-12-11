package com.capstone.myrefrigerator.service.ingredients;

import com.capstone.myrefrigerator.domain.Ingredients;
import org.springframework.data.domain.Page;

public interface IngredientsQueryService {

    Page<Ingredients> getMyIngredientsList(Integer page);
}
