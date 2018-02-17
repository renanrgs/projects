package com.budgetplanner.commontests.category;

import static com.budgetplanner.commontests.financialmovement.FinancialMovementForTestsService.electricity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.budgetplanner.category.constants.TypeFlow;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTestsService;
import com.budgetplanner.domain.CategoryDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

public class CategoryForTestsService {

	public static CategoryDTO housing() {
		List<FinancialMovementDTO> subCategories = Arrays.asList(electricity());
		CategoryDTO categoryDTO = new CategoryDTO(1, "housing", subCategories, TypeFlow.EXPENSE);
		return categoryDTO;
	}

	public static CategoryDTO mainJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Main Job", new ArrayList<FinancialMovementDTO>(),
				TypeFlow.INCOME);
		return categoryDTO;
	}

	public static CategoryDTO menialJob() {
		CategoryDTO categoryDTO = new CategoryDTO(1, "Main Job", new ArrayList<FinancialMovementDTO>(),
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

	public static CategoryDTO leisure() {
		List<FinancialMovementDTO> subcategories = Arrays.asList(FinancialMovementForTestsService.administrativeFee());
		CategoryDTO categoryDTO = new CategoryDTO(15, "leisure", subcategories, TypeFlow.EXPENSE);
		return categoryDTO;
	}

}
