package com.budgetplanner.commontests.budget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.budgetplanner.commontests.category.CategoryForTestsService;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.CategoryDTO;

public class BudgetForTestsService {

	public static BudgetDTO validBudget() {
		Map<Integer, List<CategoryDTO>> incomes = new HashMap<>();
		Map<Integer, List<CategoryDTO>> expenses = new HashMap<>();
		
		CategoryDTO mainJob = CategoryForTestsService.mainJob();
		
		
		return new BudgetDTO(incomes, expenses);
	}

	public static BudgetDTO nullBudget() {
		return null;
	}

	public static BudgetDTO budgetWithNullIncome() {
		Map<Integer, List<CategoryDTO>> expenses = new HashMap<>();
		
		return new BudgetDTO(null, expenses);

	}

	public static BudgetDTO budgetWithEmptyIncome() {
		Map<Integer, List<CategoryDTO>> incomes = new HashMap<>();
		Map<Integer, List<CategoryDTO>> expenses = new HashMap<>();
		
		return new BudgetDTO(incomes, expenses);
	}
}
