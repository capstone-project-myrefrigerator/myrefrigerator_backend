package com.capstone.myrefrigerator.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RecipeIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_ingredients_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredients_data_id", nullable = false)
    private IngredientsData ingredientsData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    public void setRecipe(Recipe recipe){
        if(this.recipe != null)
            recipe.getRecipeIngredientsList().remove(this);
        this.recipe = recipe;
        recipe.getRecipeIngredientsList().add(this);
    }

    public void setIngredientsData(IngredientsData ingredientsData){
        if(this.ingredientsData != null)
            ingredientsData.getRecipeIngredientsList().remove(this);
        this.ingredientsData = ingredientsData;
        ingredientsData.getRecipeIngredientsList().add(this);
    }
}
