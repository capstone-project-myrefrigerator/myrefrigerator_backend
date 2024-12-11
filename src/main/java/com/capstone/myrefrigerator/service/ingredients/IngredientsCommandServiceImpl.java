package com.capstone.myrefrigerator.service.ingredients;

import com.capstone.myrefrigerator.apiPayload.code.status.ErrorStatus;
import com.capstone.myrefrigerator.apiPayload.exception.handler.IngredientsHandler;
import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.repository.IngredientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class IngredientsCommandServiceImpl implements IngredientsCommandService{

    private final IngredientsRepository ingredientsRepository;

    @Override
    @Transactional
    public Ingredients deleteIngredients(Long ingredientsId) {

        Ingredients ingredients = ingredientsRepository.findById(ingredientsId).orElseThrow(() -> new IngredientsHandler(ErrorStatus.INGREDIENTS_NOT_FOUND));
        ingredientsRepository.delete(ingredients);
        return ingredients;
    }
}
