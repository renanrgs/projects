package com.budgetplanner.budget.repository;

import com.budgetplanner.domain.BudgetDTO;

public interface BudgetRepository {

	void insert(BudgetDTO validBudget);

}
