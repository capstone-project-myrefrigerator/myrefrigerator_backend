package com.capstone.myrefrigerator.converter;

import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.domain.Recipe;
import com.capstone.myrefrigerator.domain.RecipeImg;
import com.capstone.myrefrigerator.web.dto.RecipeResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeConverter {

    public static RecipeResponseDTO.RecipeImgResponseDTO toRecipeImgDTO(RecipeImg recipeImg){
        return RecipeResponseDTO.RecipeImgResponseDTO.builder()
                .isThumbnail(recipeImg.getThumbnail())
                .recipeImgUrl(recipeImg.getUrl())
                .build();
    }

    public static RecipeResponseDTO.IngredientsPreviewDTO ingredientsPreviewDTO(Ingredients ingredients){
        return RecipeResponseDTO.IngredientsPreviewDTO.builder()
                .ingredientsId(ingredients.getId())
                .name(ingredients.getName())
                .url(ingredients.getUrl())
                .build();
    }

    public static RecipeResponseDTO.IngredientsPreviewListDTO ingredientsPreviewListDTO(Page<Ingredients> ingredientsList){
        List<RecipeResponseDTO.IngredientsPreviewDTO> ingredientsPreviewDTOList = ingredientsList.stream()
                .map(RecipeConverter::ingredientsPreviewDTO).collect(Collectors.toList());

        return RecipeResponseDTO.IngredientsPreviewListDTO.builder()
                .ingredientsPreviewDTOList(ingredientsPreviewDTOList)
                .isFirst(ingredientsList.isFirst())
                .isLast(ingredientsList.isLast())
                .listSize(ingredientsList.getSize())
                .totalElements(ingredientsList.getTotalElements())
                .totalPage(ingredientsList.getTotalPages())
                .build();
    }

    //레시피 전체 조회 api 부터 다시 개발 후 개별 디테일 레시피 조회 api 개발
    public static RecipeResponseDTO.RecipePreviewDTO recipePreviewDTO(Recipe recipe){
        List<RecipeResponseDTO.RecipeImgResponseDTO> recipeImgResponseDTOList = recipe.getRecipeImgList().stream()
                .map(RecipeConverter::toRecipeImgDTO)
                .filter(RecipeResponseDTO.RecipeImgResponseDTO::getIsThumbnail).collect(Collectors.toList());

        return RecipeResponseDTO.RecipePreviewDTO.builder()
                .recipeId(recipe.getId())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .contents(recipe.getContents())
                .calorie(recipe.getCalorie())
                .carbohydrate(recipe.getCarbohydrate())
                .protein(recipe.getProtein())
                .fat(recipe.getFat())
                .recipImgResponseDTOList(recipeImgResponseDTOList)
                .ingredientsList(recipe.getRecipeIngredientsList().stream().map(ingredients -> ingredients.getIngredientsData().getName()).collect(Collectors.toList()))
                .build();
    }

    public static RecipeResponseDTO.RecipePreviewListDTO recipePreviewListDTO(Page<Recipe> recipeList){
        List<RecipeResponseDTO.RecipePreviewDTO> recipePreviewDTOList = recipeList.stream()
                .map(RecipeConverter::recipePreviewDTO).collect(Collectors.toList());

        return RecipeResponseDTO.RecipePreviewListDTO.builder()
                .recipePreviewDTOList(recipePreviewDTOList)
                .isFirst(recipeList.isFirst())
                .isLast(recipeList.isLast())
                .listSize(recipeList.getSize())
                .totalElements(recipeList.getTotalElements())
                .totalPage(recipeList.getTotalPages())
                .build();
    }

    public static RecipeResponseDTO.RecipeContainingIngredientsResultDTO recipeContainingIngredientsResultDTO(Recipe recipe){
        List<RecipeResponseDTO.RecipeImgResponseDTO> recipeImgResponseDTOList = recipe.getRecipeImgList().stream()
                .map(RecipeConverter::toRecipeImgDTO)
                .filter(RecipeResponseDTO.RecipeImgResponseDTO::getIsThumbnail).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeContainingIngredientsResultDTO.builder()
                .recipeId(recipe.getId())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .contents(recipe.getContents())
                .calorie(recipe.getCalorie())
                .carbohydrate(recipe.getCarbohydrate())
                .protein(recipe.getProtein())
                .fat(recipe.getFat())
                .recipImgResponseDTOList(recipeImgResponseDTOList)
                .ingredientsList(recipe.getRecipeIngredientsList().stream().map(ingredients -> ingredients.getIngredientsData().getName()).collect(Collectors.toList()))
                .build();
    }

    public static RecipeResponseDTO.RecipeContainingIngredientsResultListDTO recipeContainingIngredientsResultListDTO(Page<Recipe> recipeList){
        List<RecipeResponseDTO.RecipeContainingIngredientsResultDTO> recipeContainingIngredientsResultDTOList = recipeList.stream()
                .map(RecipeConverter::recipeContainingIngredientsResultDTO).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeContainingIngredientsResultListDTO.builder()
                .recipeContainingIngredientsResultDTOList(recipeContainingIngredientsResultDTOList)
                .isFirst(recipeList.isFirst())
                .isLast(recipeList.isLast())
                .listSize(recipeList.getSize())
                .totalElements(recipeList.getTotalElements())
                .totalPage(recipeList.getTotalPages())
                .build();
    }

    public static RecipeResponseDTO.RecipeSearchPreviewDTO recipeSearchPreviewDTO(Recipe recipe){
        List<RecipeResponseDTO.RecipeImgResponseDTO> recipeImgResponseDTOList = recipe.getRecipeImgList().stream()
                .map(RecipeConverter::toRecipeImgDTO)
                .filter(RecipeResponseDTO.RecipeImgResponseDTO::getIsThumbnail).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeSearchPreviewDTO.builder()
                .recipeId(recipe.getId())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .contents(recipe.getContents())
                .calorie(recipe.getCalorie())
                .carbohydrate(recipe.getCarbohydrate())
                .protein(recipe.getProtein())
                .fat(recipe.getFat())
                .recipImgResponseDTOList(recipeImgResponseDTOList)
                .ingredientsList(recipe.getRecipeIngredientsList().stream().map(ingredients -> ingredients.getIngredientsData().getName()).collect(Collectors.toList()))
                .build();
    }

    public static RecipeResponseDTO.RecipeSearchPreviewListDTO recipeSearchPreviewListDTO(Page<Recipe> recipeList){
        List<RecipeResponseDTO.RecipeSearchPreviewDTO> recipeSearchPreviewDTOList = recipeList.stream()
                .map(RecipeConverter::recipeSearchPreviewDTO).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeSearchPreviewListDTO.builder()
                .recipeSearchPreviewDTOList(recipeSearchPreviewDTOList)
                .isFirst(recipeList.isFirst())
                .isLast(recipeList.isLast())
                .listSize(recipeList.getSize())
                .totalElements(recipeList.getTotalElements())
                .totalPage(recipeList.getTotalPages())
                .build();
    }

    public static RecipeResponseDTO.RecipeDetailResponseDTO recipeDetailResponseDTO(Recipe recipe){
        List<RecipeResponseDTO.RecipeImgResponseDTO> recipeImgResponseDTOList = recipe.getRecipeImgList().stream()
                .map(RecipeConverter::toRecipeImgDTO).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeDetailResponseDTO.builder()
                .recipeId(recipe.getId())
                .name(recipe.getName())
                .contents(recipe.getContents())
                .category(recipe.getCategory())
                .calorie(recipe.getCalorie())
                .carbohydrate(recipe.getCarbohydrate())
                .fat(recipe.getFat())
                .protein(recipe.getProtein())
                .ingredientsList(recipe.getRecipeIngredientsList().stream().map(ingredients -> ingredients.getIngredientsData().getName()).collect(Collectors.toList()))
                .recipImgResponseDTOList(recipeImgResponseDTOList)
                .build();
    }

    public static RecipeResponseDTO.IngredientsDeleteResultDTO ingredientsDeleteResultDTO(Ingredients ingredients){
        return RecipeResponseDTO.IngredientsDeleteResultDTO.builder()
                .ingredientsId(ingredients.getId())
                .name(ingredients.getName())
                .build();
    }

    public static RecipeResponseDTO.RecipeFilteringPreviewDTO recipeFilteringPreviewDTO(Recipe recipe){
        List<RecipeResponseDTO.RecipeImgResponseDTO> recipeImgResponseDTOList = recipe.getRecipeImgList().stream()
                .map(RecipeConverter::toRecipeImgDTO)
                .filter(RecipeResponseDTO.RecipeImgResponseDTO::getIsThumbnail).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeFilteringPreviewDTO.builder()
                .recipeId(recipe.getId())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .contents(recipe.getContents())
                .calorie(recipe.getCalorie())
                .carbohydrate(recipe.getCarbohydrate())
                .protein(recipe.getProtein())
                .fat(recipe.getFat())
                .recipImgResponseDTOList(recipeImgResponseDTOList)
                .ingredientsList(recipe.getRecipeIngredientsList().stream().map(ingredients -> ingredients.getIngredientsData().getName()).collect(Collectors.toList()))
                .build();
    }

    public static RecipeResponseDTO.RecipeFilteringPreviewListDTO recipeFilteringPreviewListDTO(Page<Recipe> recipeList){
        List<RecipeResponseDTO.RecipeFilteringPreviewDTO> recipeFilteringPreviewDTOList = recipeList.stream()
                .map(RecipeConverter::recipeFilteringPreviewDTO).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeFilteringPreviewListDTO.builder()
                .recipeFilteringPreviewDTOList(recipeFilteringPreviewDTOList)
                .isFirst(recipeList.isFirst())
                .isLast(recipeList.isLast())
                .listSize(recipeList.getSize())
                .totalElements(recipeList.getTotalElements())
                .totalPage(recipeList.getTotalPages())
                .build();
    }

    public static RecipeResponseDTO.RecipeCategoryFilteringPreviewDTO recipeCategoryFilteringPreviewDTO(Recipe recipe){
        List<RecipeResponseDTO.RecipeImgResponseDTO> recipeImgResponseDTOList = recipe.getRecipeImgList().stream()
                .map(RecipeConverter::toRecipeImgDTO)
                .filter(RecipeResponseDTO.RecipeImgResponseDTO::getIsThumbnail).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeCategoryFilteringPreviewDTO.builder()
                .recipeId(recipe.getId())
                .name(recipe.getName())
                .category(recipe.getCategory())
                .contents(recipe.getContents())
                .calorie(recipe.getCalorie())
                .carbohydrate(recipe.getCarbohydrate())
                .protein(recipe.getProtein())
                .fat(recipe.getFat())
                .recipImgResponseDTOList(recipeImgResponseDTOList)
                .ingredientsList(recipe.getRecipeIngredientsList().stream().map(ingredients -> ingredients.getIngredientsData().getName()).collect(Collectors.toList()))
                .build();
    }

    public static RecipeResponseDTO.RecipeCategoryFilteringPreviewListDTO recipeCategoryFilteringPreviewListDTO(Page<Recipe> recipeList){
        List<RecipeResponseDTO.RecipeCategoryFilteringPreviewDTO> recipeCategoryFilteringPreviewListDTOList = recipeList.stream()
                .map(RecipeConverter::recipeCategoryFilteringPreviewDTO).collect(Collectors.toList());

        return RecipeResponseDTO.RecipeCategoryFilteringPreviewListDTO.builder()
                .recipeCategoryFilteringPreviewDTOList(recipeCategoryFilteringPreviewListDTOList)
                .isFirst(recipeList.isFirst())
                .isLast(recipeList.isLast())
                .listSize(recipeList.getSize())
                .totalElements(recipeList.getTotalElements())
                .totalPage(recipeList.getTotalPages())
                .build();
    }
}
