package com.budgetplanner.commontests.budget;

import org.junit.Ignore;

import com.budgetplanner.commontests.financialmovement.FinancialMovementForTests;
import com.budgetplanner.domain.BudgetDTO;

@Ignore
public class BudgetForTestsService {

	public static BudgetDTO validBudget() {
		BudgetDTO budgetDTO = new BudgetDTO(1, 2018);
		budgetDTO.setFinancialMovements(FinancialMovementForTests.financialMovements());
		return budgetDTO;
	}
	
	public static BudgetDTO validBudgetWithoutIncome() {
		BudgetDTO budgetDTO = new BudgetDTO(1, 2018);
		budgetDTO.setFinancialMovements(FinancialMovementForTests.financialMovementsWithoutIncome());
		return budgetDTO;
	}

	public static BudgetDTO budgetWithoutExpense() {
		BudgetDTO budgetDTO = new BudgetDTO(1, 2018);
		budgetDTO.setFinancialMovements(FinancialMovementForTests.financialMovementsWithoutExpense());
		return budgetDTO;
	}
	
	public static BudgetDTO nullBudget() {
		return null;
	}

}
