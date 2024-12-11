package com.capstone.myrefrigerator.repository;

import com.capstone.myrefrigerator.domain.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Long> {
}
