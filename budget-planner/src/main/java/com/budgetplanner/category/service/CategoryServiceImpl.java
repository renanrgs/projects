package com.budgetplanner.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.domain.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDTO add(CategoryDTO housing) {
		return categoryRepository.add();
	}

}
