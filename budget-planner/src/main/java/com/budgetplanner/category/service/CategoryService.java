package com.budgetplanner.category.service;

import java.util.List;

import com.budgetplanner.domain.CategoryDTO;

public interface CategoryService {

	void save(CategoryDTO categoryDTO);

	List<CategoryDTO> findAll();

	CategoryDTO findById(Integer id);

}
