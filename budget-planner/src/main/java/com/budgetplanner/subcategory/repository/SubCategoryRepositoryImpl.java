package com.budgetplanner.subcategory.repository;

import org.springframework.stereotype.Repository;

import com.budgetplanner.domain.SubCategoryDTO;

@Repository
public class SubCategoryRepositoryImpl implements SubCategoryRepository {

	public void add(SubCategoryDTO subCategoryDTO) {
		//TODO
	}

	@Override
	public SubCategoryDTO findById(Integer addedId) {
		return new SubCategoryDTO(0, "", 0.0);
	}

}
