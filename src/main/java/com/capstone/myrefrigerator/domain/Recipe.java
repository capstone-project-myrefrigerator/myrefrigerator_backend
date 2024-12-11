package com.capstone.myrefrigerator.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String contents;

    private Double protein;

    private Double calorie;

    private Double fat;

    private Double carbohydrate;

    private String category;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeImg> recipeImgList = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<IngredientsData> ingredientsDataList = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredients> recipeIngredientsList = new ArrayList<>();
}
