package com.budgetplanner.commontests.category;

import com.budgetplanner.category.constants.TypeFlow;
import com.budgetplanner.domain.CategoryDTO;

public class CategoryForTestsService {

	public static CategoryDTO housing() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO mainJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Main Job", TypeFlow.INCOME);
		return categoryDTO;
	}

	public static CategoryDTO menialJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Main Job", TypeFlow.INCOME);
		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithSubCategoryEmpty() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithNullSubCategory() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO leisure() {
		CategoryDTO categoryDTO = new CategoryDTO(15, "leisure", TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO categoryWithNullFlow() {
		CategoryDTO categoryDTO = new CategoryDTO(15, "leisure", null);
		return categoryDTO;
	}

}
