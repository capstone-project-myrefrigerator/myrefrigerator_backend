package com.capstone.myrefrigerator.service.ingredients;

import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.repository.IngredientsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class IngredientsQueryServiceImpl implements IngredientsQueryService{

    private final IngredientsRepository ingredientsRepository;

    @Override
    public Page<Ingredients> getMyIngredientsList(Integer page) {
        Page<Ingredients> ingredientsPage = ingredientsRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id")));
        return ingredientsPage;
    }
}
