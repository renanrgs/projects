package com.budgetplanner.balance.service;

import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;

public interface BalanceService {

	BalanceDTO calculate(BudgetDTO budgetDTO);

}
