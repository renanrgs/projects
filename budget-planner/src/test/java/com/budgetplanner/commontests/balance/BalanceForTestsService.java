package com.budgetplanner.commontests.balance;

import com.budgetplanner.commontests.budget.BudgetForTestsService;
import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;

public class BalanceForTestsService {

	public static BalanceDTO validBalance() {
		BudgetDTO validBudget = BudgetForTestsService.validBudget();
		return new BalanceDTO(validBudget);
	}

}
