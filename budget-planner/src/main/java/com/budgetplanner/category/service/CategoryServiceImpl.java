package com.budgetplanner.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.category.repository.CategoryRepository;
import com.budgetplanner.domain.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	private void validate(CategoryDTO categoryDTO) {
		Optional.ofNullable(categoryDTO).orElseThrow(IllegalArgumentException::new);
		Optional.ofNullable(categoryDTO.getName()).orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public void save(CategoryDTO categoryDTO) {
		validate(categoryDTO);
		categoryRepository.save(categoryDTO);
	}

	@Override
	public List<CategoryDTO> findAll() {
		return (List<CategoryDTO>) categoryRepository.findAll();
	}

	@Override
	public CategoryDTO findById(Integer id) {
		return categoryRepository.findOne(id);
	}

}
