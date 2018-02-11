package com.budgetplanner.subcategory.repository;

import java.util.HashSet;
import java.util.Set;

import com.budgetplanner.domain.SubCategoryDTO;

public interface SubCategoryRepository {

	public static final Set<SubCategoryDTO> SUBCATEGORY_DATABASE = new HashSet<>();

	void add(SubCategoryDTO electricity);

	SubCategoryDTO findById(Integer addedId);

}
