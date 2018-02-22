package com.budgetplanner.commontests.category;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;

import com.budgetplanner.category.constants.TypeFlow;
import com.budgetplanner.domain.CategoryDTO;

@Ignore
public class CategoryForTests {

	public static CategoryDTO mainJob() {
		CategoryDTO validCategory = new CategoryDTO();
		validCategory.setName("Main Job");
		return validCategory;
	}

	public static List<CategoryDTO> validCategoryList() {
		return Arrays.asList(new CategoryDTO("Main Job"), new CategoryDTO("Sales"), new CategoryDTO("Investments"));
	}

	public static CategoryDTO nullCategory() {
		return null;
	}

	public static CategoryDTO categoryWithNullName() {
		CategoryDTO categoryWithNullName = new CategoryDTO();
		categoryWithNullName.setName(null);
		return categoryWithNullName;
	}
	
	public static CategoryDTO housing() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", TypeFlow.EXPENSE);
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
