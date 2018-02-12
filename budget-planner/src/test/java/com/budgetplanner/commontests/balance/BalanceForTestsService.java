package com.budgetplanner.commontests.balance;

import com.budgetplanner.commontests.budget.BudgetForTestsService;
import com.budgetplanner.domain.BudgetDTO;

public class BalanceForTestsService {

	public static BudgetDTO validBudget() {
		return BudgetForTestsService.validBudget();
	}

	public static BudgetDTO nullBudget() {
		return BudgetForTestsService.nullBudget();
	}
	
	public static BudgetDTO budgetWithoutIncomeCategories() {
		return BudgetForTestsService.budgetWithoutIncomeCategories();
	}
	
	public static BudgetDTO budgetWithEmptyIncomeSubCategories() {
		return BudgetForTestsService.budgetWithEmptyIncomeSubCategories();
	}
}
