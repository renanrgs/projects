package com.budgetplanner.budget.service;

import java.util.List;

import com.budgetplanner.domain.BudgetDTO;

public interface BudgetService {

	void save(BudgetDTO validBudget);

	List<BudgetDTO> findAll();

}
