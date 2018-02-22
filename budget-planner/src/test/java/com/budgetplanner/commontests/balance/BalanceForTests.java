package com.budgetplanner.commontests.balance;

import java.util.List;

import com.budgetplanner.commontests.budget.BudgetForTests;
import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.domain.BalanceDTO;
import com.budgetplanner.domain.BudgetDTO;
import com.budgetplanner.domain.FinancialMovementDTO;

public class BalanceForTests {

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

	public static BalanceDTO validBalance() {
		BudgetDTO budget = BudgetForTests.validBudget();
		FinancialMovementDTO financialMovement = FinancialMovementForTests.validFinancialMovement();
		BalanceDTO balance = new BalanceDTO(budget , financialMovement);
		return balance;
	}
}
