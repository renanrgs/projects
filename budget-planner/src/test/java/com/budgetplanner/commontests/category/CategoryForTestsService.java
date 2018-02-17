package com.budgetplanner.commontests.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetplanner.category.constants.TypeFlow;
import com.budgetplanner.commontests.subcategory.SubCategoryForTestsService;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.SubCategoryDTO;
import static com.budgetplanner.commontests.subcategory.SubCategoryForTestsService.*;

public class CategoryForTestsService {

	public static CategoryDTO housing() {
		List<SubCategoryDTO> subCategories = Arrays.asList(electricity());
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", subCategories, TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO mainJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Net Salary", new ArrayList<SubCategoryDTO>(),
				TypeFlow.INCOME);
		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithSubCategoryEmpty() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<>(), TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithNullSubCategory() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", new ArrayList<>(), TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO incomeCategoryWithSubCategoryLowerThanZero() {
		List<SubCategoryDTO> subCategoriesWithAmountLowerThanZero = new ArrayList<>();
		subCategoriesWithAmountLowerThanZero.add(new SubCategoryDTO(11, "Sub Lower than zero", -1.0));
		CategoryDTO categoryDTO = new CategoryDTO(10, "Income Lower Than Zero", subCategoriesWithAmountLowerThanZero,
				TypeFlow.INCOME);

		return categoryDTO;
	}

	public static CategoryDTO expenseCategoryWithSubCategoryLowerThanZero() {
		List<SubCategoryDTO> subCategoriesWithAmountLowerThanZero = new ArrayList<>();
		subCategoriesWithAmountLowerThanZero.add(new SubCategoryDTO(11, "Sub Lower than zero", -1.0));
		CategoryDTO categoryDTO = new CategoryDTO(10, "Income Lower Than Zero", subCategoriesWithAmountLowerThanZero,
				TypeFlow.EXPENSE);

		return categoryDTO;

	}

	public static CategoryDTO leisure() {
		List<SubCategoryDTO> subcategories = Arrays.asList(SubCategoryForTestsService.administrativeFee());
		CategoryDTO categoryDTO = new CategoryDTO(15, "leisure", subcategories, TypeFlow.EXPENSE);
		return categoryDTO;
	}

}
