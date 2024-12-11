package com.capstone.myrefrigerator.repository;

import com.capstone.myrefrigerator.domain.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    Optional<Ingredients> findByName(String name);
}
