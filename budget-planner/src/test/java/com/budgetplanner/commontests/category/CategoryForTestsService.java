package com.budgetplanner.commontests.category;

import java.util.ArrayList;

import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;

public class CategoryForTestsService {

	public static CategoryDTO housing() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<SubCategoryDTO>());
		return categoryDTO;
	}

}
