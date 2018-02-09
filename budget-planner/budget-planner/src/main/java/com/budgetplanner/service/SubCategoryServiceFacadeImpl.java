package com.budgetplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetplanner.domain.SubCategoryDTO;
import com.budgetplanner.subcategory.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceFacadeImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public Boolean add(SubCategoryDTO subCategoryDTO) {
		validate(subCategoryDTO);
		return subCategoryRepository.add(subCategoryDTO);
	}

	private void validate(SubCategoryDTO subCategoryDTO) {
		if (subCategoryDTO == null || subCategoryDTO.getId() == null || subCategoryDTO.getName() == null) {
			throw new IllegalArgumentException();
		}
		if(subCategoryDTO.getId() < 0 || subCategoryDTO.getId() > 200) {
			throw new IllegalArgumentException();
		}
	}

	public List<SubCategoryDTO> list() {
		return null;
	}
}
