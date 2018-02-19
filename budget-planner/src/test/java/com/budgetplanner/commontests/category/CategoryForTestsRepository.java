package com.budgetplanner.commontests.category;

import org.junit.Ignore;

import com.budgetplanner.domain.CategoryDTO;

@Ignore
public class CategoryForTestsRepository {

	public static CategoryDTO validCategory() {
		CategoryDTO validCategory = new CategoryDTO();
		validCategory.setName("Main Job");
		return validCategory;
	}

}
