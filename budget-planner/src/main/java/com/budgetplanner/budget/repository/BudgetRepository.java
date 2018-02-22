package com.budgetplanner.budget.repository;

import org.springframework.data.repository.CrudRepository;

import com.budgetplanner.domain.BudgetCompositePK;
import com.budgetplanner.domain.BudgetDTO;

public interface BudgetRepository extends CrudRepository<BudgetDTO, BudgetCompositePK> {
}
