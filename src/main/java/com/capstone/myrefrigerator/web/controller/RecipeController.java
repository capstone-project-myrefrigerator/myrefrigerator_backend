package com.capstone.myrefrigerator.web.controller;

import com.capstone.myrefrigerator.apiPayload.ApiResponse;
import com.capstone.myrefrigerator.converter.RecipeConverter;
import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.domain.Recipe;
import com.capstone.myrefrigerator.service.ingredients.IngredientsCommandService;
import com.capstone.myrefrigerator.service.ingredients.IngredientsQueryService;
import com.capstone.myrefrigerator.service.recipe.RecipeQueryService;
import com.capstone.myrefrigerator.web.dto.RecipeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@Tag(name = "Recipe", description = "Recipe 관련 API")
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeQueryService recipeQueryService;
    private final IngredientsQueryService ingredientsQueryService;
    private final IngredientsCommandService ingredientsCommandService;

    @GetMapping("/list")
    @Operation(summary = "전체 레시피 조회 API", description = "전체 레시피 정보 조회를 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요."),
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.RecipePreviewListDTO> getRecipeList(@RequestParam Integer page){
        Page<Recipe> recipePage = recipeQueryService.getRecipeList(page - 1);
        return ApiResponse.onSuccess(RecipeConverter.recipePreviewListDTO(recipePage));
    }

    @GetMapping("/{recipeId}")
    @Operation(summary = "레시피 조회 API", description = "레시피 정보 조회를 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "recipeId", description = "조회를 원하는 레시피 id."),
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.RecipeDetailResponseDTO> getRecipeDetail(@PathVariable("recipeId") Long recipeId){
        Recipe recipe = recipeQueryService.getRecipeDetail(recipeId);
        return ApiResponse.onSuccess(RecipeConverter.recipeDetailResponseDTO(recipe));
    }

    @GetMapping("/ingredients/list")
    @Operation(summary = "전체 재료 조회 API", description = "전체 재료 정보 조회를 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요."),
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.IngredientsPreviewListDTO> getIngredientsList(@RequestParam Integer page){
        Page<Ingredients> ingredientsPage = ingredientsQueryService.getMyIngredientsList(page - 1);
        return ApiResponse.onSuccess(RecipeConverter.ingredientsPreviewListDTO(ingredientsPage));
    }

    @GetMapping("/containing/ingredients/list")
    @Operation(summary = "재료 포함 레시피 조회 API", description = "특정 재료를 포함한 레시피 정보 조회를 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요."),
            @Parameter(name = "ingredientNames", description = "재료 이름을 입력해주세요.")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.RecipeContainingIngredientsResultListDTO> getIngredientsContainingRecipeList(@RequestParam(name = "page") Integer page,
                                                                                                                      @RequestParam(name = "ingredientNames") List<String> ingredientNames){
        Page<Recipe> recipePage = recipeQueryService.getContainingIngredientsRecipe(ingredientNames, page - 1);
        return ApiResponse.onSuccess(RecipeConverter.recipeContainingIngredientsResultListDTO(recipePage));
    }

    @GetMapping("/search/list")
    @Operation(summary = "레시피 검색 API", description = "레시피 검색을 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요."),
            @Parameter(name = "search", description = "검색어를 입력해주세요.")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.RecipeSearchPreviewListDTO> searchRecipe(@RequestParam("search") String search,
                                                                                  @RequestParam("page") Integer page){
        Page<Recipe> recipePage = recipeQueryService.searchRecipe(search, page - 1);
        return ApiResponse.onSuccess(RecipeConverter.recipeSearchPreviewListDTO(recipePage));
    }

    @DeleteMapping("/delete/ingredients/{ingredientsId}")
    @Operation(summary = "재료 삭제 API", description = "재료 삭제를 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "ingredientsId", description = "삭제를 원하는 재료 id."),
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.IngredientsDeleteResultDTO> deleteIngredients(@PathVariable("ingredientsId") Long ingredientsId){
        Ingredients ingredients = ingredientsCommandService.deleteIngredients(ingredientsId);
        return ApiResponse.onSuccess(RecipeConverter.ingredientsDeleteResultDTO(ingredients));
    }


    @GetMapping("/filtering/list")
    @Operation(summary = "레시피 정렬 API", description = "레시피 정렬을 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요."),
            @Parameter(name = "orderType", description = "정렬 조건을 입력해주세요.(calorie, fat, carbohydrate, protein)")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.RecipeFilteringPreviewListDTO> getFilteringRecipe(@RequestParam("orderType") String orderType,
                                                                                           @RequestParam("page") Integer page){
        Page<Recipe> recipePage = recipeQueryService.filteringRecipe(orderType, page - 1);
        return ApiResponse.onSuccess(RecipeConverter.recipeFilteringPreviewListDTO(recipePage));
    }

    @GetMapping("/emotion/filtering/list")
    @Operation(summary = "감정 인식 기반 레시피 추천 API", description = "감정 인식 기반 레시피 추천을 위한 API이다.")
    @Parameters(value = {
            @Parameter(name = "page", description = "페이지 번호, 1 이상의 숫자를 입력해주세요."),
            @Parameter(name = "emotion", description = "감정을 입력해주세요.(Angry, Disgust, Fear, Happy, Sad, Surprise, Neutral)")
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<RecipeResponseDTO.RecipeCategoryFilteringPreviewListDTO> getEmotionCategoryRecipe(@RequestParam("emotion") String emotion,
                                                                                                         @RequestParam("page") Integer page){
        Page<Recipe> recipePage = recipeQueryService.emotionRecommendRecipe(emotion, page - 1);
        return ApiResponse.onSuccess(RecipeConverter.recipeCategoryFilteringPreviewListDTO(recipePage));
    }
}
