package com.budgetplanner.commontests.budget;

import org.junit.Ignore;

import com.budgetplanner.domain.BudgetDTO;

@Ignore
public class BudgetForTestsRepository {

	public static BudgetDTO validBudget() {
		BudgetDTO budgetDTO = new BudgetDTO(1, 2018);
		return budgetDTO;
	}

	public static BudgetDTO nullBudget() {
		return null;
	}

	public static BudgetDTO budgetWithNullIncome() {
		return new BudgetDTO();

	}

	public static BudgetDTO budgetWithEmptyIncome() {

		return new BudgetDTO();
	}

}
