package com.capstone.myrefrigerator.service.recipe;

import com.capstone.myrefrigerator.apiPayload.code.status.ErrorStatus;
import com.capstone.myrefrigerator.apiPayload.exception.handler.IngredientsHandler;
import com.capstone.myrefrigerator.apiPayload.exception.handler.RecipeHandler;
import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.domain.IngredientsData;
import com.capstone.myrefrigerator.domain.Recipe;
import com.capstone.myrefrigerator.repository.IngredientsDataRepository;
import com.capstone.myrefrigerator.repository.IngredientsRepository;
import com.capstone.myrefrigerator.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class RecipeQueryServiceImpl implements RecipeQueryService{

    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;
    private final IngredientsDataRepository ingredientsDataRepository;

    @Override
    public Page<Recipe> getRecipeList(Integer page) {
        Page<Recipe> recipePage = recipeRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")));
        return recipePage;
    }

    @Override
    public Recipe getRecipeDetail(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeHandler(ErrorStatus.RECIPE_NOT_FOUND));
        return recipe;
    }

    @Override
    public Page<Recipe> getContainingIngredientsRecipe(List<String> ingredientsList, Integer page) {
        Page<Recipe> recipePage = null;
        List<IngredientsData> tags = ingredientsList.stream()
                .map(ingredient -> ingredientsDataRepository.findByName(ingredient).orElseThrow(() -> new IngredientsHandler(ErrorStatus.INGREDIENTS_NOT_FOUND)))
                .collect(Collectors.toList());
        System.out.println("Tags test plz");
        System.out.println(tags);
        if (!tags.isEmpty()) {
            // 아이템을 검색하는 메소드 호출
            List<Recipe> recipeList = recipeRepository.findAllByRecipeIngredientsListIngredientsDataIn(tags);

            // 중복된 아이템을 아이디를 기준으로 제거
            List<Recipe> distinctItems = recipeList.stream()
                    .collect(Collectors.toMap(Recipe::getId, recipe -> recipe, (existing, replacement) -> existing))
                    .values()
                    .stream()
                    .collect(Collectors.toList());

            PageRequest pageRequest = PageRequest.of(page, 10);

            int start = (int) pageRequest.getOffset();
            int end = Math.min((start + pageRequest.getPageSize()), distinctItems.size());
            recipePage = new PageImpl<>(distinctItems.subList(start, end), pageRequest, distinctItems.size());
        }


        return recipePage;
    }

    @Override
    public Page<Recipe> searchRecipe(String name, Integer page) {
        Page<Recipe> recipePage = recipeRepository.findAllByNameContaining(name, PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")));
        return recipePage;
    }

    @Override
    public Page<Recipe> filteringRecipe(String orderType, Integer page) {
        Page<Recipe> recipePage = recipeRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, orderType)));
        return recipePage;
    }

    @Override
    public Page<Recipe> emotionRecommendRecipe(String emotion, Integer page) {
        String category = null;
        if(emotion.equals("Happy") || emotion.equals("Surprise")){
            category = "desert";
        } else{
            category = "main";
        }

        Page<Recipe> recipePage = recipeRepository.findAllByCategory(category, PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")));
        return recipePage;
    }
}
