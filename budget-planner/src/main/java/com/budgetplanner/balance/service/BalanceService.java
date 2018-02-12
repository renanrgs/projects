package com.budgetplanner.balance.service;

import java.util.List;

import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;

public interface BalanceService {

	BalanceDTO calculateTotal(BudgetDTO budgetDTO);

	List<BalanceDTO> list(List<BudgetDTO> validBudgetList);

}
