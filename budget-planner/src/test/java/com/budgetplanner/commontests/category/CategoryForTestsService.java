package com.budgetplanner.commontests.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetplanner.category.constants.TypeCategory;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsRepository.*;

public class CategoryForTestsService {

	public static CategoryDTO housing() {
		List<SubCategoryDTO> subCategories = Arrays.asList(electricity());
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", subCategories, TypeCategory.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO mainJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Net Salary", new ArrayList<SubCategoryDTO>(),
				TypeCategory.INCOME);
		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithSubCategoryEmpty() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<>(), TypeCategory.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithNullSubCategory() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<>(), TypeCategory.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO incomeCategoryWithSubCategoryLowerThanZero() {
		List<SubCategoryDTO> subCategoriesWithAmountLowerThanZero = new ArrayList<>();
		subCategoriesWithAmountLowerThanZero.add(new SubCategoryDTO(11, "Sub Lower than zero", -1.0));
		CategoryDTO categoryDTO = new CategoryDTO(10, "Income Lower Than Zero", subCategoriesWithAmountLowerThanZero,
				TypeCategory.INCOME);

		return categoryDTO;
	}

}
