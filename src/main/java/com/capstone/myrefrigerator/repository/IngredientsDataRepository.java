package com.capstone.myrefrigerator.repository;

import com.capstone.myrefrigerator.domain.Ingredients;
import com.capstone.myrefrigerator.domain.IngredientsData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientsDataRepository extends JpaRepository<IngredientsData, Long> {

    Optional<IngredientsData> findByName(String name);
}
