package com.capstone.myrefrigerator.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class IngredientsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredients_data_id")
    private Long id;

    private String name;

    private String url;

    @JoinColumn(name = "recipe_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    @OneToMany(mappedBy = "ingredientsData", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RecipeIngredients> recipeIngredientsList = new ArrayList<>();
}
