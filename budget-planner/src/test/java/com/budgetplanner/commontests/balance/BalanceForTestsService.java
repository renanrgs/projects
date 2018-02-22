package com.budgetplanner.commontests.balance;

import java.util.List;

import com.budgetplanner.commontests.budget.BudgetForTests;
import com.budgetplanner.domain.BudgetDTO;

public class BalanceForTestsService {

	public static BudgetDTO validBudget() {
		return BudgetForTests.validBudget();
	}

	public static List<BudgetDTO> validBudgetList(){
		return BudgetForTests.validBudgetList();
	}
	
	public static BudgetDTO nullBudget() {
		return BudgetForTests.nullBudget();
	}
	
	public static BudgetDTO budgetWithoutIncomeCategories() {
		return BudgetForTests.budgetWithoutIncomeCategories();
	}
	
	public static BudgetDTO budgetWithEmptyIncomeSubCategories() {
		return BudgetForTests.budgetWithEmptyIncomeSubCategories();
	}
}
