package com.capstone.myrefrigerator.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class RecipeResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipePreviewDTO{

        Long recipeId;
        String name;
        String contents;
        Double protein;
        Double calorie;
        Double fat;
        Double carbohydrate;
        String category;
        List<RecipeImgResponseDTO> recipImgResponseDTOList;
        List<String> ingredientsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipePreviewListDTO{
        List<RecipePreviewDTO> recipePreviewDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeImgResponseDTO {
        String recipeImgUrl;
        Boolean isThumbnail;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeDetailResponseDTO{

        Long recipeId;
        String name;
        String contents;
        Double protein;
        Double calorie;
        Double fat;
        Double carbohydrate;
        String category;
        List<RecipeImgResponseDTO> recipImgResponseDTOList;
        List<String> ingredientsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IngredientsPreviewDTO{

        Long ingredientsId;
        String name;
        String url;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IngredientsPreviewListDTO{
        List<IngredientsPreviewDTO> ingredientsPreviewDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class IngredientsDeleteResultDTO{
        Long ingredientsId;
        String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeContainingIngredientsResultDTO{
        Long recipeId;
        String name;
        String contents;
        Double protein;
        Double calorie;
        Double fat;
        Double carbohydrate;
        String category;
        List<RecipeImgResponseDTO> recipImgResponseDTOList;
        List<String> ingredientsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeContainingIngredientsResultListDTO{
        List<RecipeContainingIngredientsResultDTO> recipeContainingIngredientsResultDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeSearchPreviewDTO{

        Long recipeId;
        String name;
        String contents;
        Double protein;
        Double calorie;
        Double fat;
        Double carbohydrate;
        String category;
        List<RecipeImgResponseDTO> recipImgResponseDTOList;
        List<String> ingredientsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeSearchPreviewListDTO{
        List<RecipeSearchPreviewDTO> recipeSearchPreviewDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeFilteringPreviewDTO{
        Long recipeId;
        String name;
        String contents;
        Double protein;
        Double calorie;
        Double fat;
        Double carbohydrate;
        String category;
        List<RecipeImgResponseDTO> recipImgResponseDTOList;
        List<String> ingredientsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeFilteringPreviewListDTO{
        List<RecipeFilteringPreviewDTO> recipeFilteringPreviewDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeCategoryFilteringPreviewDTO{
        Long recipeId;
        String name;
        String contents;
        Double protein;
        Double calorie;
        Double fat;
        Double carbohydrate;
        String category;
        List<RecipeImgResponseDTO> recipImgResponseDTOList;
        List<String> ingredientsList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeCategoryFilteringPreviewListDTO{
        List<RecipeCategoryFilteringPreviewDTO> recipeCategoryFilteringPreviewDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
