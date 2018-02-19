package com.budgetplanner.category.repository;

import org.springframework.data.repository.CrudRepository;

import com.budgetplanner.domain.CategoryDTO;

public interface CategoryRepository extends CrudRepository<CategoryDTO, Integer> {

}
