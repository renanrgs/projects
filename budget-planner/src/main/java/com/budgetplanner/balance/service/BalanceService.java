package com.budgetplanner.balance.service;

import java.util.List;

import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

public interface BalanceService {

	BalanceDTO calculateTotal(List<FinancialMovementDTO> financialMovements);

	List<BalanceDTO> list(List<BudgetDTO> validBudgetList);

}
